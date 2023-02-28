package Pessoa;

public class Nutricionista extends Pessoa{
    
    private int registroNutricionista;

    public Nutricionista(int codigoEndereco) {
        super(codigoEndereco);
    }

    public int getRegistroNutricionista() {
        return registroNutricionista;
    }

    public void setRegistroNutricionista(int registroNutricionista) {
        this.registroNutricionista = registroNutricionista;
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
