package com.mycompany.macros;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceGray;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.renderer.CellRenderer;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import com.mycompany.models.Treino;
import com.mycompany.models.TreinoExercicio;
import com.mycompany.models.EducadorFisico;
import com.mycompany.models.Endereco;
import com.mycompany.models.Paciente;
import com.mycompany.models.Consulta;
import com.mycompany.models.Plano;

public class PDF {

    Treino treino;
    Consulta consulta;
    Plano plano;
    Paciente paciente;
    EducadorFisico educadorFisico;
    float fontSize = 8f;
    private static final int margin = 10;
    private static final DeviceRgb MARINHO = new DeviceRgb(0, 20, 118);

    public void gerarPDF(Treino treino) throws FileNotFoundException {

        this.treino = treino;
        this.consulta = treino.getConsulta();
        this.plano = treino.getConsulta().getPlano();
        this.paciente = treino.getConsulta().getPlano().getPaciente();
        this.educadorFisico = treino.getEducadorFisico();

        String path = "Plano de treino " + paciente.getNome() + ".pdf";
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
                    document.add(new AreaBreak()); // Nova página
                    document.add(getTabelaExercicio(treinoExercicio));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("PDF gerado com sucesso!");
        }
    }

    private Table getCabecalho() {

        Table tabela = new Table(3);
        tabela.setWidth(UnitValue.createPercentValue(100));
        tabela.setMargin(margin);

        tabela.addCell(getCelulaContainer("Objetivo", plano.getObjetivo().getDESCRICAO()));
        tabela.addCell(getCelulaContainer("Educador físico", educadorFisico.getNome()
                + " " + educadorFisico.getSobrenome()
                + " - Cref " + educadorFisico.getCref()));
        tabela.addCell(getCelulaContainer("Criado em", new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss ").format(treino.getDataTreino())));

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

        Table tabelaPaciente = new Table(2);
        setMarginTable(tabelaPaciente);

        tabelaPaciente.addCell(getCelulaContainer("CPF: ", paciente.getCpf() == null ? " - " : paciente.getCpf()));
        tabelaPaciente.addCell(getCelulaContainer("Nome: ", paciente.getNome() == null ? " - " : paciente.getNome() + " " + paciente.getSobrenome()));
        tabelaPaciente.addCell(getCelulaContainer("Data de Nascimento: ", paciente.getDataNascimento() == null ? " - " : new SimpleDateFormat("dd/MM/yyyy").format(paciente.getDataNascimento()) + " " + paciente.calcularIdade() + " anos"));
        tabelaPaciente.addCell(getCelulaContainer("Sexo: ", paciente.getSexo() == null ? " - " : paciente.getSexo().getSEXO()));
        tabelaPaciente.addCell(getCelulaContainer("Telefone: ", paciente.getTelefone() == null ? " - " : paciente.getTelefone()));
        tabelaPaciente.addCell(getCelulaContainer("Email: ", paciente.getEmail() == null ? " - " : paciente.getEmail()));

        return tabelaPaciente;
    }

    private Table getTabelaExercicio(TreinoExercicio treinoExercicio) {

        Table tabelaExercicio = new Table(new float[]{1, 2});
        tabelaExercicio.setWidth(UnitValue.createPercentValue(100));
        tabelaExercicio.setBorder(Border.NO_BORDER);

        Cell tituloCell = new Cell(2, 3).add(new Paragraph(treinoExercicio.getExercicio().getNome() + " - " + treinoExercicio.getDivisao()
                .getAGRUPAMENTO()).setBorder(Border.NO_BORDER))
                .setBold()
                .setFontSize(14f)
                .setTextAlignment(TextAlignment.CENTER);
        tabelaExercicio.addCell(tituloCell);

        Cell leftCell = new Cell();
        Cell rightCell = new Cell();
        tabelaExercicio.addCell(leftCell.setWidth(UnitValue.createPercentValue(50))); // Definindo a largura da leftCell como metade da página
        tabelaExercicio.addCell(rightCell);

        leftCell.add(new Paragraph("Imagens do exercício").setBorder(Border.NO_BORDER));

        // Parte da direita: descrição do exercício e rodapé
        rightCell.add(new Paragraph("Descrição do Exercício: " + treinoExercicio.getExercicio().getDescricao()).setBorder(Border.NO_BORDER));

        // Rodapé: tabela com carga, repetições, séries e intervalo
        Table rodape = new Table(new float[]{1, 1, 1, 1});
        rodape.setWidth(UnitValue.createPercentValue(100));

        // Adiciona a carga na primeira linha
        rodape.addCell(new Cell().add("Carga: " + treinoExercicio.getCarga() + " Kg " + treinoExercicio.getSeries() + "x" + treinoExercicio.getRepeticoes()).setBorder(Border.NO_BORDER));

        // Adiciona o intervalo na segunda linha
        rodape.addCell(new Cell().add("Intervalo: " + treinoExercicio.getIntervaloSerie()).setBorder(Border.NO_BORDER));

        // Adiciona o rodapé à parte direita
        rightCell.add(rodape.setBorder(Border.NO_BORDER));

        return tabelaExercicio;
    }

    private Cell getCelulaContainer(String titulo, String descricao) {
        Cell cell = new Cell();
        cell.setBorder(Border.NO_BORDER);

        Table tabelaDados = new Table(1);
        tabelaDados.setBorder(Border.NO_BORDER);

        tabelaDados.addCell(getTituloContainer(titulo));
        tabelaDados.addCell(getDescricaoContainer(descricao));

        cell.add(tabelaDados);

        return cell;
    }

    private Cell getTituloContainer(String titulo) {
        return new Cell().add(titulo).setFontSize(fontSize)
                .setBold()
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.JUSTIFIED);
    }

    private Cell getDescricaoContainer(String descricao) {
        return new Cell().add(descricao).setBorder(Border.NO_BORDER).setFontSize(fontSize);
    }

    private Table getEndereco() {

        Table tabelaEndereco = new Table(new float[]{1, 5});
        tabelaEndereco.setWidth(UnitValue.createPercentValue(100));
        setMarginTable(tabelaEndereco);
        tabelaEndereco.setMarginBottom(margin);

        Endereco endereco = paciente.getEndereco();
        tabelaEndereco.addCell(getCelulaContainer("CEP: ", endereco != null && endereco.getCep() != null ? endereco.getCep() : " - "));
        tabelaEndereco.addCell(getCelulaContainer("Logradouro: ", endereco != null && endereco.getLogradouro() != null ? endereco.getLogradouro() : " - "));
        tabelaEndereco.addCell(getCelulaContainer("Número: ", endereco != null && endereco.getNumero() != 0 ? String.valueOf(endereco.getNumero()) : " - "));
        tabelaEndereco.addCell(getCelulaContainer("Complemento: ", endereco != null && endereco.getComplemento() != null ? endereco.getComplemento() : " - "));
        tabelaEndereco.addCell(getCelulaContainer("Bairro: ", endereco != null && endereco.getBairro() != null ? endereco.getBairro() : " - "));
        tabelaEndereco.addCell(getCelulaContainer("Cidade: ", endereco != null && endereco.getCidade() != null ? endereco.getCidade() : " - "));
        tabelaEndereco.addCell(getCelulaContainer("Estado: ", endereco != null && endereco.getEstado() != null ? endereco.getEstado() : " - "));
        tabelaEndereco.addCell(getCelulaContainer("País: ", endereco != null && endereco.getPais() != null ? endereco.getPais() : " - "));

        return tabelaEndereco;
    }

    private void setMarginTable(Table tabela) {
        tabela.setMarginLeft(margin);
        tabela.setMarginRight(margin);
    }

    private Table getDadosEspecificos() {
    Table tabelaDadosEspecificos = new Table(2);
    tabelaDadosEspecificos.setWidth(UnitValue.createPercentValue(100));

    tabelaDadosEspecificos.addCell(getCelulaContainer("Atividade Física: ", plano.getNivelAtividadeFisica().getDESCRICAO()));
    tabelaDadosEspecificos.addCell(getCelulaContainer("Calorias Diárias: ", String.format("%.0f", consulta.calcularCaloriasDieta()) + " Kcal"));  
    tabelaDadosEspecificos.addCell(getCelulaContainer("Peso: ", consulta.getPeso() == 0 ? " - " : String.format("%.3f", consulta.getPeso()) + " kg"));
    tabelaDadosEspecificos.addCell(getCelulaContainer("Altura: ", consulta.getAltura() == 0 ? " - " : String.format("%.0f", consulta.getAltura()) + " cm"));
    tabelaDadosEspecificos.addCell(getCelulaContainer("Número de Refeições: ", consulta.getNumeroRefeicoes() == 0 ? " - " : String.valueOf(consulta.getNumeroRefeicoes())));
    tabelaDadosEspecificos.addCell(getCelulaContainer("Circunferência Abdominal: ", consulta.getCircunferenciaAbdominal() == 0 ? " - " : String.valueOf(consulta.getCircunferenciaAbdominal()) + " cm"));
    tabelaDadosEspecificos.addCell(getCelulaContainer("Circunferência do Braço: ", consulta.getCircunferenciaBraco() == 0 ? " - " : String.valueOf(consulta.getCircunferenciaBraco()) + " cm"));
    tabelaDadosEspecificos.addCell(getCelulaContainer("Circunferência da Perna: ", consulta.getCircunferenciaPerna() == 0 ? " - " : String.valueOf(consulta.getCircunferenciaPerna()) + " cm"));

    tabelaDadosEspecificos.addCell(getCelulaContainer("Medida de Gordura na Barriga: ", consulta.getMedidaGorduraBarriga() == 0 ? " - " : String.valueOf(consulta.getMedidaGorduraBarriga()) + " mm"));
    tabelaDadosEspecificos.addCell(getCelulaContainer("Medida de Gordura nas Costas: ", consulta.getMedidaGorduraCostas() == 0 ? " - " : String.valueOf(consulta.getMedidaGorduraCostas()) + " mm"));

    return tabelaDadosEspecificos;
}

}
