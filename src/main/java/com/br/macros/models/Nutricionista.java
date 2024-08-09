package com.br.macros.models;

import java.util.Date;

import com.br.macros.enums.Sexo;

import jakarta.persistence.*;

@Entity
@Table(name = "nutricionistas")
public class Nutricionista extends ProfissionalSaude {

	private static final long serialVersionUID = 1L;

	private String crn;

	public Nutricionista() {
	}

	public Nutricionista(Date dataNascimento,String crn, String nome, String sobrenome, Sexo sexo) {
		super(dataNascimento, nome, sobrenome, sexo);
		this.crn = crn;
	}

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}
}
