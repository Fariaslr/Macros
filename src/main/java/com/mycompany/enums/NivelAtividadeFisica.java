package com.mycompany.enums;

public enum NivelAtividadeFisica {
    SEDENTARIO(1.2f, "Pouco ou nenhum exercício"),
    LEVEMENTE_ATIVO(1.375f, "Exercício leve 1 a 3 dias por semana"),
    MODERADAMENTE_ATIVO(1.55f, "Exercício moderado, faz esportes 3 a 5 dias por semana"),
    ALTAMENTE_ATIVO(1.725f, "Exercício pesado de 5 a 6 dias por semana"),
    EXTREMAMENTE_ATIVO(1.9f, "Exercício pesado diariamente e até 2 vezes por dia");

    private final float FATOR;
    private final String DESCRICAO;

    private NivelAtividadeFisica(float FATOR, String DESCRICAO) {
        this.FATOR = FATOR;
        this.DESCRICAO = DESCRICAO;
    }

    public float getFATOR() {
        return FATOR;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

}
