package com.mycompany.models;

import com.mycompany.enums.GrupoMuscular;

public class Exercicio {

    private int id;
    private String nome;
    private String descricao;
    private GrupoMuscular grupoMuscular;
    private String urlFoto;

    public Exercicio() {
    }

    public Exercicio(int id, String nome, String descricao, GrupoMuscular grupoMuscular, String urlFoto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.grupoMuscular = grupoMuscular;
        this.urlFoto = urlFoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Exercicio{" + "nome=" + nome + ", grupoMuscular=" + grupoMuscular + '}';
    }

}
