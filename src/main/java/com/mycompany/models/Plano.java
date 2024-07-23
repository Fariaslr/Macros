package com.mycompany.models;

import com.mycompany.enums.Objetivo;
import java.util.*;
import com.mycompany.enums.NivelAtividadeFisica;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "planos")
public class Plano implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private Paciente paciente;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPlano;

    @Enumerated(EnumType.STRING)
    private Objetivo objetivo;

    @Enumerated(EnumType.STRING)
    private NivelAtividadeFisica nivelAtividadeFisica;

    @ManyToOne
    @JoinColumn(name = "profissional_saude_id", nullable = false)
    private ProfissionalSaude profissionalSaude;

    @OneToMany(mappedBy = "plano", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consultas;

    public Plano(Paciente paciente, Date dataPlano, Objetivo objetivo, NivelAtividadeFisica nivelAtividadeFisica, ProfissionalSaude profissionalSaude) {
        this.paciente = paciente;
        this.dataPlano = dataPlano;
        this.objetivo = objetivo;
        this.nivelAtividadeFisica = nivelAtividadeFisica;
        this.profissionalSaude = profissionalSaude;
    }   
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public ProfissionalSaude getProfissionalSaude() {
        return profissionalSaude;
    }

    public void setProfissionalSaude(ProfissionalSaude profissionalSaude) {
        this.profissionalSaude = profissionalSaude;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
