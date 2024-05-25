package com.mycompany.models;

import com.mycompany.enums.DivisaoTreino;

public class TreinoExercicio {

    private int id;
    private Exercicio exercicio;
    private DivisaoTreino divisao;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int converterMinutos() {
        return this.intervaloSerie / 60;
    }
    
    public int mostarSegundos () {
        return this.intervaloSerie % 60;
    }

    @Override
    public String toString() {
        return "TreinoExercicio{" + "exercicio=" + exercicio + ", divisao=" + divisao + ", series=" + series + ", repeticoes=" + repeticoes + ", carga=" + carga + ", intervaloSerie=" + intervaloSerie + '}';
    }
}
