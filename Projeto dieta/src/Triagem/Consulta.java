package Triagem;

import java.util.Date;

public class Consulta {
    
    private int codigoConsulta;
    private int codigoPlano;
    private Date dataConsulta;
    private int idade;
    private float peso;
    private int altura;
    private int nivelAtividade;
    private float taxaMetabolicaBasal;
    private float gastoEnergeticoTotal;
    private int numeroRefeicoes;
    private float circunferenciaAbdominal;
    private float circunferenciaBraco;
    private float circunferenciaPerna;
    private float medidaGorduraBarriga;       
    private float medidaGorduraCostas;
    private float valorDiarioProteina;
    private float valorDiarioCarboidrato;
    private float valorDiarioGordura;

    public Consulta( int codigoPlano) {
        this.codigoPlano = codigoPlano;
    }

    public int getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(int codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public int getCodigoPlano() {
        return codigoPlano;
    }

    public void setCodigoPlano(int codigoPlano) {
        this.codigoPlano = codigoPlano;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
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

    public int getNivelAtividade() {
        return nivelAtividade;
    }

    public void setNivelAtividade(int nivelAtividade) {
        this.nivelAtividade = nivelAtividade;
    }

    public float getTaxaMetabolicaBasal() {
        return taxaMetabolicaBasal;
    }

    public void setTaxaMetabolicaBasal(float taxaMetabolicaBasal) {
        this.taxaMetabolicaBasal = taxaMetabolicaBasal;
    }

    public float getGastoEnergeticoTotal() {
        return gastoEnergeticoTotal;
    }

    public void setGastoEnergeticoTotal(float gastoEnergeticoTotal) {
        this.gastoEnergeticoTotal = gastoEnergeticoTotal;
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
    
    
}
