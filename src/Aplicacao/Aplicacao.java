package Aplicacao;

import Interfaces.ALogin;
import java.text.ParseException;

public class Aplicacao {

    public static void main(String[] args) throws ParseException {
        
       new ALogin().setVisible(true);
    }
}
