package com.mycompany.enums;

public enum DivisaoTreino {
    DIVISAO_A("Grupo A"),
    DIVISAO_B("Grupo B"),
    DIVISAO_C("Grupo C"),
    DIVISAO_D("Grupo D");

    private final String AGRUPAMENTO;

    private DivisaoTreino(String AGRUPAMENTO) {
        this.AGRUPAMENTO = AGRUPAMENTO;
    }

    public String getAGRUPAMENTO() {
        return AGRUPAMENTO;
    }
}
