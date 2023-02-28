package PacoteTemporario;

public class NutrientesAlimentos {
    
    private int codigoNutrientes;
    private int codigoAlimento;
    private int gramas;
    private int kcal;

    public NutrientesAlimentos(int codigoNutrientes, int codigoAlimento) {
        this.codigoNutrientes = codigoNutrientes;
        this.codigoAlimento = codigoAlimento;
    }

    public int getCodigoNutrientes() {
        return codigoNutrientes;
    }

    public void setCodigoNutrientes(int codigoNutrientes) {
        this.codigoNutrientes = codigoNutrientes;
    }

    public int getCodigoAlimento() {
        return codigoAlimento;
    }

    public void setCodigoAlimento(int codigoAlimento) {
        this.codigoAlimento = codigoAlimento;
    }

    public int getGramas() {
        return gramas;
    }

    public void setGramas(int gramas) {
        this.gramas = gramas;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }
    
        
}
