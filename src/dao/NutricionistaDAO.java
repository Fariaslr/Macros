package dao;

import model.pessoa.Nutricionista;
import java.util.List;

public interface NutricionistaDAO {
    
    public int inserir(Nutricionista nutri);
    public int editar(Nutricionista nutri);
    public int apagar(String cpf, int codigoEndereco);
    public List<Nutricionista> listar(int codigoEndereco);
    public Nutricionista encontrar(String cpf);
    
}
