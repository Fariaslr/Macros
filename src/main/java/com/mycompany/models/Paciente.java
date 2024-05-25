package com.mycompany.models;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import com.mycompany.enums.Sexo;

public class Paciente extends Pessoa {

    private Date dataNascimento;

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Paciente() {
    }

    public Paciente(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Paciente(Date dataNascimento, String nome, String sobrenome, Sexo sexo) {
        super(nome, sobrenome, sexo);
        this.dataNascimento = dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int calcularIdade() {
        LocalDate birth = LocalDate.now();
        LocalDate nascimento = Instant.ofEpochMilli(dataNascimento.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        Period periodo = Period.between(nascimento, birth);
        return periodo.getYears();
    }
}
