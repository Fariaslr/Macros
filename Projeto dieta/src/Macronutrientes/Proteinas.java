package Macronutrientes;

public class Proteinas extends Macronutrientes {
    
    public Proteinas(int objetivo) {
        super.setProporcao(4);
        switch (objetivo) {
            case 1:
                this.setPorcao(0.45f);
                break;
            case 2:
                this.setPorcao(0.33f);
                break;
            default:
                this.setPorcao(0.27f);
                break;
        }
    }
    
    public void calculaGramasPorRefeicao(float quantidadeRefeicao) {
       setGramasPorRefeicao(getGramasTotais() / quantidadeRefeicao);
    }
    
     public void imprimeGramasTotais () {
        System.out.printf("Proteínas %.0fg\n",getGramasTotais());
    }
     
     public void imprimeGramasPorRefeicao () {
        System.out.printf("Proteínas %.0fg\n",getGramasPorRefeicao());
    }
}
