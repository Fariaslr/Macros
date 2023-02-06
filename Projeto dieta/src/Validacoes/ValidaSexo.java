package Validacoes;
public class ValidaSexo {
    public static boolean isSexo(String sexo){
        if(sexo.length() ==  1){
            if(sexo.equals("F") || sexo.equals("M")){
                return true;
            }
        }
        return false;
    }
}
