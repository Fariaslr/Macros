package Macronutrientes;

public class Macronutrientes {
    private float calorias;
    private float porcao;
    private int proporcao;
    private float gramasTotais;
    private float gramasPorRefeicao;
    private int quantidadeRefeicao;

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }

    public float getGramasTotais() {
        return gramasTotais;
    }

    public void setGramasTotais(float gramasTotais) {
        this.gramasTotais = gramasTotais;
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
    
    public float getGramasPorRefeicao () {
        return gramasPorRefeicao;
    }

    public void setGramasPorRefeicao(float gramasPorRefeicao) {
        this.gramasPorRefeicao = gramasPorRefeicao;
    }

    public int getQuantidadeRefeicao() {
        return quantidadeRefeicao;
    }

    public void setQuantidadeRefeicao(int quantidadeRefeicao) {
        this.quantidadeRefeicao = quantidadeRefeicao;
    }
    
    public void setProporcao(int proporcao) {
        this.proporcao = proporcao;
    }
    
    public void calculaPorcoesCaloricas( float gastoEnergeticoTotal){
        this.calorias = getPorcao() * gastoEnergeticoTotal; 
        calculaGramas();
    }
    
    public void calculaGramas(){
        this.gramasTotais = getCalorias() / getProporcao();
    }    
       
}
