package com.mycompany.macros;


import java.util.ArrayList;
import java.util.*;
import com.mycompany.enums.GrupoMuscular;
import com.mycompany.models.Exercicio;

public class ScriptExercicios {

    public List<Exercicio> listaExercicios() {
        List<Exercicio> listaExercicios = new ArrayList<>();        
        
        // Adicionando exercícios de Peito
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Supino Reto", "Descrição do Supino Reto", GrupoMuscular.PEITO, 
                "https://www.bing.com/th/id/OGC.02bf862b89fed610169a0329be7683b5?pid=1.7&rurl=https%3a%2f%2fwww.hipertrofia.org%2fblog%2fwp-content%2fuploads%2f2017%2f09%2fbarbell-bench-press.gif&ehk=h4SRVT8iLn3npMAMYBFJyMi8qhTzVEkKf8vrDzm5SHI%3d"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Supino Inclinado", "Descrição do Supino Inclinado", GrupoMuscular.PEITO, 
                "https://th.bing.com/th/id/R.6703a70832579c722be2378bd39277ca?rik=kbr%2fLQo8xXlU6w&riu=http%3a%2f%2fwww.basefitness.com.br%2fwp-content%2fuploads%2f2018%2f07%2fsupino-inclinado-musculos-trabalhados.jpg&ehk=2%2fxp6ocXYBYe0PHcEJWO1d9S%2f%2bEFRw9rdmtXeifRgg4%3d&risl=&pid=ImgRaw&r=0"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Crucifixo", "Descrição do Crucifixo", GrupoMuscular.PEITO, "url_foto_crucifixo.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Flexão de Braços", "Descrição da Flexão de Braços", GrupoMuscular.PEITO, "url_foto_flexao.jpg"));

        // Adicionando exercícios de Costas
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Puxada Frontal", "Descrição da Puxada Frontal", GrupoMuscular.COSTAS, "url_foto_puxada.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Remada Curvada", "Descrição da Remada Curvada", GrupoMuscular.COSTAS, "url_foto_remada_curvada.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Pulldown", "Descrição do Pulldown", GrupoMuscular.COSTAS, "url_foto_pulldown.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Levantamento de Peso", "Descrição do Levantamento de Peso", GrupoMuscular.COSTAS, "url_foto_levantamento.jpg"));

        // Adicionando exercícios de Pernas
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Agachamento Livre", "Descrição do Agachamento Livre", GrupoMuscular.PERNAS, "url_foto_agachamento.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Leg Press", "Descrição do Leg Press", GrupoMuscular.PERNAS, "url_foto_leg_press.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Máquina Extensora", "Descrição da Máquina Extensora", GrupoMuscular.PERNAS, "url_foto_extensora.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Máquina Flexora", "Descrição da Máquina Flexora", GrupoMuscular.PERNAS, "url_foto_flexora.jpg"));

        // Adicionando exercícios de Ombros
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Desenvolvimento Ombro", "Descrição do Desenvolvimento de Ombro", GrupoMuscular.OMBROS, "url_foto_desenvolvimento.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Elevação Frontal", "Descrição da Elevação Frontal", GrupoMuscular.OMBROS, "url_foto_elevacao_frontal.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Elevação Lateral", "Descrição da Elevação Lateral", GrupoMuscular.OMBROS, "url_foto_elevacao_lateral.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Crucifixo Invertido", "Descrição do Crucifixo Invertido", GrupoMuscular.OMBROS, "url_foto_crucifixo_invertido.jpg"));

        // Adicionando exercícios de Bíceps
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Rosca Direta", "Descrição da Rosca Direta", GrupoMuscular.BICEPS, "url_foto_rosca_direta.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Rosca Alternada", "Descrição da Rosca Alternada", GrupoMuscular.BICEPS, "url_foto_rosca_alternada.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Rosca Martelo", "Descrição da Rosca Martelo", GrupoMuscular.BICEPS, "url_foto_rosca_martelo.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Rosca Concentrada", "Descrição da Rosca Concentrada", GrupoMuscular.BICEPS, "url_foto_rosca_concentrada.jpg"));

        // Adicionando exercícios de Tríceps
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Tríceps Pulley", "Descrição do Tríceps Pulley", GrupoMuscular.TRICEPS, "url_foto_triceps_pulley.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Tríceps na Testa", "Descrição do Tríceps na Testa", GrupoMuscular.TRICEPS, "url_foto_triceps_testa.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Tríceps Corda", "Descrição do Tríceps Corda", GrupoMuscular.TRICEPS, "url_foto_triceps_corda.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Tríceps na Máquina", "Descrição do Tríceps na Máquina", GrupoMuscular.TRICEPS, "url_foto_triceps_maquina.jpg"));

        // Adicionando exercícios de Abdômen
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Abdominal Supra", "Descrição do Abdominal Supra", GrupoMuscular.ABDOMEN, "url_foto_abdominal_supra.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Abdominal Infra", "Descrição do Abdominal Infra", GrupoMuscular.ABDOMEN, "url_foto_abdominal_infra.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Prancha Abdominal", "Descrição da Prancha Abdominal", GrupoMuscular.ABDOMEN, "url_foto_prancha_abdominal.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Exercício Oblíquos", "Descrição do Exercício Oblíquos", GrupoMuscular.ABDOMEN, "url_foto_obliquos.jpg"));

        return listaExercicios;
    }
}
