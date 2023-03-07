    package Aplicacao;

import Registros.*;
import conexao.ConexaoMySQL;

public class Aplicacao {

    public static void main(String[] args) throws Exception {
        
        // Intancia de Registro de dados
        RegistroNutricionista registroNutricionista = new RegistroNutricionista();
        RegistroPaciente registroPaciente = new RegistroPaciente();
        MontaPlano montaPlano = new MontaPlano();
        RealizaConsulta realizaConsulta = new RealizaConsulta();
        
          if (ConexaoMySQL.getConexao() != null) {
            System.out.println("Banco Conectado");
        } else
            System.out.println("Banco Não Conectado");
          
        // Sequência em que os dados são inseridos
        registroNutricionista.registro();
        registroPaciente.registro();
        montaPlano.montandoPlano();
        realizaConsulta.fazendoConsulta();
        
        
    }
}
