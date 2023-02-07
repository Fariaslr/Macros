package Aplicacao;

import Dados.Atleta;
import Validacoes.*;

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
        ValidaSexo validaSexo = new ValidaSexo();
      
         // Entrada do CPF
        /*do {  
            System.out.printf("CPF: ");
            atleta.setCpf(scanf.nextLine());
            validaCpf.isCPF(atleta.getCpf());
            if(validaCpf.isCPF(atleta.getCpf()) == false)
                System.out.printf("Cpf inválido, insira novamente!\n");
        } while(validaCpf.isCPF(atleta.getCpf()) == false);

         // Entrada do Nome
        do {  
            System.out.printf("Nome: ");
            atleta.setNome(scanf.nextLine());
            validaNome.isName(atleta.getNome());
            if(validaNome.isName(atleta.getNome()) == false)
                System.out.printf("Contém caracter inválido\nInsira novamente!\n\n");
        } while(validaNome.isName(atleta.getNome()) == false); 
 */
         // Entrada da idade    
         do {            
             System.out.printf("Idade: ");
             atleta.setIdade(scanf.nextInt());
             if(atleta.getIdade() < 1 || atleta.getIdade() > 150)
                 System.out.printf("Idade inválida!");
        } while (atleta.getIdade() < 1 || atleta.getIdade() > 150);
         
         // Entrada da altura
         do {            
             System.out.printf("Altura(cm): ");
             atleta.setAltura(scanf.nextInt());
             if(atleta.getAltura() < 50 || atleta.getAltura() > 275)
                 System.out.printf("Altura inválida!\n");
        } while (atleta.getAltura() < 50 || atleta.getAltura() > 275);
        
        
         // Entrada do peso
         do {            
             System.out.printf("Peso(Kg): ");
             atleta.setPeso(scanf.nextFloat());
             if(atleta.getPeso() < 35 || atleta.getPeso() > 275)
                 System.out.printf("Peso inválido!\n");
        } while (atleta.getPeso() < 35 || atleta.getPeso() > 275);
         
         // Entrada do sexo
         do {
             System.out.printf("Sexo(M/F): ");
             atleta.setSexo(scanf.next().toUpperCase());
             if(ValidaSexo.isSexo(atleta.getSexo()) ==  false)
                 System.out.printf("Sexo inválido!\n");
         } while(ValidaSexo.isSexo(atleta.getSexo()) ==  false);
         
        // Método para calcular a taxa metabolica basal
        atleta.calculaTaxaMetabolicaBasal();
                  
         // Escolha de nível da atividade
         do {            
             System.out.printf("\nNível de atividade\n1 - Sedentário (Exercício mínimo)\n"
                    + "2 - Exercício Leve (1-3 dias por semana)\n"
                    + "3 - Exercício Moderado (3-5 dias por semana)\n"
                    + "4 - Exercício Intenso (6-7 dias por semana)\n"
                    + "5 - Exercício Muito Intenso (Atleta, 2x por dia)\n");
                atleta.setNivelAtividadeFisica(scanf.nextInt());             
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
                     System.out.printf("Opção Inválida!\n");
                     break;
             }
        } while (atleta.getNivelAtividadeFisica() < 1 || atleta.getNivelAtividadeFisica() > 5);
        
         do {            
             System.out.printf("Qual é o seu objetivo?\n"
                     + "[1] Perda de gordura\n"
                     + "[2] Manutenção\n"
                     + "[3] Aumento do peso\n");
             atleta.setObjetivo(scanf.nextInt());
             atleta.determinaDieta();  
        } while (atleta.getObjetivo() < 1 || atleta.getObjetivo() > 3);
         
         proteinas.calculaPorcoesCaloricas(atleta.getGastoEnergeticoTotal());
         carboidratos.calculaPorcoesCaloricas(atleta.getGastoEnergeticoTotal());
         gorduras.calculaPorcoesCaloricas(atleta.getGastoEnergeticoTotal());
         
         System.out.printf("%s, a sua necessidade calorica diaria %.2f Kcal\n",atleta.getNome(),atleta.getGastoEnergeticoTotal());
         proteinas.imprime();
         carboidratos.imprime();
         gorduras.imprime();
    }
}
