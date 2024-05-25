package com.mycompany.macros;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.mycompany.enums.DivisaoTreino;
import com.mycompany.enums.NivelAtividadeFisica;
import com.mycompany.enums.Objetivo;
import com.mycompany.enums.Sexo;
import com.mycompany.models.Exercicio;
import com.mycompany.models.Treino;
import com.mycompany.models.TreinoExercicio;
import com.mycompany.models.EducadorFisico;
import com.mycompany.models.Endereco;
import com.mycompany.models.Paciente;
import com.mycompany.models.Consulta;
import com.mycompany.models.Plano;

public class Macros {

    public static void main(String[] args) throws ParseException, IOException {
        ScriptExercicios listaExercicios = new ScriptExercicios();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        Endereco endereco = new Endereco("33938-411", "Beco Cida Alves", "Vila Bispo de Maura", "Ribeirão das Neves", "MG", "Brasil");
        
        Paciente paciente = new Paciente(format.parse("30/03/1994"), "Alex", "Junior", Sexo.MASCULINO);
        paciente.setEndereco(endereco);

        Plano plano = new Plano(paciente, new Date(), Objetivo.HIPERTROFIA, NivelAtividadeFisica.LEVEMENTE_ATIVO);

        Consulta consulta = new Consulta(plano, new Date(), 82.324f, 163);

        EducadorFisico educadorFisico = new EducadorFisico("12456/BA", "Aleffe", "Santana", Sexo.MASCULINO);

        List<Exercicio> exercicios = listaExercicios.listaExercicios();
        List<TreinoExercicio> treinosExercicios = new ArrayList<>();

        Treino treino = new Treino(new Date(), consulta, educadorFisico, treinosExercicios);
        treino.setId(1245);

        TreinoExercicio treinoExercicio;

        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                treinoExercicio = new TreinoExercicio(exercicios.get(i), DivisaoTreino.DIVISAO_A, 4, 12, 5, 120);
                treinosExercicios.add(treinoExercicio);
            } else {
                treinoExercicio = new TreinoExercicio(exercicios.get(i), DivisaoTreino.DIVISAO_D, 4, 12, 5, 1353);
                treinosExercicios.add(treinoExercicio);
            }
        }

        PDF pdf = new PDF();

        //if (JOptionPane.showConfirmDialog(null, "Deseja criar o PDF?") == 0) {
            pdf.gerarPDF(treino);
        //}
    }

}
