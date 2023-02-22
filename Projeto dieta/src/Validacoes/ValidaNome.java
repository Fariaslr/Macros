package Validacoes;

public class ValidaNome {
    
    public static boolean isName(String nome){
  
        int contadorMaiuscula = 0;

         for( int i = 0; i < nome.length(); i++ ){
             
             if(nome.length() < 5){
                 return false;
             } 
             
             if(nome.codePointAt(i) >= 65 && nome.codePointAt(i) <= 90 ){ //Conta Maiúsculas
                 contadorMaiuscula++;
             }
             if(nome.codePointAt(i) >= 33 && nome.codePointAt(i) <= 64 
                     || nome.codePointAt(i) >= 91 && nome.codePointAt(i) <= 96 ){ // Verifica caracteres especiais
                 return false;  
             }   
             
         } // fim do laço
         
         if(nome.codePointAt(0) >= 65 && nome.codePointAt(0) <= 90){
             if(contadorMaiuscula > 1){
                 return false;
             }else
                 return true;
        }
         return true;
    }
    
    public boolean isLastName(String sobrenome){
        
        for( int i = 0; i < sobrenome.length(); i++ ){
            
            if(sobrenome.length() < 3){
                System.out.println("Sobrenome curto!");
                 return false;
             }
            
            if(sobrenome.codePointAt(i) >= 33 && sobrenome.codePointAt(i) <= 64 
                     || sobrenome.codePointAt(i) >= 91 && sobrenome.codePointAt(i) <= 96 ){ // Verifica caracteres especiais
                System.out.println("Contém caracteres inválidos");
                 return false;  
             } 
            
        }
        return true;
        
    }
      
     public static boolean isSexo(String sexo){
        if(sexo.length() ==  1){
            if(sexo.equals("F") || sexo.equals("M")){
                return true;
            }
        }
        System.out.println("Insira 'M ou 'F'");
        return false;
    }
}