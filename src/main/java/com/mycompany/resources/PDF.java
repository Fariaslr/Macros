package com.mycompany.resources;

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
    private static final int MARGIN = 10;
    private static final DeviceRgb MARROM_ESCURO = new DeviceRgb(124, 76, 22);
    private static final float IMAGE_WIDTH = 300f;  // Largura fixa da imagem
    private static final float IMAGE_HEIGHT = 300f;

    public void gerarPDF(Treino treino) throws FileNotFoundException {

        this.treino = treino;
        this.consulta = treino.getConsulta();
        this.plano = treino.getConsulta().getPlano();
        this.paciente = treino.getConsulta().getPlano().getPaciente();
        this.educadorFisico = treino.getEducadorFisico();

        String path = "src/main/resources/relatorios/Plano de treino " + paciente.getNome() + " " + new SimpleDateFormat("dd-MM-yyyy hh.mm.ss").format(treino.getDataTreino()) + ".pdf";
        try {
            PdfWriter pdfWriter = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A4);

            try (Document document = new Document(pdfDocument)) {

                document.add(criarTituloSessao("Plano de treino"));
                document.add(constroiCabecalho());
                document.add(insereDivider());
                document.add(criarTituloSessao("Dados pessoais"));
                document.add(mostrarDadosPaciente());
                document.add(criarTituloSessao("Endereço"));
                document.add(mostrarEnderecoPaciente());
                document.add(insereDivider());
                document.add(criarTituloSessao("Dados específicos"));
                document.add(mostrarDadosEspecificos());

                for (TreinoExercicio treinoExercicio : treino.getTreinosExercicios()) {
                    document.add(new AreaBreak());
                    document.add(montarPaginaExercicio(treinoExercicio));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!");
        }
    }

    private Table constroiCabecalho() {

        Table tabela = new Table(3)
                .setWidth(UnitValue.createPercentValue(100))
                .setMarginBottom(MARGIN)
                .setMarginLeft(MARGIN)
                .setMarginRight(MARGIN);

        tabela.addCell(montarContainer("Objetivo", plano.getObjetivo().getDESCRICAO()));
        tabela.addCell(montarContainer("Educador físico", educadorFisico.getNome() + " " + educadorFisico.getSobrenome()
                + " - Cref " + educadorFisico.getCref()));
        tabela.addCell(montarContainer("Criado em", new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss ").format(treino.getDataTreino())));

        return tabela;
    }

    private Table insereDivider() {

        Table divider = new Table(1);
        Border gb = new SolidBorder(DeviceGray.GRAY, 0.1f);

        divider.setWidth(UnitValue.createPercentValue(100));
        divider.setBorder(gb);

        return divider;
    }

    private Table criarTituloSessao(String tituloContainer) {

        Table tabelaCabecalho = new Table(1);
        tabelaCabecalho.setMarginTop(MARGIN);
        tabelaCabecalho.setMarginBottom(MARGIN);

        tabelaCabecalho.setWidth(UnitValue.createPercentValue(100));
        tabelaCabecalho.addCell(configuraTituloContainer(tituloContainer)
                .setFontSize(10)
                .setBackgroundColor(MARROM_ESCURO)
                .setFontColor(Color.WHITE));

        return tabelaCabecalho;
    }

    private Table mostrarDadosPaciente() {
        criarTituloSessao("Dados pessoais");
        Table tabelaPaciente = new Table(2);
        setMarginTabela(tabelaPaciente);

        tabelaPaciente.addCell(montarContainer("CPF: ", paciente.getCpf() == null ? " - " : paciente.getCpf()));
        tabelaPaciente.addCell(montarContainer("Nome: ", paciente.getNome() == null ? " - " : paciente.getNome() + " " + paciente.getSobrenome()));
        tabelaPaciente.addCell(montarContainer("Data de Nascimento: ", paciente.getDataNascimento() == null ? " - " : new SimpleDateFormat("dd/MM/yyyy").format(paciente.getDataNascimento()) + " (" + paciente.calcularIdade() + " anos)"));
        tabelaPaciente.addCell(montarContainer("Sexo: ", paciente.getSexo() == null ? " - " : paciente.getSexo().getSEXO()));
        tabelaPaciente.addCell(montarContainer("Telefone: ", paciente.getTelefone() == null ? " - " : paciente.getTelefone()));
        tabelaPaciente.addCell(montarContainer("Email: ", paciente.getEmail() == null ? " - " : paciente.getEmail()));

        return tabelaPaciente;
    }

    private Table mostrarEnderecoPaciente() {

        Table tabelaEndereco = new Table(2);
        tabelaEndereco.setWidth(UnitValue.createPercentValue(100));
        setMarginTabela(tabelaEndereco);
        tabelaEndereco.setMarginBottom(MARGIN);

        Endereco endereco = paciente.getEndereco();
        tabelaEndereco.addCell(montarContainer("CEP: ", endereco != null && endereco.getCep() != null ? endereco.getCep() : " - "));
        tabelaEndereco.addCell(montarContainer("Logradouro: ", endereco != null && endereco.getLogradouro() != null ? endereco.getLogradouro() : " - "));
        tabelaEndereco.addCell(montarContainer("Número: ", endereco != null && endereco.getNumero() != 0 ? String.valueOf(endereco.getNumero()) : " - "));
        tabelaEndereco.addCell(montarContainer("Complemento: ", endereco != null && endereco.getComplemento() != null ? endereco.getComplemento() : " - "));
        tabelaEndereco.addCell(montarContainer("Bairro: ", endereco != null && endereco.getBairro() != null ? endereco.getBairro() : " - "));
        tabelaEndereco.addCell(montarContainer("Cidade: ", endereco != null && endereco.getCidade() != null ? endereco.getCidade() : " - "));
        tabelaEndereco.addCell(montarContainer("Estado: ", endereco != null && endereco.getEstado() != null ? endereco.getEstado() : " - "));
        tabelaEndereco.addCell(montarContainer("País: ", endereco != null && endereco.getPais() != null ? endereco.getPais() : " - "));

        return tabelaEndereco;
    }

    private Table mostrarDadosEspecificos() {
        Table tabelaDadosEspecificos = new Table(4);
        tabelaDadosEspecificos.setWidth(UnitValue.createPercentValue(100));

        tabelaDadosEspecificos.addCell(montarContainer("Calorias Diárias: ", String.format("%.0f", consulta.calcularCaloriasDieta()) + " Kcal"));
        tabelaDadosEspecificos.addCell(montarContainer("Altura: ", consulta.getAltura() == 0 ? " - " : String.format("%.0f", consulta.getAltura()) + " cm"));
        tabelaDadosEspecificos.addCell(montarContainer("Peso: ", consulta.getPeso() == 0 ? " - " : String.format("%.3f", consulta.getPeso()) + " kg"));
        tabelaDadosEspecificos.addCell(montarContainer("Nível atividade: ", plano.getNivelAtividadeFisica().getDESCRICAO()));
        tabelaDadosEspecificos.addCell(montarContainer("Percentual de gordura ", consulta.calcularPercentualGordura() == -450 ? " - " : String.format("%.2f", consulta.calcularPercentualGordura()) + " %"));
        tabelaDadosEspecificos.addCell(montarContainer("Medida do Pescoço: ", consulta.getMedidaPescoco() == 0 ? " - " : String.format("%.0f", consulta.getMedidaPescoco()) + " cm"));
        tabelaDadosEspecificos.addCell(montarContainer("Medida da Cintura: ", consulta.getMedidaCintura() == 0 ? " - " : String.format("%.0f", consulta.getMedidaCintura()) + " cm"));
        if (paciente.getSexo() == Sexo.FEMININO) {
            tabelaDadosEspecificos.addCell(montarContainer("Circunferência da Quadril: ", consulta.getMedidaQuadril() == 0 ? " - " : String.valueOf(consulta.getMedidaQuadril()) + " cm"));
        }
        //StabelaDadosEspecificos.addCell(getContainer("Número de Refeições: ", consulta.getNumeroRefeicoes() == 0 ? " - " : String.valueOf(consulta.getNumeroRefeicoes())));

        return tabelaDadosEspecificos;
    }

    private Table montarPaginaExercicio(TreinoExercicio treinoExercicio) {

        Table tabelaExercicio = new Table(1).setWidth(UnitValue.createPercentValue(100)).setBorder(Border.NO_BORDER);

        tabelaExercicio.addCell(getTituloExercicio(treinoExercicio.getExercicio().getNome(), treinoExercicio.getDivisao().getAGRUPAMENTO()));
        tabelaExercicio.addCell(getImageExercicio(treinoExercicio));
        tabelaExercicio.addCell(carregarExecucaoExercicio(treinoExercicio));

        return tabelaExercicio;
    }

    private Cell montarContainer(String titulo, String descricao) {
        Cell cell = new Cell()
                .setPadding(5)
                .setBorder(Border.NO_BORDER);

        Table tabelaDados = new Table(1)
                .setBorder(Border.NO_BORDER);

        tabelaDados.addCell(configuraTituloContainer(titulo));
        tabelaDados.addCell(getDescricaoContainer(descricao));

        cell.add(tabelaDados);

        return cell;
    }

    private Cell configuraTituloContainer(String titulo) {
        return new Cell().add(new Paragraph(titulo)).setFontSize(fontSize).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.JUSTIFIED);
    }

    private Cell getDescricaoContainer(String descricao) {
        return new Cell().add(descricao).setBorder(Border.NO_BORDER).setFontSize(fontSize).setBold();
    }

    private void setMarginTabela(Table tabela) {
        tabela.setMarginLeft(MARGIN).setMarginRight(MARGIN);
    }

    private Cell getTituloExercicio(String nomeExercicio, String musculoAgrupamento) {
        Cell tituloCell = new Cell(2, 10).add(nomeExercicio + " - " + musculoAgrupamento
        )
                .setBorder(Border.NO_BORDER)
                .setBold()
                .setFontSize(14f)
                .setBackgroundColor(MARROM_ESCURO)
                .setFontColor(Color.WHITE)
                .setTextAlignment(TextAlignment.CENTER)
                .setPadding(10);
        return tituloCell;
    }

    private Cell getImageExercicio(TreinoExercicio treinoExercicio) {

        Table table = new Table(1).setWidth(UnitValue.createPercentValue(100)).setBorder(Border.NO_BORDER);

        try {
            ImageData imageData = ImageDataFactory.create(new URL(treinoExercicio.getExercicio().getUrlFoto()));
            Image image = new Image(imageData)
                    .scaleToFit(IMAGE_WIDTH, IMAGE_HEIGHT)
                    .setHorizontalAlignment(HorizontalAlignment.CENTER);

            table.addCell(getImage(image));
            table.addCell(getLegendaImagem("Imagem ilustrativa"));

        } catch (MalformedURLException e) {
            table.addCell(getLegendaImagem("Imagem não disponível"));
        } catch (IOException e) {
            table.addCell(getLegendaImagem("Erro ao carregar a imagem"));
        }

        return new Cell().add(table).setBorder(Border.NO_BORDER);
    }

    private Cell carregarExecucaoExercicio(TreinoExercicio treinoExercicio) {
        Cell rightCell = new Cell().setWidth(UnitValue.createPercentValue(100));

        Table tabela = new Table(1).addCell(carregaDescricaoExercicio("Descrição do exercicio", treinoExercicio.getExercicio().getDescricao()));

        rightCell.add(tabela);
        rightCell.add(getRodape(treinoExercicio));

        return rightCell;
    }

    private Table getRodape(TreinoExercicio treinoExercicio) {
        Table rodape = new Table(4).setBorder(Border.NO_BORDER).setWidth(UnitValue.createPercentValue(100));

        rodape.addCell(getContainerColor("Séries", String.valueOf(treinoExercicio.getSeries())));
        rodape.addCell(getContainerColor("Repetições", String.valueOf(treinoExercicio.getRepeticoes())));
        rodape.addCell(getContainerColor("Intervalo", (treinoExercicio.converterMinutos() == 0 ? " " : treinoExercicio.converterMinutos() + " min")
                + (treinoExercicio.mostrarSegundos() == 0 ? "" : treinoExercicio.mostrarSegundos() + " seg")));
        if (treinoExercicio.getCarga() > 1) {
            rodape.addCell(getContainerColor("Carga", String.valueOf(treinoExercicio.getCarga()) + " kg"));
        }

        return rodape;
    }

    private Cell getContainerColor(String titulo, String descricao) {
        Cell cell = new Cell().setPadding(5).setBorder(Border.NO_BORDER);

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
                .setBackgroundColor(MARROM_ESCURO)
                .setFontColor(Color.WHITE)
                .setPadding(5);
    }

    private Cell getDescricaoContainerColor(String descricao) {
        return new Cell().add(descricao).setBorder(Border.NO_BORDER).setFontSize(fontSize).setTextAlignment(TextAlignment.CENTER).setPadding(5);
    }

    private Cell getLegendaImagem(String legenda) {
        return new Cell().add(legenda).setTextAlignment(TextAlignment.CENTER).setMargin(5).setBorder(Border.NO_BORDER).setFontSize(10f).setBold();
    }

    private Cell getImage(Image image) {
        return new Cell().add(image).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER).setPadding(10);
    }

    private Cell carregaDescricaoExercicio(String titulo, String descricao) {
        Cell cell = new Cell()
                .setPadding(5)
                .setBorder(Border.NO_BORDER);

        Table tabelaDados = new Table(1)
                .setBorder(Border.NO_BORDER);

        tabelaDados.addCell(configuraTitulo(titulo));
        tabelaDados.addCell(configuraDescricao(descricao));

        cell.add(tabelaDados);

        return cell;
    }

    private Cell configuraTitulo(String titulo) {
        return new Cell().add(new Paragraph(titulo).setBold()).setFontSize(14).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.JUSTIFIED);
    }

    private Cell configuraDescricao(String descricao) {
        return new Cell().add(new Paragraph(descricao)).setFontSize(fontSize).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.JUSTIFIED);
    }
}
