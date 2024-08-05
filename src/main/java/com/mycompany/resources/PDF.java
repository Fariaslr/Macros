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
    float fontSize = 12f;
    static float fontSizeDescricao = 10f;
    private static final int MARGIN = 10;
    private static final int PADDING = 10;
    private static final DeviceRgb MARROM_ESCURO = new DeviceRgb(124, 76, 22);
    private static final DeviceRgb AZUL_MARINHO = new DeviceRgb(0, 64, 128);
    private static final float IMAGE_WIDTH = 300f;
    private static final float IMAGE_HEIGHT = 300f;
    private static final float SIZE_ICON = 16f;

    public void gerarPDF(Treino treino) throws FileNotFoundException {

        this.treino = treino;
        this.consulta = treino.getConsulta();
        this.plano = treino.getConsulta().getPlano();
        this.paciente = treino.getConsulta().getPlano().getPaciente();
        this.educadorFisico = treino.getEducadorFisico();

        String path = "src/main/resources/relatorios/Teste.pdf";
        //String path = "src/main/resources/relatorios/Plano de treino " + paciente.getNome() + " " + new SimpleDateFormat("dd-MM-yyyy hh.mm.ss").format(treino.getDataTreino()) + ".pdf";
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
                document.add(mostrarDadosEspecificosPaciente());
                document.add(new AreaBreak());
                document.add(criarTituloSessao("Sumário"));
                document.add(criarSumario());

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
        tabela.addCell(montarContainer("Criado em", new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(treino.getDataTreino())));

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

        Table tabelaCabecalho = new Table(1)
                .setMarginTop(MARGIN)
                .setMarginBottom(MARGIN)
                .setWidth(UnitValue.createPercentValue(100))
                .setHeight(30)
                .addCell(
                        new Cell().add(tituloContainer)
                                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                                .setHorizontalAlignment(HorizontalAlignment.LEFT)
                                .setBold()
                                .setBorder(Border.NO_BORDER)
                                .setFontSize(fontSize)
                                .setBackgroundColor(AZUL_MARINHO)
                                .setFontColor(Color.WHITE)
                                .setPaddingLeft(PADDING)
                );

        return tabelaCabecalho;
    }

    private Table mostrarDadosPaciente() {
        criarTituloSessao("Dados pessoais");
        Table tabelaPaciente = new Table(2);
        colocarMarginTabela(tabelaPaciente);

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
        colocarMarginTabela(tabelaEndereco);
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

    private Table mostrarDadosEspecificosPaciente() {
        Table tabelaDadosEspecificos = new Table(4)
                .setWidth(UnitValue.createPercentValue(100))
                .setMargin(MARGIN)
                .setMarginTop(0);

        tabelaDadosEspecificos.addCell(montarContainer("Calorias Diárias: ", String.format("%.0f", consulta.calcularCaloriasDieta()) + " Kcal"));
        tabelaDadosEspecificos.addCell(montarContainer("Altura: ", consulta.getAltura() == 0 ? " - " : String.format("%.0f", consulta.getAltura()) + " cm"));
        tabelaDadosEspecificos.addCell(montarContainer("Peso: ", consulta.getPeso() == 0 ? " - " : String.format("%.3f", consulta.getPeso()) + " kg"));
        tabelaDadosEspecificos.addCell(montarContainer("Nível atividade: ", plano.getNivelAtividadeFisica().getDESCRICAO()));
        tabelaDadosEspecificos.addCell(montarContainer("Gordura (%)", consulta.calcularPercentualGordura() == -450 ? " - " : String.format("%.2f", consulta.calcularPercentualGordura()) + " %"));
        tabelaDadosEspecificos.addCell(montarContainer("Medida do Pescoço: ", consulta.getMedidaPescoco() == 0 ? " - " : String.format("%.0f", consulta.getMedidaPescoco()) + " cm"));
        tabelaDadosEspecificos.addCell(montarContainer("Medida da Cintura: ", consulta.getMedidaCintura() == 0 ? " - " : String.format("%.0f", consulta.getMedidaCintura()) + " cm"));
        if (paciente.getSexo() == Sexo.FEMININO) {
            tabelaDadosEspecificos.addCell(montarContainer("Circunferência da Quadril: ", consulta.getMedidaQuadril() == 0 ? " - " : String.valueOf(consulta.getMedidaQuadril()) + " cm"));
        }
        //tabelaDadosEspecificos.addCell(getContainer("Número de Refeições: ", consulta.getNumeroRefeicoes() == 0 ? " - " : String.valueOf(consulta.getNumeroRefeicoes())));

        return tabelaDadosEspecificos;
    }

    private Table montarPaginaExercicio(TreinoExercicio treinoExercicio) {

        Table tabelaExercicio = new Table(1).setWidth(UnitValue.createPercentValue(100)).setBorder(Border.NO_BORDER);

        tabelaExercicio.addCell(mostrarTituloExercicio(treinoExercicio.getExercicio().getNome(), treinoExercicio.getDivisao().getAGRUPAMENTO()));
        tabelaExercicio.addCell(carregarUrlImageExercicio(treinoExercicio));
        tabelaExercicio.addCell(carregarExecucaoExercicio(treinoExercicio));

        return tabelaExercicio;
    }

    private Cell montarContainer(String titulo, String descricao) {
        Cell cell = new Cell()
                .setPadding(5)
                .setBorder(Border.NO_BORDER);

        Table tabelaDados = new Table(1)
                .setBorder(Border.NO_BORDER);

        tabelaDados.addCell(new Cell().add(titulo).setBold().setBorder(Border.NO_BORDER).setFontSize(fontSize));
        tabelaDados.addCell(new Cell().add(descricao).setBorder(Border.NO_BORDER).setFontSize(fontSizeDescricao));

        cell.add(tabelaDados);

        return cell;
    }

    private Table criarSumario() {
        Table tabelaSumario = new Table(new float[]{0.5f, 2, 3})
                .setMargin(MARGIN)
                .setWidthPercent(100);
        for (int i = 0; i < treino.getTreinosExercicios().size(); i++) {
            tabelaSumario.addCell(new Cell().add(i + 1 + ".").setBorder(Border.NO_BORDER).setHorizontalAlignment(HorizontalAlignment.RIGHT));
            tabelaSumario.addCell(new Cell().add(treino.getTreinosExercicios().get(i).getExercicio().getNome() + "").setFontSize(fontSize).setBold().setBorder(Border.NO_BORDER).setHorizontalAlignment(HorizontalAlignment.LEFT));
            tabelaSumario.addCell(new Cell().add(Integer.toString(3 + i)).setFontSize(fontSize).setFontSize(fontSize).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
        }
        return tabelaSumario;
    }

    private void colocarMarginTabela(Table tabela) {
        tabela.setMarginLeft(MARGIN).setMarginRight(MARGIN);
    }

    private Cell mostrarTituloExercicio(String nomeExercicio, String musculoAgrupamento) {
        Cell tituloCell = new Cell(2, 10).add(nomeExercicio + " - " + musculoAgrupamento
        )
                .setBorder(Border.NO_BORDER)
                .setBold()
                .setFontSize(14f)
                .setBackgroundColor(AZUL_MARINHO)
                .setFontColor(Color.WHITE)
                .setTextAlignment(TextAlignment.CENTER)
                .setPadding(10);
        return tituloCell;
    }

    private Cell carregarUrlImageExercicio(TreinoExercicio treinoExercicio) {

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
        Cell rightCell = new Cell().setWidth(UnitValue.createPercentValue(100))
                .setBorder(Border.NO_BORDER);

        Table tabelaExercicio = new Table(1)
                .addCell(carregaDescricaoExercicio(
                        "Descrição do exercicio",
                        treinoExercicio.getExercicio().getDescricao()
                )
                );

        rightCell.add(tabelaExercicio);
        rightCell.add(treinoExercicio.getCarga() < 1 ? constroiRodape(treinoExercicio) : constroiRodapeCompleto(treinoExercicio));

        return rightCell;
    }

    private Table constroiRodape(TreinoExercicio treinoExercicio) {
        Table rodape = new Table(3)
                .setBorder(Border.NO_BORDER)
                .setWidth(UnitValue.createPercentValue(100))
                .setMarginTop(MARGIN);

        rodape.addCell(getContainerColor(
                "Séries",
                String.valueOf(treinoExercicio.getSeries()),
                "dumbell")
        );

        rodape.addCell(getContainerColor(
                "Repetições",
                String.valueOf(treinoExercicio.getRepeticoes()),
                "loop")
        );

        rodape.addCell(getContainerColor(
                "Intervalo",
                treinoExercicio.mostrarIntevalo() == null ? " - " : treinoExercicio.mostrarIntevalo(),
                "sleep"));

        return rodape;
    }

    private Table constroiRodapeCompleto(TreinoExercicio treinoExercicio) {
        Table rodape = new Table(2)
                .setBorder(Border.NO_BORDER)
                .setWidth(UnitValue.createPercentValue(100))
                .setMarginTop(MARGIN);

        rodape.addCell(getContainerColor(
                "Séries",
                String.valueOf(treinoExercicio.getSeries()),
                "dumbbell")
        );

        rodape.addCell(getContainerColor(
                "Repetições",
                String.valueOf(treinoExercicio.getRepeticoes()),
                "loop")
        );

        rodape.addCell(getContainerColor(
                "Intervalo",
                treinoExercicio.mostrarIntevalo() == null ? " - " : treinoExercicio.mostrarIntevalo(),
                "sleep"));

        rodape.addCell(getContainerColor(
                "Carga",
                String.valueOf(treinoExercicio.getCarga()) + " kg",
                "weight")
        );

        return rodape;
    }

    private Cell getContainerColor(String titulo, String descricao, String imageLocal) {
        Table tabelaRodape = new Table(new float[]{1f, 1f})
                .setWidthPercent(100)
                .setBorder(Border.NO_BORDER);

        try {
            tabelaRodape.addCell(new Cell().add(carregarIcone(imageLocal))
                    .setBackgroundColor(AZUL_MARINHO)
                    .setPadding(5)
                    .setBorder(Border.NO_BORDER)
            );

            tabelaRodape.addCell(new Cell().add(descricao + " - " + titulo)
                    .setFontSize(fontSize)
                    .setBold()
                    .setBorder(Border.NO_BORDER)
                    .setBorderRight(Border.NO_BORDER)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setBackgroundColor(AZUL_MARINHO)
                    .setFontColor(Color.WHITE)
                    .setPadding(5));

            return new Cell().add(tabelaRodape)
                    .setBorder(Border.NO_BORDER);

        } catch (Exception e) {

            return new Cell().add(titulo)
                    .setFontSize(fontSize)
                    .setBold()
                    .setBorder(Border.NO_BORDER)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBackgroundColor(AZUL_MARINHO)
                    .setFontColor(Color.WHITE)
                    .setPadding(5);

        }
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

        tabelaDados.addCell(configuraTituloContainer(titulo));
        tabelaDados.addCell(new Cell().add(descricao).setFontSize(fontSizeDescricao).setTextAlignment(TextAlignment.LEFT).setBorder(Border.NO_BORDER));

        cell.add(tabelaDados);

        return cell;
    }

    private Cell configuraTituloContainer(String titulo) {
        return new Cell().add(new Paragraph(titulo).setBold()).setFontSize(fontSize).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.JUSTIFIED);
    }

    private Image carregarIcone(String imageLocal) throws MalformedURLException {
        ImageData imageData = ImageDataFactory.create("src/main/resources/image/" + imageLocal + ".png");
        Image image = new Image(imageData)
                .setHorizontalAlignment(HorizontalAlignment.RIGHT)
                .scaleToFit(SIZE_ICON, SIZE_ICON);
        return image;
    }

}
