package com.mycompany.models;

import java.util.*;
import com.mycompany.enums.Objetivo;

public class Consulta {

    private int codigoConsulta;
    private Plano plano;
    private Date dataConsulta;
    private float peso;
    private float altura;
    private int numeroRefeicoes;
    private float circunferenciaAbdominal;
    private float circunferenciaBraco;
    private float circunferenciaPerna;
    private float medidaGorduraBarriga;
    private float medidaGorduraCostas;

    public Consulta() {
    }

    public Consulta(Plano plano, Date dataConsulta, float peso, float altura) {
        this.plano = plano;
        this.dataConsulta = dataConsulta;
        this.peso = peso;
        this.altura = altura;
    }

    public int getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(int codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getNumeroRefeicoes() {
        return numeroRefeicoes;
    }

    public void setNumeroRefeicoes(int numeroRefeicoes) {
        this.numeroRefeicoes = numeroRefeicoes;
    }

    public float getCircunferenciaAbdominal() {
        return circunferenciaAbdominal;
    }

    public void setCircunferenciaAbdominal(float circunferenciaAbdominal) {
        this.circunferenciaAbdominal = circunferenciaAbdominal;
    }

    public float getCircunferenciaBraco() {
        return circunferenciaBraco;
    }

    public void setCircunferenciaBraco(float circunferenciaBraco) {
        this.circunferenciaBraco = circunferenciaBraco;
    }

    public float getCircunferenciaPerna() {
        return circunferenciaPerna;
    }

    public void setCircunferenciaPerna(float circunferenciaPerna) {
        this.circunferenciaPerna = circunferenciaPerna;
    }

    public float getMedidaGorduraBarriga() {
        return medidaGorduraBarriga;
    }

    public void setMedidaGorduraBarriga(float medidaGorduraBarriga) {
        this.medidaGorduraBarriga = medidaGorduraBarriga;
    }

    public float getMedidaGorduraCostas() {
        return medidaGorduraCostas;
    }

    public void setMedidaGorduraCostas(float medidaGorduraCostas) {
        this.medidaGorduraCostas = medidaGorduraCostas;
    }

    public float calcularTaxaMetabolicaBasal() {
        switch (plano.getPaciente().getSexo()) {
            case MASCULINO:
                return (float) (66.5 + (13.75 * getPeso()) + (5.003 * getAltura()) - (6.75 * plano.getPaciente().calcularIdade()));
            case FEMININO:
                return (float) (655.1 + (9.563 * getPeso()) + (1.85 * getAltura()) - (4.676 * plano.getPaciente().calcularIdade()));
            default:
                return 0;
        }
    }

    public float calcularGastoEnergeticoTotal() {
        return calcularTaxaMetabolicaBasal() * plano.getNivelAtividadeFisica().getFATOR();
    }

    public float calcularCaloriasDieta() {
        if (plano.getObjetivo().equals(Objetivo.EMAGRECIMENTO)) {
            return calcularCaloriasEmagrecimento();
        } else {
            return calcularCaloriasHipertrofia();
        }
    }

    private float calcularCaloriasEmagrecimento() {
        return calcularGastoEnergeticoTotal() * 0.865f;
    }

    private float calcularCaloriasHipertrofia() {
        return calcularGastoEnergeticoTotal() * 1.223f;
    }

    public void calcularValorDiárioProteina() {

    }

    public void calcularValorDiárioCarboidrato() {

    }

    public void calcularValorDiárioGordura() {

    }
}
