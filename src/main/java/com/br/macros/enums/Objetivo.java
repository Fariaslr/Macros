package com.br.macros.enums;

public enum Objetivo {
	EMAGRECIMENTO("Emagrecimento"),
	MANUTENCAO("Manutenção do peso"),
	HIPERTROFIA("Hipertrofia");

	private final String DESCRICAO;

	private Objetivo(String DESCRICAO) {
		this.DESCRICAO = DESCRICAO;
	}

	public String getDESCRICAO() {
		return DESCRICAO;
	}
}
