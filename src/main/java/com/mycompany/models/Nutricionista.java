package com.mycompany.models;

import com.mycompany.enums.Sexo;

public class Nutricionista extends Pessoa {

    private String crn;

    public Nutricionista() {
    }

    public Nutricionista(String crn, String nome, String sobrenome, Sexo sexo) {
        super(nome, sobrenome, sexo);
        this.crn = crn;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

}
