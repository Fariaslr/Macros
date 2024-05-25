package com.mycompany.macros;

import java.io.IOException;
import java.text.*;
import java.util.*;
import com.mycompany.enums.*;
import com.mycompany.models.*;

public class Macros {

    public static void main(String[] args) throws ParseException, IOException {
        ScriptExercicios listaExercicios = new ScriptExercicios();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Endereco endereco = new Endereco("41950-880", "Beco Cida Alves", "Vila Bispo de Maura", "Ribeirão das Neves", "MG", "Brasil");

        Paciente paciente = new Paciente(format.parse("29/11/2002"), "Ronald", "Nepomuceno", Sexo.MASCULINO);
        paciente.setTelefone("75 9989-6182");
        paciente.setEndereco(endereco);
        
        EducadorFisico educadorFisico = new EducadorFisico("12456/BA", "Aleffe", "Santana", Sexo.MASCULINO);

        Plano plano = new Plano(paciente, new Date(), Objetivo.HIPERTROFIA, NivelAtividadeFisica.ALTAMENTE_ATIVO, educadorFisico);

        Consulta consulta = new Consulta(plano, new Date(), 86f, 184,educadorFisico);    

        List<Exercicio> exercicios = listaExercicios.listaExercicios();
        List<TreinoExercicio> treinosExercicios = new ArrayList<>();

        Treino treino = new Treino(new Date(), consulta, educadorFisico, treinosExercicios);

        TreinoExercicio treinoExercicio;

        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                treinoExercicio = new TreinoExercicio(exercicios.get(i), DivisaoTreino.DIVISAO_A, 4, 12, 5, 60);
                treinosExercicios.add(treinoExercicio);
            } else {
                treinoExercicio = new TreinoExercicio(exercicios.get(i), DivisaoTreino.DIVISAO_B, 4, 12, 5, 30);
                treinosExercicios.add(treinoExercicio);
            }
        }

        PDF pdf = new PDF();
        
        pdf.gerarPDF(treino);

    }

}
