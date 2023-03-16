package dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Pessoa.*;

public class NutricionistaDAOJDBC implements nutricionistaDAO {
    
    Connection conexao = null;
    PreparedStatement sql = null;
    ResultSet rset = null;

   // @Override
    public int inserir(Nutricionista nutri) {
        
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("INSERT INTO nutricionista(cpfNutricionista,registroNutricionista,nomeNutricionista,sobrenomeNutricionista,dataNascimento,sexo) ")
                .append("VALUES (?, ?, ?, ?, ?, ?)");
        
        String insert = sqlBuilder.toString();
        int linha = 0;
        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(insert);
            sql.setString(1, nutri.getCpf());
            sql.setInt(2, nutri.getRegistroNutricionista());
            sql.setString(3,nutri.getNome() );
            sql.setString(4, nutri.getSobrenome());
            sql.setDate(5, (Date) nutri.getDataDeNascimento());
            sql.setString(6,nutri.getSexo());
            
            
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
            sql.setString(3,nutri.getNome() );
            sql.setString(4, nutri.getSobrenome());
            sql.setDate(5, (Date) nutri.getDataDeNascimento());
            sql.setString(6,nutri.getSexo());
            
            linha = sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return linha;
    }


    public int apagar(String cpf) {
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return linha;
    }

    public List<Nutricionista> listar() {
        
        String select = "SELECT * FROM nutricionista";

        List<Nutricionista> nutricionista = new ArrayList<Nutricionista>();

        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(select);

            rset = sql.executeQuery();

            while (rset.next()) {

                Nutricionista nutri = new Nutricionista();

                sql.setString(1, nutri.getCpf());
                sql.setInt(2, nutri.getRegistroNutricionista());
                sql.setString(3,nutri.getNome() );
                sql.setString(4, nutri.getSobrenome());
                sql.setDate(5, (Date) nutri.getDataDeNascimento());
                sql.setString(6,nutri.getSexo());

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
                sql.setString(3,nutri.getNome() );
                sql.setString(4, nutri.getSobrenome());
                sql.setDate(5, (Date) nutri.getDataDeNascimento());
                sql.setString(6,nutri.getSexo());

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
