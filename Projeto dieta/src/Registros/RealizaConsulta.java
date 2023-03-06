package Registros;

import Triagem.*;
import Pessoa.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RealizaConsulta {
    
    public void fazendoConsulta (){
        
        // Instância de objetos para as chaves primárias
        Paciente paciente = new Paciente();
        Nutricionista nutricionista = new Nutricionista();
        Plano plano = new Plano(paciente.getCpf(),nutricionista.getCpf());
        Consulta consulta = new Consulta(plano.getCodigoPlano());
        Scanner scanf = new Scanner(System.in);
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        
        // Gerador de números aleatórios
        Random geradorNumeros = new Random();
        
        //do {            
            consulta.setCodigoConsulta(geradorNumeros.nextInt(9999));
        //} while (true);
                    
            consulta.setDataConsulta(new Date());
        
    }
}
