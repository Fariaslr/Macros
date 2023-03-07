    package Aplicacao;

import Registros.*;

public class Aplicacao {

    public static void main(String[] args) {
        
        // Intancia de Registro de dados
        RegistroNutricionista registroNutricionista = new RegistroNutricionista();
        RegistroPaciente registroPaciente = new RegistroPaciente();
        MontaPlano montaPlano = new MontaPlano();
        RealizaConsulta realizaConsulta = new RealizaConsulta();
        
        // Sequência em que os dados são inseridos
        registroNutricionista.registro();
        registroPaciente.registro();
        montaPlano.montandoPlano();
        realizaConsulta.fazendoConsulta();
        
        
    }
}
