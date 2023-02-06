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
        }return true;
    }
}