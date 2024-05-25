package com.mycompany.models;

import com.mycompany.enums.GrupoMuscular;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "exercicios")
public class Exercicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private GrupoMuscular grupoMuscular;

    private String nome;
    private String descricao;
    private String urlFoto;

    @OneToMany(mappedBy = "exercicio")
    private List<TreinoExercicio> treinosExercicios;

    public Exercicio() {
    }

    public Exercicio(int id, String nome, String descricao, GrupoMuscular grupoMuscular, String urlFoto) {
        this.nome = nome;
        this.descricao = descricao;
        this.grupoMuscular = grupoMuscular;
        this.urlFoto = urlFoto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public List<TreinoExercicio> getTreinosExercicios() {
        return treinosExercicios;
    }

    public void setTreinosExercicios(List<TreinoExercicio> treinosExercicios) {
        this.treinosExercicios = treinosExercicios;
    }
}
