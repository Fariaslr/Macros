package Pessoa;

public class Paciente extends Pessoa{
    
    private int telefone;
    private String email;

    public Paciente(int codigoEndereco) {
        super(codigoEndereco);
    } 

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public int getCodigoEndereco() {
        return codigoEndereco;
    }

    @Override
    public void setCodigoEndereco(int codigoEndereco) {
        this.codigoEndereco = codigoEndereco;
    }
    
}
