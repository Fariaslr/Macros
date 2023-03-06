package Registros;

import Triagem.Consulta;
import Triagem.Plano;
import Pessoa.Nutricionista;
import Pessoa.Paciente;
import java.util.*;

public class RealizaConsulta {
    
    public void fazendoConsulta (){
        
        // Instância de objetos para as chaves primárias
        Paciente paciente = new Paciente();
        Nutricionista nutricionista = new Nutricionista();
        Plano plano = new Plano(paciente.getCpf(),nutricionista.getCpf());
        Consulta consulta = new Consulta(plano.getCodigoPlano());
        
        // Gerador de números aleatórios
        Random geradorNumeros = new Random();
        
        //do {            
            consulta.setCodigoConsulta(geradorNumeros.nextInt(9999));
        //} while (true);
        
        /*do {            
            Adicionar a data da consulta
        } while (true);*/
        
    }
}
