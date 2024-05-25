package com.mycompany.models;

import com.mycompany.enums.Sexo;
import java.util.List;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProfissionalSaude extends Pessoa {

    @OneToMany(mappedBy = "profissionalSaude", cascade = CascadeType.ALL)
    private List<Plano> planos;

    @OneToMany(mappedBy = "profissionalSaude", cascade = CascadeType.ALL)
    private List<Consulta> consultas;

    public ProfissionalSaude() {
    }

    public ProfissionalSaude(String nome, String sobrenome, Sexo sexo) {
        super(nome, sobrenome, sexo);
    }

    public List<Plano> getPlanos() {
        return planos;
    }

    public void setPlanos(List<Plano> planos) {
        this.planos = planos;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
