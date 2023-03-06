package Validacoes;


public class ValidaEscolhas {
    
    public boolean isActivity(int nivelAtividade){
        
        if(nivelAtividade < 1 || nivelAtividade > 5 ){
            System.out.println("Nível inválido!");
            return false;            
        }else
            return true;
    }

    public boolean isObjective(int objetivo) {
        
        if(objetivo < 1 || objetivo > 3){
           return false; 
        }else
            return true;
    }
}
