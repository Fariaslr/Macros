package Registros;

import Triagem.Plano;
import Pessoa.*;
import Validacoes.*;
import java.util.*;

public class MontaPlano {

    public void montandoPlano() {

        // Instância dos objetos
        Paciente paciente = new Paciente();
        Nutricionista nutricionista = new Nutricionista();
        Plano plano = new Plano(paciente.getCpf(), nutricionista.getCpf());

        // Instância de leitura
        Scanner scanf = new Scanner(System.in);

        // Instância de aletoriedade
        Random geradorNumeros = new Random();

        // Instância de validação
        ValidaEscolhas validaEscolhas = new ValidaEscolhas();
        
        plano.setCodigoPlano(geradorNumeros.nextInt(9999));
        plano.setDataPlano(new Date());
        
        do {
            System.out.printf("Qual é o seu objetivo?\n[1] Perda de gordura\n[2] Manutenção\n[3] Aumento do peso\n");
            plano.setObjetivo(scanf.nextInt());
        } while (validaEscolhas.isObjective(plano.getObjetivo()) == false);

    }

}
