package com.mycompany.models;

import com.mycompany.enums.Sexo;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "educadores_fisicos")
public class EducadorFisico extends ProfissionalSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String cref;

    @OneToMany
    private List<Treino> treinos;

    public EducadorFisico() {
    }

    public EducadorFisico(String cref, String nome, String sobrenome, Sexo sexo) {
        super(nome, sobrenome, sexo);
        this.cref = cref;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }
    
    

}
