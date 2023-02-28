package PacoteTemporario;

public class Refeicao {
    private int codigoTipoRefeicao;
    private int codigoConsulta;

    public Refeicao(int codigoTipoRefeicao, int codigoConsulta) {
        this.codigoTipoRefeicao = codigoTipoRefeicao;
        this.codigoConsulta = codigoConsulta;
    }
    
    public int getCodigoTipoRefeicao() {
        return codigoTipoRefeicao;
    }

    public void setCodigoTipoRefeicao(int codigoTipoRefeicao) {
        this.codigoTipoRefeicao = codigoTipoRefeicao;
    }

    public int getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(int codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }
    
    
}
