package MacroNutrientes;

import Dados.*;

public class Macronutrientes {
    private float calorias;
    private float porcao;
    private float gramas;
    private int proporcao;

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }

    public float getGramas() {
        return gramas;
    }

    public void setGramas(float gramas) {
        this.gramas = gramas;
    }

    public float getPorcao() {
        return porcao;
    }

    public void setPorcao(float porcao) {
        this.porcao = porcao;
    }

    public int getProporcao() {
        return proporcao;
    }

    public void setProporcao(int proporcao) {
        this.proporcao = proporcao;
    }
    public void calculaPorcoesCaloricas( float gastoEnergeticoTotal){
        this.calorias = getPorcao() * gastoEnergeticoTotal; 
        calculaGramas();
    }
    public void calculaGramas(){
        this.gramas = getCalorias() / getProporcao();
    }

}
