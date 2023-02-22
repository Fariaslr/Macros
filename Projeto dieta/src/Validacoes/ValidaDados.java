package Validacoes;

public class ValidaDados {
    
    public boolean isAge (byte idade) {
        
        if(idade < 1 || idade > 120) {
            System.out.println("Idade inválida");
            return false;
        }
        return true;
    }
    
    public boolean isHeight (short altura) {
        if(altura < 35 || altura > 230){
            System.out.println("Altura inválida");
            return false;
        }
        return true;
    }
    
    public boolean isWeight (short peso) {
        if(peso < 30 || peso > 240){
            return false;
        }
        return true;
    }
}
