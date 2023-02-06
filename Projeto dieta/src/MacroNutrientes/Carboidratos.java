package MacroNutrientes;


public class Carboidratos {
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
        return (float) (gastoEnergeticoTotal * 0.53);
    }
    public float calculaGramas(){
        return (float) ((gastoEnergeticoTotal * 0.53) / 4);
    }
    public void imprimeCarboidratos(){
        System.out.printf("Carboidratos = %.0fg\n",calculaGramas());
    }
}
