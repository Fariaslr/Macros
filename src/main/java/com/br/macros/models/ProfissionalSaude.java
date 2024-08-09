package com.br.macros.models;

import java.util.Date;
import java.util.List;

import com.br.macros.enums.Sexo;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "profissionais_saude")
public abstract class ProfissionalSaude extends Pessoa {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "profissionalSaude", cascade = CascadeType.ALL)
	private List<Plano> planos;

	@OneToMany(mappedBy = "profissionalSaude", cascade = CascadeType.ALL)
	private List<Consulta> consultas;

	public ProfissionalSaude() {

	}

	public ProfissionalSaude(Date dataNascimento, String nome, String sobrenome, Sexo sexo) {
		super(dataNascimento, nome, sobrenome, sexo);
	}

	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

}
