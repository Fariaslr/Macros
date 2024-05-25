package com.mycompany.models;

import com.mycompany.enums.Objetivo;
import com.mycompany.models.Paciente;
import java.util.*;
import com.mycompany.enums.NivelAtividadeFisica;

public class Plano {

    private int codigoPlano;
    private Paciente paciente;
    private Date dataPlano;
    private Objetivo objetivo;
    private NivelAtividadeFisica nivelAtividadeFisica;

    public Plano() {

    }

    public Plano(Paciente paciente, Date dataPlano, Objetivo objetivo, NivelAtividadeFisica nivelAtividadeFisica) {
        this.paciente = paciente;
        this.dataPlano = dataPlano;
        this.objetivo = objetivo;
        this.nivelAtividadeFisica = nivelAtividadeFisica;
    }

    public int getCodigoPlano() {
        return codigoPlano;
    }

    public void setCodigoPlano(int codigoPlano) {
        this.codigoPlano = codigoPlano;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getDataPlano() {
        return dataPlano;
    }

    public void setDataPlano(Date dataPlano) {
        this.dataPlano = dataPlano;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public NivelAtividadeFisica getNivelAtividadeFisica() {
        return nivelAtividadeFisica;
    }

    public void setNivelAtividadeFisica(NivelAtividadeFisica nivelAtividadeFisica) {
        this.nivelAtividadeFisica = nivelAtividadeFisica;
    }

}
