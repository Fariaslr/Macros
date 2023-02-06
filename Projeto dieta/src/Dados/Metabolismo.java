package Dados;

public class Metabolismo {
        
    // Variáveis da classe Metabolismo
    private int nivelAtividadeFisica;
    private float gastoEnergeticoTotal;
    private float taxaMetabolicaBasal;
    private int objetivo;
    
    public void setNivelAtividadeFisica(int nivelAtividadeFisica) {
        this.nivelAtividadeFisica = nivelAtividadeFisica;
    }

    public int getNivelAtividadeFisica() {
        return nivelAtividadeFisica;
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
        this.gastoEnergeticoTotal = (float) (gastoEnergeticoTotal * 0.865);
    }
    
    public void aumentarPeso(){
        this.gastoEnergeticoTotal = (float) (gastoEnergeticoTotal * 1.223);
    }
}
