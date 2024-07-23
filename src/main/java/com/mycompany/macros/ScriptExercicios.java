package com.mycompany.macros;

import java.util.ArrayList;
import java.util.*;
import com.mycompany.enums.GrupoMuscular;
import com.mycompany.models.Exercicio;

public class ScriptExercicios {

    List<Exercicio> listaExercicios;

    public List<Exercicio> listaExercicios() {
        listaExercicios = new ArrayList<>();

        // Adicionando exercícios de Peitoral
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Supino Reto com Barra", "Coloque as anilhas na barra, execute o movimento.", GrupoMuscular.PEITO, "https://th.bing.com/th/id/OIP.Ar-GK4n-1hAWmgMpvnaDtQAAAA?rs=1&pid=ImgDetMain"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Supino Reto com Halteres", "Descrição do Supino Reto com Halteres", GrupoMuscular.PEITO, "https://example.com/supino_reto_com_halteres.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Peck Deck (Voador)", "Descrição do Peck Deck", GrupoMuscular.PEITO, "https://treinomestre.com.br/wp-content/uploads/2016/09/peck-deck-exercicio-execucao-correta-780x470.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Supino Inclinado com Barra", "Descrição do Supino Inclinado com Barra", GrupoMuscular.PEITO, "https://example.com/supino_inclinado_com_barra.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Supino Inclinado com Halteres", "Descrição do Supino Inclinado com Halteres", GrupoMuscular.PEITO, "https://example.com/supino_inclinado_com_halteres.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Crucifixo Inclinado com Halteres", "Descrição do Crucifixo Inclinado com Halteres", GrupoMuscular.PEITO, "https://example.com/crucifixo_inclinado_com_halteres.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Crossover Polia Baixa", "Descrição do Crossover Polia Baixa", GrupoMuscular.PEITO, "https://example.com/crossover_polia_baixa.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Crossover Polia Alta", "Descrição do Crossover Polia Alta", GrupoMuscular.PEITO, "https://example.com/crossover_polia_alta.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Paralela", "Descrição da Paralela", GrupoMuscular.PEITO, "https://example.com/paralela.jpg"));

        // Adicionando exercícios de Triceps
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Tríceps Pulley (Barra na Polia Alta)", "Descrição do Tríceps Pulley", GrupoMuscular.TRICEPS, "https://example.com/triceps_pulley.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Tríceps Testa com barra", "Descrição do Tríceps Testa", GrupoMuscular.TRICEPS, "https://example.com/triceps_testa.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Tríceps francês com halteres", "Descrição da Triceps", GrupoMuscular.TRICEPS, "https://example.com/rosca_francesa.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Tríceps Invertido na Polia", "Descrição do Tríceps Invertido", GrupoMuscular.TRICEPS, "https://example.com/triceps_invertido.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Tríceps Coice", "Descrição do Tríceps Coice", GrupoMuscular.TRICEPS, "https://example.com/triceps_coice.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Tríceps Corda na polia", "Descrição do Tríceps Corda", GrupoMuscular.TRICEPS, "https://example.com/triceps_coice.jpg"));

        // Adicionando exercícios de Deltoides (Ombros)
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Elevação Lateral", "Descrição da Elevação Lateral", GrupoMuscular.OMBROS, "https://example.com/elevacao_lateral.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Remada Alta com Barra Livre ou Polia", "Descrição da Remada Alta", GrupoMuscular.OMBROS, "https://example.com/remada_alta.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Elevação Uni Lateral na Polia", "Descrição da Elevação Uni Lateral na Polia", GrupoMuscular.OMBROS, "https://example.com/elevacao_uni_lateral.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Desenvolvimento por Trás da Cabeça", "Descrição do Desenvolvimento por Trás da Cabeça", GrupoMuscular.OMBROS, "https://example.com/desenvolvimento_traseiro.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Elevação Frontal com Barra", "Descrição da Elevação Frontal com Barra", GrupoMuscular.OMBROS, "https://example.com/elevacao_frontal.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Desenvolvimento Pegada Pronada", "Descrição do Desenvolvimento Pegada Pronada", GrupoMuscular.OMBROS, "https://example.com/desenvolvimento_pronada.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Desenvolvimento Pegada Neutra", "Descrição do Desenvolvimento Pegada Neutra", GrupoMuscular.OMBROS, "https://example.com/desenvolvimento_neutra.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Crucifixo Invertido Inclinado", "Descrição do Crucifixo Invertido Inclinado", GrupoMuscular.OMBROS, "https://example.com/crucifixo_invertido.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Crucifixo Invertido Sentado no Peck Deck", "Descrição do Crucifixo Invertido Sentado", GrupoMuscular.OMBROS, "https://example.com/crucifixo_sentado.jpg"));

        // Adicionando exercícios de Trapézio
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Encolhimento com Barra ou Halteres", "Descrição do Encolhimento com Barra ou Halteres", GrupoMuscular.OMBROS, "https://example.com/encolhimento.jpg"));

        // Adicionando exercícios de Costas
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Barra Fixa", "Descrição da Barra Fixa", GrupoMuscular.COSTAS, "https://example.com/barra_fixa.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Puxada Pegada Pronada", "Descrição da Puxada Pegada Pronada", GrupoMuscular.COSTAS, "https://example.com/puxada_pronada.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Puxada Pegada Neutra", "Descrição da Puxada Pegada Neutra", GrupoMuscular.COSTAS, "https://example.com/puxada_neutra.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Puxada Pegada Supinada", "Descrição da Puxada Pegada Supinada", GrupoMuscular.COSTAS, "https://example.com/puxada_supinada.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Remada Baixa Pegada Neutra", "Descrição da Remada Baixa Pegada Neutra", GrupoMuscular.COSTAS, "https://example.com/remada_baixa_neutra.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Remada Serrote", "Descrição da Remada Serrote", GrupoMuscular.COSTAS, "https://example.com/remada_serrote.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Remada Cavalinho", "Descrição da Remada Cavalinho", GrupoMuscular.COSTAS, "https://example.com/remada_cavalinho.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Remada na Máquina Pegada Neutra, Pronada", "Descrição da Remada na Máquina", GrupoMuscular.COSTAS, "https://example.com/remada_maquina.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Pull Down", "Descrição do Pull Down", GrupoMuscular.COSTAS, "https://example.com/pull_down.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Remada Curvada Pegada Pronada/Supinada", "Descrição da Remada Curvada", GrupoMuscular.COSTAS, "https://example.com/remada_curvada.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Remada Baixa Pegada Pronada", "Descrição da Remada Baixa Pegada Pronada", GrupoMuscular.COSTAS, "https://example.com/remada_baixa_pronada.jpg"));

        // Adicionando exercícios de Abdominais
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Abdominal Reto/Abdominal Oblíquo", "Descrição do Abdominal Reto/Abdominal Oblíquo", GrupoMuscular.ABDOMEN, "https://example.com/abdominal_reto.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Elevação de Pernas na Máquina ou na Barra", "Descrição da Elevação de Pernas", GrupoMuscular.ABDOMEN, "https://example.com/elevacao_pernas.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Prancha", "Descrição da Prancha", GrupoMuscular.ABDOMEN, "https://example.com/prancha.jpg"));

        // Adicionando exercícios de Pernas
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Agachamento Livre com Barra", "Descrição do Agachamento Livre com Barra", GrupoMuscular.PERNAS, "https://example.com/agachamento_livre.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Cadeira Extensora", "Descrição da Cadeira Extensora", GrupoMuscular.PERNAS, "https://example.com/cadeira_extensora.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Passada/Avanço", "Descrição da Passada/Avanço", GrupoMuscular.PERNAS, "https://example.com/passada.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Leg Press 45", "Descrição do Leg Press 45", GrupoMuscular.PERNAS, "https://example.com/leg_press.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Hack Machine", "Descrição do Hack Machine", GrupoMuscular.PERNAS, "https://example.com/hack_machine.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Cadeira Flexora", "Descrição da Cadeira Flexora", GrupoMuscular.PERNAS, "https://example.com/cadeira_flexora.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Mesa Flexora", "Descrição da Mesa Flexora", GrupoMuscular.PERNAS, "https://example.com/mesa_flexora.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Stiff", "Descrição do Stiff", GrupoMuscular.PERNAS, "https://example.com/stiff.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Cadeira Adutora", "Descrição da Cadeira Adutora", GrupoMuscular.PERNAS, "https://example.com/cadeira_adutora.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Cadeira Abdutora", "Descrição da Cadeira Abdutora", GrupoMuscular.PERNAS, "https://example.com/cadeira_abdutora.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Abdução na Polia", "Descrição da Abdução na Polia", GrupoMuscular.PERNAS, "https://example.com/abducao_polia.jpg"));

        // Adicionando exercícios de Glúteos
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Agachamento Sumô", "Descrição do Agachamento Sumô", GrupoMuscular.GLUTEOS, "https://example.com/agachamento_sumo.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Búlgaro", "Descrição do Búlgaro", GrupoMuscular.GLUTEOS, "https://example.com/bulgaro.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Elevação Pélvica", "Descrição da Elevação Pélvica", GrupoMuscular.GLUTEOS, "https://example.com/elevacao_pelvica.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Elevação de Glúteo na Polia", "Descrição da Elevação de Glúteo na Polia", GrupoMuscular.GLUTEOS, "https://example.com/elevacao_gluteo.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Elevação Coice na Polia", "Descrição da Elevação Coice na Polia", GrupoMuscular.GLUTEOS, "https://example.com/elevacao_coice.jpg"));

        // Adicionando exercícios de Panturrilhas
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Elevação de Panturrilha Sentado (Máquina)", "Descrição da Elevação de Panturrilha Sentado", GrupoMuscular.PANTURRILHAS, "https://example.com/elevacao_panturrilha.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Flexão Plantar na Máquina/Peso do Corpo/Em Pé no Smith", "Descrição da Flexão Plantar", GrupoMuscular.PANTURRILHAS, "https://example.com/flexao_plantar.jpg"));

        // Adicionando exercícios de Biceps
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Rosca Direta Barra", "Descrição da Rosca Direta Barra", GrupoMuscular.BICEPS, "https://example.com/rosca_direta.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Rosca Alternada com Halter", "Descrição da Rosca Alternada", GrupoMuscular.BICEPS, "https://example.com/rosca_alternada.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Rosca Martelo", "Descrição da Rosca Martelo", GrupoMuscular.BICEPS, "https://example.com/rosca_alternada.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Rosca 45 Inclinado", "Descrição da Rosca 45 Inclinado", GrupoMuscular.BICEPS, "url_foto_rosca_45_inclinado.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Rosca Scott", "Descrição da Rosca Scott", GrupoMuscular.BICEPS, "url_foto_rosca_scott.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Rosca Concentrada", "Descrição da Rosca Concentrada", GrupoMuscular.BICEPS, "url_foto_rosca_concentrada.jpg"));

        return listaExercicios;
    }

    public List<Exercicio> exerciciosCaique() {
        listaExercicios = new ArrayList<>();

        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Supino Reto com Barra", "Coloque as anilhas na barra, execute o movimento.", GrupoMuscular.PEITO, "https://th.bing.com/th/id/OIP.Ar-GK4n-1hAWmgMpvnaDtQAAAA?rs=1&pid=ImgDetMain"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Peck Deck (Voador)", "Descrição do Peck Deck", GrupoMuscular.PEITO, "https://treinomestre.com.br/wp-content/uploads/2016/09/peck-deck-exercicio-execucao-correta-780x470.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Supino Inclinado com Barra", "Descrição do Supino Inclinado com Barra", GrupoMuscular.PEITO, "https://example.com/supino_inclinado_com_barra.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Voador Inclinado no cross", "Descrição do Supino Inclinado com Halteres", GrupoMuscular.PEITO, "https://example.com/supino_inclinado_com_halteres.jpg"));

        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Tríceps Pulley (Barra na Polia Alta)", "Descrição do Tríceps Pulley", GrupoMuscular.TRICEPS, "https://example.com/triceps_pulley.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Tríceps francês com halteres", "Descrição da Triceps", GrupoMuscular.TRICEPS, "https://example.com/rosca_francesa.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Tríceps Testa com barra", "Descrição do Tríceps Testa", GrupoMuscular.TRICEPS, "https://example.com/triceps_testa.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Tríceps Corda na polia", "Descrição do Tríceps Corda", GrupoMuscular.TRICEPS, "https://example.com/triceps_coice.jpg"));

        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Puxada Pegada Pronada", "Descrição da Puxada Pegada Pronada", GrupoMuscular.COSTAS, "https://example.com/puxada_pronada.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Puxada Pegada Supinada", "Descrição da Puxada Pegada Supinada", GrupoMuscular.COSTAS, "https://example.com/puxada_supinada.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Remada na Máquina Pegada Neutra, Pronada", "Descrição da Remada na Máquina", GrupoMuscular.COSTAS, "https://example.com/remada_maquina.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Remada inclinada com a barra", "Descrição da Remada na Máquina", GrupoMuscular.COSTAS, "https://example.com/remada_maquina.jpg"));
        
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Rosca Direta Barra", "Descrição da Rosca Direta Barra", GrupoMuscular.BICEPS, "https://example.com/rosca_direta.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Rosca 45 Inclinado", "Descrição da Rosca 45 Inclinado", GrupoMuscular.BICEPS, "url_foto_rosca_45_inclinado.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Rosca Martelo", "Descrição da Rosca Martelo", GrupoMuscular.BICEPS, "https://example.com/rosca_alternada.jpg"));
        listaExercicios.add(new Exercicio(UUID.randomUUID(), "Rosca Alternada com Halter", "Descrição da Rosca Alternada", GrupoMuscular.BICEPS, "https://example.com/rosca_alternada.jpg"));
        
        return listaExercicios;
    }
}
