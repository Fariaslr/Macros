package model.nutricionista;

import java.util.List;

public class Alimento {

    private int codigoAlimento;
    private String nomeAlimento;
    private float porcaoAlimento;
    private List<Nutriente> nutrientes;

    public int getCodigoAlimento() {
        return codigoAlimento;
    }

    public void setCodigoAlimento(int codigoAlimento) {
        this.codigoAlimento = codigoAlimento;
    }

    public String getNomeAlimento() {
        return nomeAlimento;
    }

    public void setNomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }

    public float getPorcaoAlimento() {
        return porcaoAlimento;
    }

    public void setPorcaoAlimento(float porcaoAlimento) {
        this.porcaoAlimento = porcaoAlimento;
    }

    public List<Nutriente> getNutrientes() {
        return nutrientes;
    }

    public void setNutrientes(List<Nutriente> nutrientes) {
        this.nutrientes = nutrientes;
    }
    
}
