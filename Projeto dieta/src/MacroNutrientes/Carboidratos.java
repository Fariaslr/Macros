package MacroNutrientes;

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
    
    public void imprime(){
        System.out.printf("Carboidratos %.0fg\n",getGramas());
    }
}
