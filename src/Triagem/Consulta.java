package Triagem;

import Pessoa.Nutricionista;
import Pessoa.Paciente;
import java.util.*;

public class Consulta {

    private int codigoConsulta;
    private Plano plano;
    private Date dataConsulta;
    private Paciente paciente;
    private Nutricionista nutri;
    private int idade;
    private float peso;
    private int altura;
    private int nivelAtividadeFisica;
    private float taxaMetabolicaBasal;
    private int numeroRefeicoes;
    private float gastoEnergeticoTotal;
    private float circunferenciaAbdominal;
    private float circunferenciaBraco;
    private float circunferenciaPerna;
    private float medidaGorduraBarriga;
    private float medidaGorduraCostas;
    private float valorDiarioProteina;
    private float valorDiarioCarboidrato;
    private float valorDiarioGordura;

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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Nutricionista getNutri() {
        return nutri;
    }

    public void setNutri(Nutricionista nutri) {
        this.nutri = nutri;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getNivelAtividadeFisica() {
        return nivelAtividadeFisica;
    }

    public void setNivelAtividadeFisica(int nivelAtividadeFisica) {
        this.nivelAtividadeFisica = nivelAtividadeFisica;
    }

    public float getTaxaMetabolicaBasal() {
        return taxaMetabolicaBasal;
    }

    public void setTaxaMetabolicaBasal(float taxaMetabolicaBasal) {
        this.taxaMetabolicaBasal = taxaMetabolicaBasal;
    }

    public int getNumeroRefeicoes() {
        return numeroRefeicoes;
    }

    public void setNumeroRefeicoes(int numeroRefeicoes) {
        this.numeroRefeicoes = numeroRefeicoes;
    }

    public float getGastoEnergeticoTotal() {
        return gastoEnergeticoTotal;
    }

    public void setGastoEnergeticoTotal(float gastoEnergeticoTotal) {
        this.gastoEnergeticoTotal = gastoEnergeticoTotal;
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

    public float getValorDiarioProteina() {
        return valorDiarioProteina;
    }

    public void setValorDiarioProteina(float valorDiarioProteina) {
        this.valorDiarioProteina = valorDiarioProteina;
    }

    public float getValorDiarioCarboidrato() {
        return valorDiarioCarboidrato;
    }

    public void setValorDiarioCarboidrato(float valorDiarioCarboidrato) {
        this.valorDiarioCarboidrato = valorDiarioCarboidrato;
    }

    public float getValorDiarioGordura() {
        return valorDiarioGordura;
    }

    public void setValorDiarioGordura(float valorDiarioGordura) {
        this.valorDiarioGordura = valorDiarioGordura;
    }

    

    public void calculaTaxaMetabolicaBasal(String sexo) {
        if (sexo.equals("M")) {
            this.taxaMetabolicaBasal = (float) (66 + (13.7 * getPeso()) + (5 * getAltura()) - (6.8 * getIdade()));
        }
        if (sexo.equals("F")) {
            this.taxaMetabolicaBasal = (float) (655 + (9.6 * getPeso()) + (1.8 * getAltura()) - (4.7 * getIdade()));
        }
    }

    public void calculaGastoEnergeticoTotal(float IndiceNivelAtividade) {
        this.gastoEnergeticoTotal = (float) (this.taxaMetabolicaBasal * IndiceNivelAtividade);
    }

    public void determinaDieta(int objetivo) {
        if (objetivo == 1) {
            diminuirPeso();
        }
        if (objetivo == 3) {
            aumentarPeso();
        }
    }

    public void diminuirPeso() {
        this.gastoEnergeticoTotal = (gastoEnergeticoTotal * 0.865f);
    }

    public void aumentarPeso() {
        this.gastoEnergeticoTotal = (gastoEnergeticoTotal * 1.223f);
    }
}
