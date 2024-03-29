package jdbc;

import Pessoa.Paciente;
import conexao.ConexaoMySQL;
import dao.PacienteDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacienteJDBC implements PacienteDAO {

    Connection conexao = null;
    PreparedStatement sql = null;
    ResultSet rset = null;

    @Override
    public int inserir(Paciente paciente) {

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("INSERT INTO endereco(codigoEndereco,logradouro,complemento,numero,bairro,cidade,estado,cep) ")
                .append("VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                

        String insert = sqlBuilder.toString();
        int linha = 0;
        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(insert);
            sql.setInt(1, paciente.getEndereco().getCodigoEndereco());
            sql.setString(2, paciente.getEndereco().getLongradouro());
            sql.setString(3, paciente.getEndereco().getComplemento());
            sql.setInt(4, paciente.getEndereco().getNumero());
            sql.setString(5, paciente.getEndereco().getBairro());
            sql.setString(6, paciente.getEndereco().getCidade());
            sql.setString(7, paciente.getEndereco().getEstado());
            sql.setString(8, paciente.getEndereco().getCep());
                      
            sqlBuilder
                .append("INSERT INTO paciente(cpf,nomePaciente,sobrenomePaciente,telefone,email,dataNascimento,sexo) ")
                .append("VALUES (?, ?, ?, ?, ?, ?, ?)");

            sql = (PreparedStatement) conexao.prepareStatement(insert);
            sql.setString(1, paciente.getCpf());
            sql.setString(2, paciente.getNome());
            sql.setString(3, paciente.getSobrenome());
            sql.setString(4, paciente.getTelefone());
            sql.setString(5, paciente.getEmail());
            sql.setDate(6, (new Date (paciente.getDataDeNascimento().getTime())));
            sql.setString(7, paciente.getSexo());
            
            linha = sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    
        return linha;
    }

    @Override
    public int editar(Paciente paciente) {

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE paciente SET ")
                .append("WHERE cpf = ?");

        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            conexao = ConexaoMySQL.getConexao();

            sql.setString(1, paciente.getCpf());
            sql.setString(2, paciente.getNome());
            sql.setString(3, paciente.getSobrenome());
            sql.setString(4, paciente.getTelefone());
            sql.setString(5, paciente.getEmail());
            sql.setDate(6, (Date) paciente.getDataDeNascimento());
            sql.setString(7, paciente.getSexo());
            linha = sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return linha;
    }

    @Override
    public int apagar(String cpf) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("DELETE FROM paciente ")
                .append("WHERE cpf = ?");

        String delete = sqlBuilder.toString();
        int linha = 0;
        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(delete);
            sql.setString(1, cpf);
            linha = sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return linha;
    }

    @Override
    public List<Paciente> listar() {

        String select = "SELECT * FROM paciente";

        List<Paciente> pacientes = new ArrayList<Paciente>();

        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(select);

            rset = sql.executeQuery();

            while (rset.next()) {

                Paciente paciente = new Paciente();

                sql.setString(1, paciente.getCpf());
                sql.setString(2, paciente.getNome());
                sql.setString(3, paciente.getSobrenome());
                sql.setString(4, paciente.getTelefone());
                sql.setString(5, paciente.getEmail());
                sql.setDate(6, (Date) paciente.getDataDeNascimento());
                sql.setString(7, paciente.getSexo());
                
                pacientes.add(paciente);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return pacientes;
    }

    @Override
    public Paciente encontrar(String cpf) {

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("SELECT * FROM paciente ")
                .append("WHERE cpf = ?");

        String select = sqlBuilder.toString();

        Paciente paciente = null;

        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(select);

            sql.setString(1, cpf);

            rset = sql.executeQuery();

            while (rset.next()) {

                paciente = new Paciente();

                sql.setString(1, paciente.getCpf());
                sql.setString(2, paciente.getNome());
                sql.setString(3, paciente.getSobrenome());
                sql.setString(4, paciente.getTelefone());
                sql.setString(5, paciente.getEmail());
                sql.setDate(6, (Date) paciente.getDataDeNascimento());
                sql.setString(7, paciente.getSexo());

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return paciente;
    }

    private void fecharConexao() {
        try {
            if (rset != null) {
                rset.close();
            }
            if (sql != null) {
                sql.close();
            }

            if (conexao != null) {
                conexao.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
