package com.mycompany.models;

import com.mycompany.enums.Sexo;

public class EducadorFisico extends Pessoa {

    private String cref;

    public EducadorFisico() {
    }

    public EducadorFisico(String cref, String nome, String sobrenome, Sexo sexo) {
        super(nome, sobrenome, sexo);
        this.cref = cref;
    }
    
    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

}
