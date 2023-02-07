package MacroNutrientes;

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
     public void imprime(){
        System.out.printf("Gorduras %.0fg\n",getGramas());
    }
}
