package com.mycompany.models;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name = "treinos")
public class Treino implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTreino;

    @ManyToOne
    @JoinColumn(name = "consulta_id", nullable = false)
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "educador_fisico_id", nullable = false)
    private EducadorFisico educadorFisico;

    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL)
    private List<TreinoExercicio> treinosExercicios;

    public Treino() {
    }

    public Treino(Date dataTreino, Consulta consulta, EducadorFisico educadorFisico, List<TreinoExercicio> treinosExercicios) {
        this.dataTreino = dataTreino;
        this.consulta = consulta;
        this.educadorFisico = educadorFisico;
        this.treinosExercicios = treinosExercicios;
    }

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

    public EducadorFisico getEducadorFisico() {
        return educadorFisico;
    }

    public void setEducadorFisico(EducadorFisico educadorFisico) {
        this.educadorFisico = educadorFisico;
    }

    public List<TreinoExercicio> getTreinosExercicios() {
        return treinosExercicios;
    }

    public void setTreinosExercicios(List<TreinoExercicio> treinosExercicios) {
        this.treinosExercicios = treinosExercicios;
    }

    public void moverExercicioParaCima(int indice) {
        if (indice > 0 && indice < treinosExercicios.size()) {
            Collections.swap(treinosExercicios, indice, indice - 1);
        }
    }

    public void moverExercicioParaBaixo(int indice) {
        if (indice >= 0 && indice < treinosExercicios.size() - 1) {
            Collections.swap(treinosExercicios, indice, indice + 1);
        }
    }
}
