package model.pessoa;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import model.enums.Sexo;

public abstract class Pessoa {

    private Long id;
    private String cpf;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private Sexo sexo;
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int calcularIdade() {
        LocalDate birth = LocalDate.now();
        LocalDate nascimento = Instant.ofEpochMilli(dataNascimento.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        Period periodo = Period.between(nascimento, birth);
        return periodo.getYears();
    }
}
