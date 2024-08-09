package com.br.macros.models;

import java.io.Serializable;
import java.util.*;

import org.springframework.hateoas.RepresentationModel;

import com.br.macros.enums.GrupoMuscular;

import jakarta.persistence.*;

@Entity
@Table(name = "exercicios")
public class Exercicio extends RepresentationModel<Exercicio> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Enumerated(EnumType.STRING)
	private GrupoMuscular grupoMuscular;

	@OneToMany(mappedBy = "exercicio", cascade = CascadeType.ALL)
	private List<TreinoExercicio> treinoExercicios;
	
	@Column(length = 40)
	private String nome;
	
	@Column(length = 1500)
	private String descricao;
	
	@Column(name="url_foto",length = 512)
	private String urlFoto;

	public Exercicio() {
	}

	public Exercicio(UUID id, String nome, String descricao, GrupoMuscular grupoMuscular, String urlFoto) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.grupoMuscular = grupoMuscular;
		this.urlFoto = urlFoto;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public GrupoMuscular getGrupoMuscular() {
		return grupoMuscular;
	}

	public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
	}

	public List<TreinoExercicio> getTreinoExercicios() {
		return treinoExercicios;
	}

	public void setTreinoExercicios(List<TreinoExercicio> treinoExercicios) {
		this.treinoExercicios = treinoExercicios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
}
