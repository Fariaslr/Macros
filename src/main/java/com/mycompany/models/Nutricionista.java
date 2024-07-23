package com.mycompany.models;

import com.mycompany.enums.Sexo;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nutricionistas")
public class Nutricionista extends Pessoa {

    private String crn;

    public Nutricionista() {
    }

    public Nutricionista(Date dataNascimento, String crn, String nome, String sobrenome, Sexo sexo) {
        super(dataNascimento, nome, sobrenome, sexo);
        this.crn = crn;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

}
