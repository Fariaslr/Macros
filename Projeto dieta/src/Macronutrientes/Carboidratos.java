package Macronutrientes;

public class Carboidratos extends Macronutrientes{

    public Carboidratos(int objetivo) {
        super.setProporcao(4);
        switch (objetivo) {
            case 1:
                this.setPorcao(0.38f);
                break;
            case 2:
                this.setPorcao(0.49f);
                break;
            default:
                this.setPorcao(0.53f);
                break;
        }
    }
    
     public void calculaGramasPorRefeicao(float quantidadeRefeicao) {
       setGramasPorRefeicao(getGramasTotais() / quantidadeRefeicao);
    } 
    
     public void imprimeGramasTotais () {
        System.out.printf("Carboidratos %.0fg\n",getGramasTotais());
    }
     
     public void imprimeGramasPorRefeicao () {
        System.out.printf("Carboidratos %.0fg\n",getGramasPorRefeicao());
    }
}
