package Validacoes;

public class ValidaReais {

    public boolean isWeight(float peso) {
        if (peso < 25 || peso > 240) {
            return false;
        }
        return true;
    }
}
