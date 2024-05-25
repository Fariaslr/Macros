package com.mycompany.models;

import com.mycompany.enums.Sexo;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nutricionistas")
public class Nutricionista extends ProfissionalSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String crn;

    public Nutricionista() {
    }

    public Nutricionista(String crn, String nome, String sobrenome, Sexo sexo) {
        super(nome, sobrenome, sexo);
        this.crn = crn;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

}
