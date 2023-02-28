package PacoteTemporario;

public class ItensRefeicao {
    
    private int codigoTipoRefeicao;
    private int codigoConsulta;
    private int codigoAlimento;
    private int porcao;

    public ItensRefeicao(int codigoTipoRefeicao, int codigoConsulta, int codigoAlimento) {
        this.codigoTipoRefeicao = codigoTipoRefeicao;
        this.codigoConsulta = codigoConsulta;
        this.codigoAlimento = codigoAlimento;
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

    public int getCodigoAlimento() {
        return codigoAlimento;
    }

    public void setCodigoAlimento(int codigoAlimento) {
        this.codigoAlimento = codigoAlimento;
    }

    public int getPorcao() {
        return porcao;
    }

    public void setPorcao(int porcao) {
        this.porcao = porcao;
    }
    
    
}
