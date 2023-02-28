package PacoteTemporario;

import java.util.Date;

public class Plano {
    
    private int codigoPlano;
    private String cpfPaciente;
    private Date dataPlano;
    private int objetivo;
    private String cpfNutricionista;

    public Plano(String cpfPaciente, String cpfNutricionista) {
        this.cpfPaciente = cpfPaciente;
        this.cpfNutricionista = cpfNutricionista;
    }
    
    public int getCodigoPlano() {
        return codigoPlano;
    }

    public void setCodigoPlano(int codigoPlano) {
        this.codigoPlano = codigoPlano;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public Date getDataPlano() {
        return dataPlano;
    }

    public void setDataPlano(Date dataPlano) {
        this.dataPlano = dataPlano;
    }

    public int getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(int objetivo) {
        this.objetivo = objetivo;
    }

    public String getCpfNutricionista() {
        return cpfNutricionista;
    }

    public void setCpfNutricionista(String cpfNutricionista) {
        this.cpfNutricionista = cpfNutricionista;
    }
    
    
}
