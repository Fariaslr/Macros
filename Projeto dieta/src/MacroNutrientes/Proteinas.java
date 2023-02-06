package MacroNutrientes;

public class Proteinas {
    private float gastoEnergeticoTotal;
    private float calorias;

    public float getGastoEnergeticoTotal() {
        return gastoEnergeticoTotal;
    }

    public void setGastoEnergeticoTotal(float gastoEnergeticoTotal) {
        this.gastoEnergeticoTotal = gastoEnergeticoTotal;
    }
    
    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }
    
    public float calculaCalorias(){
        return (float) (gastoEnergeticoTotal * 0.27);
    }
    
    public float calculaGramas(){
        return (float) ((gastoEnergeticoTotal * 0.27) / 4);
    }
    
    public void imprimeProteinas(){
        System.out.printf("Proteínas = %.0fg\n",calculaGramas());
    }
}
