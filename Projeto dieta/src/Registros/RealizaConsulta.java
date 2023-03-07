package Registros;

import Triagem.*;
import Pessoa.*;
import Validacoes.ValidaDados;
import Validacoes.ValidaEscolhas;
import java.text.*;
import java.util.*;

public class RealizaConsulta {

    public void fazendoConsulta() {

        // Instância de objetos para as chaves primárias
        Paciente paciente = new Paciente();
        Nutricionista nutricionista = new Nutricionista();
        Plano plano = new Plano(paciente.getCpf(), nutricionista.getCpf());
        Consulta consulta = new Consulta(plano.getCodigoPlano());
        
        // Instâmcia para validação
        ValidaDados validaDados = new ValidaDados();
        ValidaEscolhas validaEscolhas = new ValidaEscolhas();
        
        // Instância de leitura
        Scanner scanf = new Scanner(System.in);
        
        // Instância de formatação de data
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

        // Gerador de números aleatórios
        Random geradorNumeros = new Random();
        

        consulta.setCodigoConsulta(geradorNumeros.nextInt(9999));
        consulta.setDataConsulta(new Date());
        
         do {            
             System.out.printf("Peso(Kg): ");
             consulta.setPeso(scanf.nextShort());
        } while (validaDados.isWeight(consulta.getPeso()) == false);
         
         do {            
             System.out.printf("Altura(cm): ");
             consulta.setAltura(scanf.nextShort());
        } while (validaDados.isHeight(consulta.getAltura()) == false);
         
         consulta.calculaTaxaMetabolicaBasal(paciente.getSexo());
         
         do {            
             System.out.printf("\nNível de atividade\n1 - Sedentário (Exercício mínimo)\n2 - Exercício Leve (1-3 dias por semana)\n"
                    + "3 - Exercício Moderado (3-5 dias por semana)\n4 - Exercício Intenso (6-7 dias por semana)\n"
                    + "5 - Exercício Muito Intenso (Atleta, 2x por dia)\n");
                consulta.setNivelAtividadeFisica(scanf.nextByte());
                switch(consulta.getNivelAtividadeFisica()){
                 case 1:
                     consulta.calculaGastoEnergeticoTotal(1.2f);
                    break;
                 case 2:
                     consulta.calculaGastoEnergeticoTotal(1.375f);
                    break;
                 case 3:
                    consulta.calculaGastoEnergeticoTotal(1.55f);
                    break;
                 case 4:
                    consulta.calculaGastoEnergeticoTotal(1.725f);
                    break;
                 case 5:
                    consulta.calculaGastoEnergeticoTotal(1.9f);
                    break;
                 default:
                     break;
             }
        } while (validaEscolhas.isActivity(consulta.getNivelAtividadeFisica()) == false);
         
         
    }
}
