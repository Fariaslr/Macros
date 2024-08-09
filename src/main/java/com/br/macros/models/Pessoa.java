package com.br.macros.models;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import com.br.macros.enums.Sexo;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	private String cpf;
	private String nome;
	private String sobrenome;
	private String telefone;
	private String email;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Embedded
	private Endereco endereco;

	public Pessoa() {
	}

	public Pessoa(Date dataNascimeto, String nome, String sobrenome, Sexo sexo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int calcularIdade() {
		LocalDate birth = LocalDate.now();
		LocalDate nascimento = Instant.ofEpochMilli(dataNascimento.getTime()).atZone(ZoneId.systemDefault())
				.toLocalDate();
		Period periodo = Period.between(nascimento, birth);
		return periodo.getYears();
	}

	@Override
	public String toString() {
		return "Paciente [dataNascimento=" + dataNascimento + ", getId()=" + getId() + ", getCpf()=" + getCpf()
				+ ", getNome()=" + getNome() + ", getSobrenome()=" + getSobrenome() + ", getTelefone()=" + getTelefone()
				+ ", getEmail()=" + getEmail() + ", getSexo()=" + getSexo() + ", getEndereco()=" + getEndereco() + "]";
	}

}
