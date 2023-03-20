package dao;

import java.util.List;
import Pessoa.*;

public interface NutricionistaDAO {
    
    public int inserir(Nutricionista nutri);
    public int editar(Nutricionista nutri);
    public int apagar(String cpf);
    public List<Nutricionista> listar();
    public Nutricionista encontrar(String cpf);
    
}
