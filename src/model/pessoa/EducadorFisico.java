package model.pessoa;

import java.util.List;
import model.triagem.Consulta;
import model.triagem.Plano;

public class EducadorFisico extends Pessoa{
    private String cref;
    private List<Plano> planos;
    private List<Consulta> consultas;

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
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
