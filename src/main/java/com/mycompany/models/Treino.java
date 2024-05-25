package com.mycompany.models;

import java.util.Date;
import java.util.List;

public class Treino {

    private int id;
    private Date dataTreino;
    private Consulta consulta;
    private EducadorFisico educadorFisico;
    private List<TreinoExercicio> treinosExercicios;

    public Treino() {
    }

    public Treino(Date dataTreino, Consulta consulta, EducadorFisico educadorFisico, List<TreinoExercicio> treinosExercicios) {
        this.dataTreino = dataTreino;
        this.consulta = consulta;
        this.educadorFisico = educadorFisico;
        this.treinosExercicios = treinosExercicios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
