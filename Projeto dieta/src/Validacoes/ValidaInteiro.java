package Validacoes;

public class ValidaInteiro {

    public boolean isActivity(int nivelAtividade) {

        if (nivelAtividade < 1 || nivelAtividade > 5) {
            System.out.println("Nível inválido!");
            return false;
        }
        return true;
    }

    public boolean isObjective(int objetivo) {

        if (objetivo < 1 || objetivo > 3) {
            System.out.println("Objetivo inválido");
            return false;
        }
        return true;
    }

    public boolean isHeight(int altura) {
        if (altura < 35 || altura > 230) {
            System.out.println("Altura inválida");
            return false;
        }
        return true;
    }

    public boolean isAge(int idade) {

        if (idade < 1 || idade > 120) {
            System.out.println("Idade inválida");
            return false;
        }
        return true;
    }

    public boolean isNumberOfMeals(int numeroRefeicoes) {
        if (numeroRefeicoes < 1 || numeroRefeicoes > 5) {
            System.out.println("Nível inválido");
            return false;
        }
        return true;
    }

}
