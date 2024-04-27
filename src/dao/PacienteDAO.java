package dao;

import model.pessoa.Paciente;
import java.util.List;

public interface PacienteDAO {
    
    public int inserir(Paciente paciente);
    public int editar(Paciente paciente);
    public int apagar(String cpf);
    public List<Paciente> listar();
    public Paciente encontrar(String cpf);
    
}
