package model.pessoa;

import java.util.List;
import model.triagem.Consulta;
import model.triagem.Plano;

public class Nutricionista extends Pessoa {

    private String crn;
    private List<Plano> planos;
    private List<Consulta> consultas;

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }    

    public List<Plano> getPlanos() {
        return planos;
    }

    public void setPlanos(List<Plano> planos) {
        this.planos = planos;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
    
}
