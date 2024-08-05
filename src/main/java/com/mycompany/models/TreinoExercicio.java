package com.mycompany.models;

import com.mycompany.enums.DivisaoTreino;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "treino_exercicios")
public class TreinoExercicio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private DivisaoTreino divisao;

    @ManyToOne
    @JoinColumn(name = "exercicio_id", nullable = false)
    private Exercicio exercicio;

    @ManyToOne
    @JoinColumn(name = "treino_id", nullable = false)
    private Treino treino;

    private int series;

    private int repeticoes;

    private float carga;

    private int intervaloSerie;

    public TreinoExercicio() {
    }

    public TreinoExercicio(Exercicio exercicio, DivisaoTreino divisao, int series, int repeticoes, float carga, int intervaloSerie) {
        this.exercicio = exercicio;
        this.divisao = divisao;
        this.series = series;
        this.repeticoes = repeticoes;
        this.carga = carga;
        this.intervaloSerie = intervaloSerie;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public DivisaoTreino getDivisao() {
        return divisao;
    }

    public void setDivisao(DivisaoTreino divisao) {
        this.divisao = divisao;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public float getCarga() {
        return carga;
    }

    public void setCarga(float carga) {
        this.carga = carga;
    }

    public int getIntervaloSerie() {
        return intervaloSerie;
    }

    public void setIntervaloSerie(int intervaloSerie) {
        this.intervaloSerie = intervaloSerie;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public String mostrarIntevalo() {
        return this.intervaloSerie / 60 + "min" + (intervaloSerie % 60 == 0 ? "" : " e " + intervaloSerie % 60 + " seg");
    }

    @Override
    public String toString() {
        return "TreinoExercicio{" + "exercicio=" + exercicio + ", divisao=" + divisao + ", series=" + series + ", repeticoes=" + repeticoes + ", carga=" + carga + ", intervaloSerie=" + intervaloSerie + '}';
    }
}
