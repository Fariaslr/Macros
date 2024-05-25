package com.mycompany.macros;

import com.itextpdf.io.IOException;
import com.itextpdf.io.image.*;
import com.itextpdf.kernel.color.*;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.border.*;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.*;
import com.mycompany.enums.*;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import com.mycompany.models.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

public class PDF {

    Treino treino;
    Consulta consulta;
    Plano plano;
    Paciente paciente;
    EducadorFisico educadorFisico;
    float fontSize = 10f;
    private static final int margin = 10;
    private static final DeviceRgb MARINHO = new DeviceRgb(0, 20, 118);

    public void gerarPDF(Treino treino) throws FileNotFoundException {

        this.treino = treino;
        this.consulta = treino.getConsulta();
        this.plano = treino.getConsulta().getPlano();
        this.paciente = treino.getConsulta().getPlano().getPaciente();
        this.educadorFisico = treino.getEducadorFisico();

        String path = "src/main/resources/relatorios/Plano de treino " + paciente.getNome() + " " + new SimpleDateFormat("dd-MM-yyyy").format(treino.getDataTreino()) + ".pdf";
        try {
            PdfWriter pdfWriter = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A4);

            try (Document document = new Document(pdfDocument)) {

                document.add(getCabecalho());
                document.add(getDivider());
                document.add(getTituloSection("Dados pessoais"));
                document.add(getInfoPaciente());
                document.add(getTituloSection("Endereço"));
                document.add(getEndereco());
                document.add(getTituloSection("Dados específicos"));
                document.add(getDadosEspecificos());

                for (TreinoExercicio treinoExercicio : treino.getTreinosExercicios()) {
                    document.add(new AreaBreak());
                    document.add(getExercicios(treinoExercicio));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!");
        }
    }

    private Table getCabecalho() {

        Table tabela = new Table(3);
        tabela.setWidth(UnitValue.createPercentValue(100));
        tabela.setMargin(margin);

        tabela.addCell(getContainer("Objetivo", plano.getObjetivo().getDESCRICAO()));
        tabela.addCell(getContainer("Educador físico", educadorFisico.getNome()
                + " " + educadorFisico.getSobrenome()
                + " - Cref " + educadorFisico.getCref()));
        tabela.addCell(getContainer("Criado em", new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss ").format(treino.getDataTreino())));

        return tabela;
    }

    private Table getDivider() {

        Table divider = new Table(1);
        Border gb = new SolidBorder(DeviceGray.GRAY, 0.1f);

        divider.setWidth(UnitValue.createPercentValue(100));
        divider.setBorder(gb);

        return divider;
    }

    private Table getTituloSection(String tituloContainer) {

        Table tabelaCabecalho = new Table(1);
        tabelaCabecalho.setMarginTop(margin);
        tabelaCabecalho.setMarginBottom(margin);

        tabelaCabecalho.setWidth(UnitValue.createPercentValue(100));
        tabelaCabecalho.addCell(getTituloContainer(tituloContainer)
                .setFontSize(10)
                .setBackgroundColor(MARINHO)
                .setFontColor(Color.WHITE));

        return tabelaCabecalho;
    }

    private Table getInfoPaciente() {
        getTituloSection("Dados pessoais");
        Table tabelaPaciente = new Table(2);
        setMarginTabela(tabelaPaciente);

        tabelaPaciente.addCell(getContainer("CPF: ", paciente.getCpf() == null ? " - " : paciente.getCpf()));
        tabelaPaciente.addCell(getContainer("Nome: ", paciente.getNome() == null ? " - " : paciente.getNome() + " " + paciente.getSobrenome()));
        tabelaPaciente.addCell(getContainer("Data de Nascimento: ", paciente.getDataNascimento() == null ? " - " : new SimpleDateFormat("dd/MM/yyyy").format(paciente.getDataNascimento()) + " (" + paciente.calcularIdade() + " anos)"));
        tabelaPaciente.addCell(getContainer("Sexo: ", paciente.getSexo() == null ? " - " : paciente.getSexo().getSEXO()));
        tabelaPaciente.addCell(getContainer("Telefone: ", paciente.getTelefone() == null ? " - " : paciente.getTelefone()));
        tabelaPaciente.addCell(getContainer("Email: ", paciente.getEmail() == null ? " - " : paciente.getEmail()));

        return tabelaPaciente;
    }

    private Table getEndereco() {

        Table tabelaEndereco = new Table(new float[]{1, 5});
        tabelaEndereco.setWidth(UnitValue.createPercentValue(100));
        setMarginTabela(tabelaEndereco);
        tabelaEndereco.setMarginBottom(margin);

        Endereco endereco = paciente.getEndereco();
        tabelaEndereco.addCell(getContainer("CEP: ", endereco != null && endereco.getCep() != null ? endereco.getCep() : " - "));
        tabelaEndereco.addCell(getContainer("Logradouro: ", endereco != null && endereco.getLogradouro() != null ? endereco.getLogradouro() : " - "));
        tabelaEndereco.addCell(getContainer("Número: ", endereco != null && endereco.getNumero() != 0 ? String.valueOf(endereco.getNumero()) : " - "));
        tabelaEndereco.addCell(getContainer("Complemento: ", endereco != null && endereco.getComplemento() != null ? endereco.getComplemento() : " - "));
        tabelaEndereco.addCell(getContainer("Bairro: ", endereco != null && endereco.getBairro() != null ? endereco.getBairro() : " - "));
        tabelaEndereco.addCell(getContainer("Cidade: ", endereco != null && endereco.getCidade() != null ? endereco.getCidade() : " - "));
        tabelaEndereco.addCell(getContainer("Estado: ", endereco != null && endereco.getEstado() != null ? endereco.getEstado() : " - "));
        tabelaEndereco.addCell(getContainer("País: ", endereco != null && endereco.getPais() != null ? endereco.getPais() : " - "));

        return tabelaEndereco;
    }

    private Table getDadosEspecificos() {
        Table tabelaDadosEspecificos = new Table(4);
        tabelaDadosEspecificos.setWidth(UnitValue.createPercentValue(100));

        tabelaDadosEspecificos.addCell(getContainer("Calorias Diárias: ", String.format("%.0f", consulta.calcularCaloriasDieta()) + " Kcal"));
        tabelaDadosEspecificos.addCell(getContainer("Altura: ", consulta.getAltura() == 0 ? " - " : String.format("%.0f", consulta.getAltura()) + " cm"));
        tabelaDadosEspecificos.addCell(getContainer("Peso: ", consulta.getPeso() == 0 ? " - " : String.format("%.3f", consulta.getPeso()) + " kg"));
        tabelaDadosEspecificos.addCell(getContainer("Nível atividade: ", plano.getNivelAtividadeFisica().getDESCRICAO()));
        tabelaDadosEspecificos.addCell(getContainer("Percentual de gordura ", consulta.calcularPercentualGordura() == -450 ? " - " : String.format("%.2f", consulta.calcularPercentualGordura()) + " %"));
        tabelaDadosEspecificos.addCell(getContainer("Medida do Pescoço: ", consulta.getMedidaPescoco() == 0 ? " - " : String.format("%.0f", consulta.getMedidaPescoco()) + " cm"));
        tabelaDadosEspecificos.addCell(getContainer("Medida da Cintura: ", consulta.getMedidaCintura() == 0 ? " - " : String.format("%.0f", consulta.getMedidaCintura()) + " cm"));
        if (paciente.getSexo() == Sexo.FEMININO) {
            tabelaDadosEspecificos.addCell(getContainer("Circunferência da Quadril: ", consulta.getMedidaQuadril() == 0 ? " - " : String.valueOf(consulta.getMedidaQuadril()) + " cm"));
        }
        tabelaDadosEspecificos.addCell(getContainer("Número de Refeições: ", consulta.getNumeroRefeicoes() == 0 ? " - " : String.valueOf(consulta.getNumeroRefeicoes())));

        return tabelaDadosEspecificos;
    }

    private Table getExercicios(TreinoExercicio treinoExercicio) {

        Table tabelaExercicio = new Table(new float[]{1, 2});
        tabelaExercicio.setWidth(UnitValue.createPercentValue(100));
        tabelaExercicio.setBorder(Border.NO_BORDER);

        tabelaExercicio.addCell(getTituloExercicio(treinoExercicio.getExercicio().getNome(), treinoExercicio.getDivisao().getAGRUPAMENTO()));
        tabelaExercicio.addCell(getLeftCell(treinoExercicio));
        tabelaExercicio.addCell(getRightCell(treinoExercicio));

        return tabelaExercicio;
    }

    private Cell getContainer(String titulo, String descricao) {
        Cell cell = new Cell();
        cell.setPadding(5);
        cell.setBorder(Border.NO_BORDER);

        Table tabelaDados = new Table(1);
        tabelaDados.setBorder(Border.NO_BORDER);

        tabelaDados.addCell(getTituloContainer(titulo));
        tabelaDados.addCell(getDescricaoContainer(descricao));

        cell.add(tabelaDados);

        return cell;
    }

    private Cell getTituloContainer(String titulo) {
        return new Cell().add(new Paragraph(titulo)).setFontSize(fontSize).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.JUSTIFIED);
    }

    private Cell getDescricaoContainer(String descricao) {
        return new Cell().add(descricao).setBorder(Border.NO_BORDER).setFontSize(fontSize);
    }

    private void setMarginTabela(Table tabela) {
        tabela.setMarginLeft(margin).setMarginRight(margin);
    }

    private Cell getTituloExercicio(String nomeExercicio, String musculoAgrupamento) {
        Cell tituloCell = new Cell(2, 10).add(nomeExercicio + " - " + musculoAgrupamento
        )
                .setBorder(Border.NO_BORDER)
                .setBold()
                .setFontSize(14f)
                .setBackgroundColor(MARINHO)
                .setFontColor(Color.WHITE)
                .setTextAlignment(TextAlignment.CENTER)
                .setPadding(10);
        return tituloCell;
    }

    private Cell getLeftCell(TreinoExercicio treinoExercicio) {
        Cell leftCell = new Cell()
                .setBorder(Border.NO_BORDER)
                .setWidth(UnitValue.createPercentValue(50))
                .setPadding(10);
        try {
            ImageData imageData = ImageDataFactory.create(new URL(treinoExercicio.getExercicio().getUrlFoto()));
            Image image = new Image(imageData);
            leftCell.add(image);
        } catch (MalformedURLException e) {
            leftCell.add(new Paragraph("Imagem não disponível").setBorder(Border.NO_BORDER));
        } catch (IOException e) {
            leftCell.add(new Paragraph("Erro ao carregar a imagem").setBorder(Border.NO_BORDER));
        }

        return leftCell;
    }

    private Cell getRightCell(TreinoExercicio treinoExercicio) {
        Cell rightCell = new Cell().setBorder(Border.NO_BORDER);

        Table tabela = new Table(1);
        tabela.addCell(getContainer("Descrição do exercicio", treinoExercicio.getExercicio().getDescricao()));

        rightCell.add(tabela);
        rightCell.add(getRodape(treinoExercicio));

        return rightCell;
    }

    private Table getRodape(TreinoExercicio treinoExercicio) {
        Table rodape = new Table(4)
                .setBorder(Border.NO_BORDER);
        rodape.setWidth(UnitValue.createPercentValue(100));

        rodape.addCell(getContainerColor("Carga", String.valueOf(treinoExercicio.getCarga()) + " kg"));
        rodape.addCell(getContainerColor("Séries", String.valueOf(treinoExercicio.getSeries())));
        rodape.addCell(getContainerColor("Repetições", String.valueOf(treinoExercicio.getRepeticoes())));
        rodape.addCell(getContainerColor("Intervalo", (treinoExercicio.converterMinutos() == 0 ? " " : treinoExercicio.converterMinutos() + " min")
                + (treinoExercicio.mostrarSegundos() == 0 ? "" : treinoExercicio.mostrarSegundos() + " seg")));

        return rodape;
    }

    private Cell getContainerColor(String titulo, String descricao) {
        Cell cell = new Cell()
                .setPadding(5)
                .setBorder(Border.NO_BORDER);

        Table tabelaDados = new Table(1);
        tabelaDados.setBorder(Border.NO_BORDER);

        tabelaDados.addCell(getTituloContainerColor(titulo));
        tabelaDados.addCell(getDescricaoContainerColor(descricao));

        cell.add(tabelaDados);

        return cell;
    }

    private Cell getTituloContainerColor(String titulo) {
        return new Cell().add(titulo)
                .setFontSize(fontSize)
                .setBold()
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(MARINHO)
                .setFontColor(Color.WHITE)
                .setPadding(5);
    }

    private Cell getDescricaoContainerColor(String descricao) {
        return new Cell().add(descricao)
                .setBorder(Border.NO_BORDER)
                .setFontSize(fontSize)
                .setTextAlignment(TextAlignment.CENTER)
                .setPadding(5);
    }

}
