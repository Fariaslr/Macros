package Aplicacao;

import Validacoes.*;
import Dados.*;
import MacroNutrientes.*;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        // Declaração de leitura
        Scanner scanf =  new Scanner(System.in);
        
        // Instâncias de dados
        Atleta atleta = new Atleta();
        
        // Instâncias de macronutrientes
        Proteinas proteinas = new Proteinas(atleta.getObjetivo());    
        Carboidratos carboidratos = new Carboidratos(atleta.getObjetivo());
        Gorduras gorduras = new Gorduras(atleta.getObjetivo());        
        
        // Instâncias de validação
        ValidaCpf validaCpf = new ValidaCpf();
        ValidaNome validaNome = new ValidaNome();
        ValidaDados validaDados = new ValidaDados();
        ValidaEscolhas validaEscolhas = new ValidaEscolhas();
        
         // Entrada do CPF
        do {  
            System.out.printf("CPF: ");
            atleta.setCpf(scanf.nextLine());
        } while(validaCpf.isCPF(atleta.getCpf()) == false);

         // Entrada do Nome
        do {  
            System.out.printf("Nome: ");
            atleta.setNome(scanf.nextLine());
        } while(validaNome.isName(atleta.getNome()) == false); 
        
        // Entrada do Nome
        do {  
            System.out.printf("Sobrenome: ");
            atleta.setSobrenome(scanf.nextLine());
        } while(validaNome.isLastName(atleta.getSobrenome()) == false); 
        
         // Entrada da idade    
         do {            
             System.out.printf("Idade: ");
             atleta.setIdade(scanf.nextByte());
        } while (validaDados.isAge(atleta.getIdade()) == false);
         
         // Entrada da altura
         do {            
             System.out.printf("Altura(cm): ");
             atleta.setAltura(scanf.nextShort());
        } while (validaDados.isHeight(atleta.getAltura()) == false);
        
         // Entrada do peso
         do {            
             System.out.printf("Peso(Kg): ");
             atleta.setPeso(scanf.nextShort());
        } while (validaDados.isWeight(atleta.getPeso()) == false);
         
         // Entrada do sexo
         do {
             System.out.printf("Sexo(M/F): ");
             atleta.setSexo(scanf.next().toUpperCase());
         } while(validaNome.isSexo(atleta.getSexo()) ==  false);
         
        // Método para calcular a taxa metabolica basal
        atleta.calculaTaxaMetabolicaBasal();
               
         // Escolha de nível da atividade
         do {            
             System.out.printf("\nNível de atividade\n1 - Sedentário (Exercício mínimo)\n2 - Exercício Leve (1-3 dias por semana)\n"
                    + "3 - Exercício Moderado (3-5 dias por semana)\n4 - Exercício Intenso (6-7 dias por semana)\n"
                    + "5 - Exercício Muito Intenso (Atleta, 2x por dia)\n");
                atleta.setNivelAtividadeFisica(scanf.nextByte());
                
             switch(atleta.getNivelAtividadeFisica()){
                 case 1:
                     atleta.calculaGastoEnergeticoTotal(1.2);
                    break;
                 case 2:
                     atleta.calculaGastoEnergeticoTotal(1.375);
                    break;
                 case 3:
                    atleta.calculaGastoEnergeticoTotal(1.55);
                    break;
                 case 4:
                    atleta.calculaGastoEnergeticoTotal(1.725);
                    break;
                 case 5:
                    atleta.calculaGastoEnergeticoTotal(1.9);
                    break;
                 default:
                     break;
             }
        } while (validaEscolhas.isActivity(atleta.getNivelAtividadeFisica()) == false);
        
         do {            
             System.out.printf("Qual é o seu objetivo?\n[1] Perda de gordura\n[2] Manutenção\n[3] Aumento do peso\n");
             atleta.setObjetivo(scanf.nextByte());
             atleta.determinaDieta();  
        } while (validaEscolhas.isObjective(atleta.getObjetivo()) == false);
         
         // Métodos para calcular Porções caloricas
         proteinas.calculaPorcoesCaloricas(atleta.getGastoEnergeticoTotal());
         carboidratos.calculaPorcoesCaloricas(atleta.getGastoEnergeticoTotal());
         gorduras.calculaPorcoesCaloricas(atleta.getGastoEnergeticoTotal());
         
         System.out.printf("%s, a sua necessidade calorica diaria %.2f Kcal\n",atleta.getNome(),atleta.getGastoEnergeticoTotal());
         proteinas.imprime();
         carboidratos.imprime();
         gorduras.imprime();
         
    }
}
