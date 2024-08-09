package com.br.macros.models;

import java.util.Date;

import com.br.macros.enums.Sexo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "educadores_fisicos")
public class EducadorFisico extends ProfissionalSaude {

	private static final long serialVersionUID = 1L;

	private String cref;

	public EducadorFisico() {

	}

	public EducadorFisico(Date dataNascimento,String nome, String sobrenome, Sexo sexo) {
		super(dataNascimento, nome, sobrenome, sexo);
	}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}

}
