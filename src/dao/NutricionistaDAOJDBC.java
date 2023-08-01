package dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Pessoa.*;

public class NutricionistaDAOJDBC implements NutricionistaDAO {

    Connection conexao = null;
    PreparedStatement sql = null;
    ResultSet rset = null;

    // @Override
    public int inserir(Nutricionista nutri) {

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("INSERT INTO endereco(codigoEndereco,logradouro,complemento,numero,bairro,cidade,estado,cep) ")
                .append("VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                

        String insert = sqlBuilder.toString();
        int linha = 0;
        try {
            conexao = ConexaoMySQL.getConexao();
            
            sql = (PreparedStatement) conexao.prepareStatement(insert);
            
            sql.setInt(1, nutri.getEnd().getCodigoEndereco());
            sql.setString(2, nutri.getEnd().getLongradouro());
            sql.setString(3, nutri.getEnd().getComplemento());
            sql.setInt(4, nutri.getEnd().getNumero());
            sql.setString(5, nutri.getEnd().getBairro());
            sql.setString(6, nutri.getEnd().getCidade());
            sql.setString(7, nutri.getEnd().getEstado());
            sql.setString(8, nutri.getEnd().getCep());
            
            
            linha = sql.executeUpdate(); 
            
            sqlBuilder
                .append("INSERT INTO nutricionista(cpfNutricionista,registroNutricionista,nomeNutricionista,sobrenomeNutricionista,dataNascimento,sexo) ")
                .append("VALUES (?, ?, ?, ?, ?, ?)");
            
            ResultSet rset = sql.getGeneratedKeys();
            if(rset.next()){
                Endereco end = new Endereco();
                end.setCodigoEndereco(rset.getInt(1));
                nutri.setEnd(end);
            }
            
            sql = (PreparedStatement) conexao.prepareStatement(insert);
            
            sql.setString(1, nutri.getCpf());
            sql.setInt(2, nutri.getRegistroNutricionista());
            sql.setString(3, nutri.getNome());
            sql.setString(4, nutri.getSobrenome());
            sql.setDate(5, new Date (nutri.getDataDeNascimento().getTime()));
            sql.setString(6, nutri.getSexo());

            linha = sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return linha;
    }

    @Override
    public int editar(Nutricionista nutri) {

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE nutricionista SET ")
                .append("WHERE cpfNutricionista = ?,");

        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(update);
            sql.setString(1, nutri.getCpf());
            sql.setInt(2, nutri.getRegistroNutricionista());
            sql.setString(3, nutri.getNome());
            sql.setString(4, nutri.getSobrenome());
            sql.setDate(5, (Date) nutri.getDataDeNascimento());
            sql.setString(6, nutri.getSexo());
            
            sqlBuilder
                .append("UPDATE endereco SET")
                .append("WHERE codigoEndereco = ?,");
            
            sql = (PreparedStatement) conexao.prepareStatement(update);
            sql.setInt(1, nutri.getEnd().getCodigoEndereco());
            sql.setString(2, nutri.getEnd().getLongradouro());
            sql.setString(3, nutri.getEnd().getComplemento());
            sql.setInt(4, nutri.getEnd().getNumero());
            sql.setString(5, nutri.getEnd().getBairro());
            sql.setString(6, nutri.getEnd().getCidade());
            sql.setString(7, nutri.getEnd().getEstado());
            sql.setString(8, nutri.getEnd().getCep());

            linha = sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
             
        return linha;
    }

    public int apagar(String cpf, int codigoEndereco) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("DELETE FROM nutricionista ")
                .append("WHERE cpfNutricionista = ?");

        String delete = sqlBuilder.toString();
        int linha = 0;
        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(delete);
            sql.setString(1, cpf);
            linha = sql.executeUpdate();
            
            sqlBuilder
                .append("DELETE FROM endereco ")
                .append("WHERE codigoEndereceo = ?");
            
            sql = (PreparedStatement) conexao.prepareStatement(delete);
            sql.setInt(1, codigoEndereco);
            linha = sql.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        return linha;
    }

    public List<Nutricionista> listar(int codigoEndereco) {

        String select = "SELECT * FROM nutricionista";

        List<Nutricionista> nutricionista = new ArrayList<Nutricionista>();
        StringBuilder sqlBuilder = new StringBuilder();

        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(select);

            rset = sql.executeQuery();

            while (rset.next()) {

                Nutricionista nutri = new Nutricionista();

                sql.setString(1, nutri.getCpf());
                sql.setInt(2, nutri.getRegistroNutricionista());
                sql.setString(3, nutri.getNome());
                sql.setString(4, nutri.getSobrenome());
                sql.setDate(5, (Date) nutri.getDataDeNascimento());
                sql.setString(6, nutri.getSexo());
                sql.setInt(7, nutri.getEnd().getCodigoEndereco());

                select = "SELECT FROM endereco WHERE codigoEndereceo = ?";

                sql = (PreparedStatement) conexao.prepareStatement(select);
                
                sql.setInt(1, nutri.getEnd().getCodigoEndereco());
                sql.setString(2, nutri.getEnd().getLongradouro());
                sql.setString(3, nutri.getEnd().getComplemento());
                sql.setInt(4, nutri.getEnd().getNumero());
                sql.setString(5, nutri.getEnd().getBairro());
                sql.setString(6, nutri.getEnd().getCidade());
                sql.setString(7, nutri.getEnd().getEstado());
                sql.setString(8, nutri.getEnd().getCep());

                nutricionista.add(nutri);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return nutricionista;
    }

    public Nutricionista encontrar(String cpf) {

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("SELECT * FROM nutricionista ")
                .append("WHERE cpfNutricionista = ?");

        String select = sqlBuilder.toString();

        Nutricionista nutricionista = null;

        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(select);

            sql.setString(1, cpf);

            rset = sql.executeQuery();

            while (rset.next()) {

                Nutricionista nutri = new Nutricionista();

                sql.setString(1, nutri.getCpf());
                sql.setInt(2, nutri.getRegistroNutricionista());
                sql.setString(3, nutri.getNome());
                sql.setString(4, nutri.getSobrenome());
                sql.setDate(5, (Date) nutri.getDataDeNascimento());
                sql.setString(6, nutri.getSexo());
                
                select = "SELECT FROM endereco WHERE codigoEndereceo = ?";

                sql = (PreparedStatement) conexao.prepareStatement(select);
                
                sql.setInt(1, nutri.getEnd().getCodigoEndereco());
                sql.setString(2, nutri.getEnd().getLongradouro());
                sql.setString(3, nutri.getEnd().getComplemento());
                sql.setInt(4, nutri.getEnd().getNumero());
                sql.setString(5, nutri.getEnd().getBairro());
                sql.setString(6, nutri.getEnd().getCidade());
                sql.setString(7, nutri.getEnd().getEstado());
                sql.setString(8, nutri.getEnd().getCep());


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return nutricionista;
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
