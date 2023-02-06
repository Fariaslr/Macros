package Dados;

public class Atleta {
    
    private String cpf;
    private String nome;
    private int idade;
    private float altura;
    private float peso;
    private String sexo;    
    private float taxaMetabolicaBasal;
    
    public Atleta() {}
   
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getTaxaMetabolicaBasal() {
        return taxaMetabolicaBasal;
    }

    public void setTaxaMetabolicaBasal(float taxaMetabolicaBasal) {
        this.taxaMetabolicaBasal = taxaMetabolicaBasal;
    }
    public void calculaTaxaMetabolicaBasal() {
        if(getSexo().equals("M"))
            this.taxaMetabolicaBasal = (float) (66 + (13.7 * getPeso()) + (5 * getAltura()) - (6.8 * getIdade()));
        if(getSexo().equals("F"))
            this.taxaMetabolicaBasal = (float) (655 + (9.6 * getPeso()) + (1.8 * getAltura()) - (4.7 * getIdade()));
    }
}
