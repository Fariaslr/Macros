package Triagem;

import Pessoa.Nutricionista;
import Pessoa.Paciente;
import java.util.*;

public class Plano {

    private int codigoPlano;
    private Paciente paciente;
    private Date dataPlano;
    private int objetivo;
    private Nutricionista nutricionista;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getCodigoPlano() {
        return codigoPlano;
    }

    public void setCodigoPlano(int codigoPlano) {
        this.codigoPlano = codigoPlano;
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

    public Nutricionista getNutricionista() {
        return nutricionista;
    }

    public void setNutricionista(Nutricionista nutricionista) {
        this.nutricionista = nutricionista;
    }

}
