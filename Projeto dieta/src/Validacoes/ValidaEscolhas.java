package Validacoes;


public class ValidaEscolhas {
    
    public boolean isActivity(byte nivelAtividade){
        
        if(nivelAtividade < 1 || nivelAtividade > 5 ){
            System.out.println("Nível inválido!");
            return false;            
        }else
            return true;
    }

    public boolean isObjective(byte objetivo) {
        
        if(objetivo < 1 || objetivo > 3){
           return false; 
        }else
            return true;
    }
}
