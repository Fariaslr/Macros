package Registros;

import Pessoa.*;
import Validacoes.*;
import java.util.*;

public class RegistroNutricionista {

    public void registro() {

        // Instância objeto
        Nutricionista nutri = new Nutricionista();

        // Instacia de leitura
        Scanner scanf = new Scanner(System.in);

        // Gerador de números aleatórios 
        Random geradorNumeros = new Random();

        // Instância de valicações
        ValidaString validaNome = new ValidaString();
        ValidaCpf validaCpf = new ValidaCpf();
        
        System.out.println("\tCADASTRO NUTRICIONISTA");
        do {
            System.out.printf("CPF: ");
            nutri.setCpf(scanf.nextLine());
        } while (ValidaCpf.isCPF(nutri.getCpf()) == false);

        System.out.printf("CRN: ");
        nutri.setRegistroNutricionista(geradorNumeros.nextInt(9999));
        System.out.println(nutri.getRegistroNutricionista());

        do {
            System.out.printf("Nome: ");
            nutri.setNome(scanf.nextLine());
        } while (ValidaString.isName(nutri.getNome()) == false);

        do {
            System.out.printf("Sobrenome: ");
            nutri.setSobrenome(scanf.nextLine());
        } while (validaNome.isLastName(nutri.getSobrenome()) == false);

        /* Data de nascimento nutricionista   
         do {            
             System.out.printf("Idade: ");
             nutri.setDataDeNascimento();
        } while (true); Armazenar data de nascimento*/
        do {
            System.out.printf("Sexo(M/F): ");
            nutri.setSexo(scanf.next().toUpperCase());
        } while (ValidaString.isSexo(nutri.getSexo()) == false);

        /* Endereço
         do {           
             System.out.printf("Longradouro:");
             nutri.setLongradouro(scanf.next());
        } while (true); Falta uma validacao para cep
        
        do {            
            System.out.printf("Complemento:");
            nutri.setComplemento(scanf.next());
        } while (true);
        
        do {            
          System.out.printf("Número:"); 
          nutri.setNumero(scanf.nextInt());
        } while (true);
        
        do {            
          System.out.printf("Bairro:");  
          nutri.setBairro(scanf.next());
        } while (true);
        
        do {            
          System.out.printf("Cidade:");  
          nutri.setCidade(scanf.next());
        } while (true);
        
        do {            
          System.out.printf("CEP:");  
          nutri.setCep(scanf.next());
        } while (true);*/
        
        nutri.setCodigoEndereco(9999);
        
        System.out.println("\tCADASTRO NUTRICIONISTA FINALIZADO");
    }
}
