package model.triagem;

import model.enums.Objetivo;
import model.pessoa.Nutricionista;
import model.pessoa.Paciente;
import java.util.*;

public class Plano {

    private int codigoPlano;
    private Paciente paciente;
    private Date dataPlano;
    private Objetivo objetivo;
    private Nutricionista nutricionista;

    public Plano() {
        
    }

    public Plano(int codigoPlano, Paciente paciente, Date dataPlano, Objetivo objetivo, Nutricionista nutricionista) {
        this.codigoPlano = codigoPlano;
        this.paciente = paciente;
        this.dataPlano = dataPlano;
        this.objetivo = objetivo;
        this.nutricionista = nutricionista;
    }

    
    public int getCodigoPlano() {
        return codigoPlano;
    }

    public void setCodigoPlano(int codigoPlano) {
        this.codigoPlano = codigoPlano;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getDataPlano() {
        return dataPlano;
    }

    public void setDataPlano(Date dataPlano) {
        this.dataPlano = dataPlano;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public Nutricionista getNutricionista() {
        return nutricionista;
    }

    public void setNutricionista(Nutricionista nutricionista) {
        this.nutricionista = nutricionista;
    }

    

}
