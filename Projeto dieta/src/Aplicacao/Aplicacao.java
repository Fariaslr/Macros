package Aplicacao;

import java.util.Scanner;
import Pessoa.*;
import Validacoes.*;

public class Aplicacao {

    public static void main(String[] args) {

        //Instância de leitura
        Scanner scanf = new Scanner(System.in);

        //Intâncias de pessoa
        Nutricionista nutri = new Nutricionista();
        Paciente paciente = new Paciente();

        // Instâncias de validação
        ValidaCpf validaCpf = new ValidaCpf();
        ValidaNome validaNome = new ValidaNome();
        ValidaDados validaDados = new ValidaDados();
        ValidaEscolhas validaEscolhas = new ValidaEscolhas();
        
        System.out.println("Cadastro Nutricionista");
        // Cpf nutricionista
        do {
            System.out.printf("CPF: ");
            nutri.setCpf(scanf.nextLine());
        } while (ValidaCpf.isCPF(nutri.getCpf()) == false);
        
        // Registro Nutricionista
        do {            
            System.out.printf("Registro");
            nutri.setRegistroNutricionista(scanf.nextInt());
        } while (validaDados.isWeight(nutri.getRegistroNutricionista()) == false); // Falta uma validação para registro
        
        // Nome nutricionista
        do {  
            System.out.printf("Nome: ");
            nutri.setNome(scanf.nextLine());
        } while(ValidaNome.isName(nutri.getNome()) == false);
        
        // Sobrenome nutricionista
        do {  
            System.out.printf("Sobrenome: ");
            nutri.setSobrenome(scanf.nextLine());
        } while(validaNome.isLastName(nutri.getSobrenome()) == false);
        
        /* Data de nascimento nutricionista   
         do {            
             System.out.printf("Idade: ");
             nutri.setDataDeNascimento();
        } while (true); Armazenar data de nascimento*/ 
        
        // Sexo nutricionista
         do {
             System.out.printf("Sexo(M/F): ");
             nutri.setSexo(scanf.next().toUpperCase());
         } while(ValidaNome.isSexo(nutri.getSexo()) ==  false);
        
         // Endereço nutricionista
         /*do {    */        
             System.out.printf("Longradouro:");
             nutri.setLongradouro(scanf.next());
        //} while (true); Falta uma validacao para cep
        
        //do {            
            System.out.printf("Complemento:");
            nutri.setComplemento(scanf.next());
        //} while (true);
        
        //do {            
          System.out.printf("Número:"); 
          nutri.setNumero(scanf.nextInt());
        //} while (true);
        
        //do {            
          System.out.printf("Bairro:");  
          nutri.setBairro(scanf.next());
        //} while (true);
        
        //do {            
          System.out.printf("Cidade:");  
          nutri.setCidade(scanf.next());
        //} while (true);
        
        //do {            
          System.out.printf("CEP:");  
          nutri.setCep(scanf.next());
        //} while (true);
    }
}
