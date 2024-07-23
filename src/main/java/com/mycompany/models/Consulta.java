package com.mycompany.models;

import java.util.*;
import com.mycompany.enums.Objetivo;
import static com.mycompany.enums.Sexo.*;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "consultas")
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false)
    private Plano plano;

    @OneToOne(mappedBy = "consulta")
    private Treino treino;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataConsulta;

    @ManyToOne
    @JoinColumn(name = "profissional_saude_id", nullable = false)
    private ProfissionalSaude profissionalSaude;

    private float peso;
    private float altura;
    
    @Column(name = "numero_refeicoes")
    private int numeroRefeicoes;
    
    @Column(name = "medida_pescoco")
    private float medidaPescoco;
    
    @Column(name = "medida_cintura")
    private float medidaCintura;
    
    @Column(name = "medida_quadril")
    private float medidaQuadril;

    public Consulta() {
    }

    public Consulta(Plano plano, Date dataConsulta, float peso, float altura, ProfissionalSaude profissionalSaude) {
        this.plano = plano;
        this.dataConsulta = dataConsulta;
        this.profissionalSaude = profissionalSaude;
        this.peso = peso;
        this.altura = altura;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getNumeroRefeicoes() {
        return numeroRefeicoes;
    }

    public void setNumeroRefeicoes(int numeroRefeicoes) {
        this.numeroRefeicoes = numeroRefeicoes;
    }

    public float getMedidaPescoco() {
        return medidaPescoco;
    }

    public void setMedidaPescoco(float medidaPescoco) {
        this.medidaPescoco = medidaPescoco;
    }

    public float getMedidaCintura() {
        return medidaCintura;
    }

    public void setMedidaCintura(float medidaCintura) {
        this.medidaCintura = medidaCintura;
    }

    public float getMedidaQuadril() {
        return medidaQuadril;
    }

    public void setMedidaQuadril(float medidaQuadril) {
        this.medidaQuadril = medidaQuadril;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public ProfissionalSaude getProfissionalSaude() {
        return profissionalSaude;
    }

    public void setProfissionalSaude(ProfissionalSaude profissionalSaude) {
        this.profissionalSaude = profissionalSaude;
    }

    private float calcularTaxaMetabolicaBasal() {
        return (float) (switch (plano.getPaciente().getSexo()) {
            case MASCULINO ->
                66.5 + (13.75 * getPeso()) + (5.003 * getAltura()) - (6.75 * plano.getPaciente().calcularIdade());
            case FEMININO ->
                655.1 + (9.563 * getPeso()) + (1.85 * getAltura()) - (4.676 * plano.getPaciente().calcularIdade());
            default ->
                0;
        });
    }

    private float calcularGastoEnergeticoTotal() {
        return calcularTaxaMetabolicaBasal() * plano.getNivelAtividadeFisica().getFATOR();
    }

    public float calcularCaloriasDieta() {
        if (plano.getObjetivo().equals(Objetivo.EMAGRECIMENTO)) {
            return calcularCaloriasEmagrecimento();
        } else {
            return calcularCaloriasHipertrofia();
        }
    }

    private float calcularCaloriasEmagrecimento() {
        return calcularGastoEnergeticoTotal() * 0.865f;
    }

    private float calcularCaloriasHipertrofia() {
        return calcularGastoEnergeticoTotal() * 1.223f;
    }

    public double calcularPercentualGordura() {
        return (switch (plano.getPaciente().getSexo()) {
            case MASCULINO ->
                (495 / (1.033 - 0.191 * Math.log10(this.medidaCintura - this.medidaPescoco) + 0.155 * Math.log10(this.altura))) - 450;
            case FEMININO ->
                (495 / (1.296 - 0.350 * Math.log10(this.medidaQuadril + this.medidaCintura - this.medidaPescoco) + 0.221 * Math.log10(this.altura))) - 450;
            default ->
                0;
        });
    }

}
