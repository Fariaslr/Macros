package com.mycompany.models;

import com.mycompany.enums.GrupoMuscular;
import java.awt.Image;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.swing.ImageIcon;

@Entity
@Table(name = "exercicios")
public class Exercicio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "grupo_muscular")
    @Enumerated(EnumType.STRING)
    private GrupoMuscular grupoMuscular;

    @OneToMany(mappedBy = "exercicio", cascade = CascadeType.ALL)
    private List<TreinoExercicio> treinoExercicios;

    @Column(length = 40)
    private String nome;

    @Column(length = 3000)
    private String descricao;

    @Column(name = "url_foto", length = 255)
    private String urlFoto;

    public Exercicio() {
    }

    public Exercicio(GrupoMuscular grupoMuscular, String nome, String descricao, String urlFoto) {
        this.grupoMuscular = grupoMuscular;
        this.nome = nome;
        this.descricao = descricao;
        this.urlFoto = urlFoto;
    }

    public Exercicio(UUID id, String nome, String descricao, GrupoMuscular grupoMuscular, String urlFoto) {
        this.id = id;
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

    public List<TreinoExercicio> getTreinoExercicios() {
        return treinoExercicios;
    }

    public void setTreinoExercicios(List<TreinoExercicio> treinosExercicios) {
        this.treinoExercicios = treinosExercicios;
    }

    public ImageIcon getFotoIcon() {
        try {
            ImageIcon imageIcon = new ImageIcon(urlFoto);
            Image image = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return nome + " - " + grupoMuscular.getNome();
    }
}
