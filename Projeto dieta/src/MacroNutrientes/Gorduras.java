package MacroNutrientes;

public class Gorduras {
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
    
    public float calculaCalorias() {
        return (float) (gastoEnergeticoTotal * 0.19);
    }
    
    public float calculaGramas() {
        return (float) ((gastoEnergeticoTotal * 0.19) / 9);
    }
    
    public void imprimeGorduras(){
        System.out.printf("Gorduras = %.0fg\n",calculaGramas());
    }
}
