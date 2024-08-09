package com.br.macros.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "treinos")
public class Treino implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTreino;

	@OneToOne
	@JoinColumn(name = "consulta_id")
	private Consulta consulta;
	
	@ManyToOne
    @JoinColumn(name = "educador_fisico_id", nullable = false)
    private EducadorFisico educadorFisico;

	@OneToMany(mappedBy = "treino", cascade = CascadeType.ALL)
	private List<TreinoExercicio> treinoExercicios;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getDataTreino() {
		return dataTreino;
	}

	public void setDataTreino(Date dataTreino) {
		this.dataTreino = dataTreino;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<TreinoExercicio> getTreinoExercicios() {
		return treinoExercicios;
	}

	public void setTreinoExercicios(List<TreinoExercicio> treinoExercicios) {
		this.treinoExercicios = treinoExercicios;
	}

	public EducadorFisico getEducadorFisico() {
		return educadorFisico;
	}

	public void setEducadorFisico(EducadorFisico educadorFisico) {
		this.educadorFisico = educadorFisico;
	}
	
	
}
