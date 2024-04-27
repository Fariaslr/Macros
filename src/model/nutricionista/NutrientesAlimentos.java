package model.nutricionista;

public class NutrientesAlimentos {

    private Nutriente nutriente;
    private Alimento alimento;
    private int gramas;
    private int kcal;

    public Nutriente getNutriente() {
        return nutriente;
    }

    public void setNutriente(Nutriente nutriente) {
        this.nutriente = nutriente;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
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
