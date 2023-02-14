package Macronutrientes;

public class Gorduras extends Macronutrientes{

    public Gorduras(int objetivo) {
        super.setProporcao(9);
        switch (objetivo) {
            case 1:
                this.setPorcao(0.17f);
                break;
            case 2:
                this.setPorcao(0.18f);
                break;
            default:
                this.setPorcao(0.19f);
                break;
        }
    }
    
    public void calculaGramasPorRefeicao(float quantidadeRefeicao) {
       setGramasPorRefeicao(getGramasTotais() / quantidadeRefeicao);
    }
    
     public void imprimeGramasTotais () {
        System.out.printf("Gorduras %.0fg\n",getGramasTotais());
    }
     public void imprimeGramasPorRefeicao () {
        System.out.printf("Gorduras %.0fg\n",getGramasPorRefeicao());
    }
}
