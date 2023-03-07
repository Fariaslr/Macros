package Registros;

import Pessoa.Paciente;
import Validacoes.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroPaciente extends RegistroNutricionista {

    @Override
    public void registro() {

        // Instancia objeto
        Paciente paciente = new Paciente();

        // Instacia de leitura
        Scanner scanf = new Scanner(System.in);

        // Gerador de números aleatórios 
        Random geradorNumeros = new Random();

        // Instância de valicações
        ValidaString validaNome = new ValidaString();
        ValidaCpf validaCpf = new ValidaCpf();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("\n---------------CADASTRO PACIENTE---------------");
        do {
            System.out.printf("CPF : ");
            paciente.setCpf(scanf.nextLine());
        } while (ValidaCpf.isCPF(paciente.getCpf()) == false);

        do {
            System.out.printf("Nome: ");
            paciente.setNome(scanf.nextLine());
        } while (ValidaString.isName(paciente.getNome()) == false);

        do {
            System.out.printf("Sobrenome: ");
            paciente.setSobrenome(scanf.nextLine());
        } while (validaNome.isLastName(paciente.getSobrenome()) == false);

        /*do {
            System.out.printf("Telefone: ");
            paciente.setTelefone(scanf.next());
        } while (true);

        do {
            System.out.printf("Email: ");
            paciente.setEmail(scanf.next());
        } while (false);

         */
        //do {            
        try {
            System.out.printf("Data de nascimento(dd/mm/aaaa): ");
            paciente.setDataDeNascimento(data.parse(scanf.next()));
            System.out.println(paciente.getDataDeNascimento());
        } catch (ParseException ex) {
            System.out.println("Data inválida!");
        }
        //} while (true);

        do {
            System.out.printf("Sexo(M/F): ");
            paciente.setSexo(scanf.next().toUpperCase());
        } while (ValidaString.isSexo(paciente.getSexo()) == false);

        /*do {           
             System.out.printf("Longradouro:");
             paciente.setLongradouro(scanf.next());
        } while (true); 
        
        do {            
            System.out.printf("Complemento:");
            paciente.setComplemento(scanf.next());
        } while (true);
        
        do {            
          System.out.printf("Número:"); 
          paciente.setNumero(scanf.nextInt());
        } while (true);
        
        do {            
          System.out.printf("Bairro:");  
          paciente.setBairro(scanf.next());
        } while (true);
        
        do {            
          System.out.printf("Cidade:");  
          paciente.setCidade(scanf.next());
        } while (true);
        
        do {            
          System.out.printf("CEP:");  
          paciente.setCep(scanf.next());
        } while (true);*/
        
        // Insere o código de endereço
        paciente.setCodigoEndereco(geradorNumeros.nextInt(9999));

        System.out.println("---------------CADASTRO PACIENTE FINALIZADO---------------\n");
    }
}
