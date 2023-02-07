package Dados;

public class Atleta extends Pessoa {
        
    private float taxaMetabolicaBasal;
    private float gastoEnergeticoTotal;
    private int nivelAtividadeFisica;
    private int objetivo;

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

    public int getNivelAtividadeFisica() {
        return nivelAtividadeFisica;
    }

    public void setNivelAtividadeFisica(int nivelAtividadeFisica) {
        this.nivelAtividadeFisica = nivelAtividadeFisica;
    }

    public void calculaGastoEnergeticoTotal(double GET){
        this.gastoEnergeticoTotal = (float) (this.taxaMetabolicaBasal * GET);
    }

    public int getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(int objetivo) {
        this.objetivo = objetivo;
    }
    
    public void determinaDieta(){
       if(objetivo == 1){
           diminuirPeso();
       }
       else if(objetivo == 3){
           aumentarPeso();
       }
    }
    
    public void diminuirPeso(){
        this.gastoEnergeticoTotal = (gastoEnergeticoTotal * 0.865f);
    }
    
    public void aumentarPeso(){
        this.gastoEnergeticoTotal = (gastoEnergeticoTotal * 1.223f);
    }
    
    public void calculaTaxaMetabolicaBasal() {
        if(getSexo().equals("M"))
            this.taxaMetabolicaBasal = (float) (66 + (13.7 * getPeso()) + (5 * getAltura()) - (6.8 * getIdade()));
        if(getSexo().equals("F"))
            this.taxaMetabolicaBasal = (float) (655 + (9.6 * getPeso()) + (1.8 * getAltura()) - (4.7 * getIdade()));
    }
}
