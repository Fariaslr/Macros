package com.mycompany.macros;


import java.util.ArrayList;
import java.util.List;
import com.mycompany.enums.GrupoMuscular;
import com.mycompany.models.Exercicio;

public class ScriptExercicios {

    public List<Exercicio> listaExercicios() {
        List<Exercicio> listaExercicios = new ArrayList<>();

        Exercicio supinoReto = new Exercicio(1, "Supino Reto", "Descrição do Supino Reto", GrupoMuscular.PEITO, "url_foto_supino.jpg");
        Exercicio supinoInclinado = new Exercicio(2, "Supino Inclinado", "Descrição do Supino Inclinado", GrupoMuscular.PEITO, "url_foto_supino_inclinado.jpg");
        Exercicio crucifixo = new Exercicio(3, "Crucifixo", "Descrição do Crucifixo", GrupoMuscular.PEITO, "url_foto_crucifixo.jpg");
        Exercicio flexaoBracos = new Exercicio(4, "Flexão de Braços", "Descrição da Flexão de Braços", GrupoMuscular.PEITO, "url_foto_flexao.jpg");

        Exercicio puxadaFrontal = new Exercicio(5, "Puxada Frontal", "Descrição da Puxada Frontal", GrupoMuscular.COSTAS, "url_foto_puxada.jpg");
        Exercicio remadaCurvada = new Exercicio(6, "Remada Curvada", "Descrição da Remada Curvada", GrupoMuscular.COSTAS, "url_foto_remada_curvada.jpg");
        Exercicio pulldown = new Exercicio(7, "Pulldown", "Descrição do Pulldown", GrupoMuscular.COSTAS, "url_foto_pulldown.jpg");
        Exercicio levantamentoPeso = new Exercicio(8, "Levantamento de Peso", "Descrição do Levantamento de Peso", GrupoMuscular.COSTAS, "url_foto_levantamento.jpg");

        Exercicio agachamento = new Exercicio(9, "Agachamento Livre", "Descrição do Agachamento Livre", GrupoMuscular.PERNAS, "url_foto_agachamento.jpg");
        Exercicio legPress = new Exercicio(10, "Leg Press", "Descrição do Leg Press", GrupoMuscular.PERNAS, "url_foto_leg_press.jpg");
        Exercicio extensora = new Exercicio(11, "Máquina Extensora", "Descrição da Máquina Extensora", GrupoMuscular.PERNAS, "url_foto_extensora.jpg");
        Exercicio flexora = new Exercicio(12, "Máquina Flexora", "Descrição da Máquina Flexora", GrupoMuscular.PERNAS, "url_foto_flexora.jpg");

        Exercicio desenvolvimentoOmbro = new Exercicio(13, "Desenvolvimento Ombro", "Descrição do Desenvolvimento de Ombro", GrupoMuscular.OMBROS, "url_foto_desenvolvimento.jpg");
        Exercicio elevacaoFrontal = new Exercicio(14, "Elevação Frontal", "Descrição da Elevação Frontal", GrupoMuscular.OMBROS, "url_foto_elevacao_frontal.jpg");
        Exercicio elevacaoLateral = new Exercicio(15, "Elevação Lateral", "Descrição da Elevação Lateral", GrupoMuscular.OMBROS, "url_foto_elevacao_lateral.jpg");
        Exercicio crucifixoInvertido = new Exercicio(16, "Crucifixo Invertido", "Descrição do Crucifixo Invertido", GrupoMuscular.OMBROS, "url_foto_crucifixo_invertido.jpg");

        Exercicio roscaDireta = new Exercicio(17, "Rosca Direta", "Descrição da Rosca Direta", GrupoMuscular.BICEPS, "url_foto_rosca_direta.jpg");
        Exercicio roscaAlternada = new Exercicio(18, "Rosca Alternada", "Descrição da Rosca Alternada", GrupoMuscular.BICEPS, "url_foto_rosca_alternada.jpg");
        Exercicio martelo = new Exercicio(19, "Rosca Martelo", "Descrição da Rosca Martelo", GrupoMuscular.BICEPS, "url_foto_rosca_martelo.jpg");
        Exercicio concentrada = new Exercicio(20, "Rosca Concentrada", "Descrição da Rosca Concentrada", GrupoMuscular.BICEPS, "url_foto_rosca_concentrada.jpg");

        Exercicio tricepsPulley = new Exercicio(21, "Tríceps Pulley", "Descrição do Tríceps Pulley", GrupoMuscular.TRICEPS, "url_foto_triceps_pulley.jpg");
        Exercicio tricepsTesta = new Exercicio(22, "Tríceps na Testa", "Descrição do Tríceps na Testa", GrupoMuscular.TRICEPS, "url_foto_triceps_testa.jpg");
        Exercicio tricepsCorda = new Exercicio(23, "Tríceps Corda", "Descrição do Tríceps Corda", GrupoMuscular.TRICEPS, "url_foto_triceps_corda.jpg");
        Exercicio tricepsMaquina = new Exercicio(24, "Tríceps na Máquina", "Descrição do Tríceps na Máquina", GrupoMuscular.TRICEPS, "url_foto_triceps_maquina.jpg");

        Exercicio abdominalSupra = new Exercicio(25, "Abdominal Supra", "Descrição do Abdominal Supra", GrupoMuscular.ABDOMEN, "url_foto_abdominal_supra.jpg");
        Exercicio abdominalInfra = new Exercicio(26, "Abdominal Infra", "Descrição do Abdominal Infra", GrupoMuscular.ABDOMEN, "url_foto_abdominal_infra.jpg");
        Exercicio pranchaAbdominal = new Exercicio(27, "Prancha Abdominal", "Descrição da Prancha Abdominal", GrupoMuscular.ABDOMEN, "url_foto_prancha_abdominal.jpg");
        Exercicio oblíquos = new Exercicio(28, "Exercício Oblíquos", "Descrição do Exercício Oblíquos", GrupoMuscular.ABDOMEN, "url_foto_obliquos.jpg");

        listaExercicios.add(supinoReto);
        listaExercicios.add(supinoInclinado);
        listaExercicios.add(crucifixo);
        listaExercicios.add(flexaoBracos);

        listaExercicios.add(puxadaFrontal);
        listaExercicios.add(remadaCurvada);
        listaExercicios.add(pulldown);
        listaExercicios.add(levantamentoPeso);

        listaExercicios.add(agachamento);
        listaExercicios.add(legPress);
        listaExercicios.add(extensora);
        listaExercicios.add(flexora);

        listaExercicios.add(desenvolvimentoOmbro);
        listaExercicios.add(elevacaoFrontal);
        listaExercicios.add(elevacaoLateral);
        listaExercicios.add(crucifixoInvertido);

        listaExercicios.add(roscaDireta);
        listaExercicios.add(roscaAlternada);
        listaExercicios.add(martelo);
        listaExercicios.add(concentrada);

        listaExercicios.add(tricepsPulley);
        listaExercicios.add(tricepsTesta);
        listaExercicios.add(tricepsCorda);
        listaExercicios.add(tricepsMaquina);

        listaExercicios.add(abdominalSupra);
        listaExercicios.add(abdominalInfra);
        listaExercicios.add(pranchaAbdominal);
        listaExercicios.add(oblíquos);
        return listaExercicios;
    }
}
