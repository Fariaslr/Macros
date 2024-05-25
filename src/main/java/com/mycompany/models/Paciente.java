package com.mycompany.models;

import java.time.*;
import java.util.Date;
import com.mycompany.enums.Sexo;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    private Plano plano;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Consulta> consultas;

    public Paciente() {
    }

    public Paciente(Date dataNascimento, String nome, String sobrenome, Sexo sexo) {
        super(nome, sobrenome, sexo);
        this.dataNascimento = dataNascimento;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public int calcularIdade() {
        LocalDate birth = LocalDate.now();
        LocalDate nascimento = Instant.ofEpochMilli(dataNascimento.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        Period periodo = Period.between(nascimento, birth);
        return periodo.getYears();
    }
}
