package com.mycompany.models;

import com.mycompany.enums.Sexo;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "educadores_fisicos")
public class EducadorFisico extends ProfissionalSaude {

    private String cref;

    public EducadorFisico() {
    }

    public EducadorFisico(String cref, Date dataNascimento, String nome, String sobrenome, Sexo sexo) {
        super(dataNascimento, nome, sobrenome, sexo);
        this.cref = cref;
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

}
