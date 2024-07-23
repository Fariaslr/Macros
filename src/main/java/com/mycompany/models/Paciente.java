package com.mycompany.models;

import java.util.Date;
import com.mycompany.enums.Sexo;
import javax.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente extends Pessoa {

    private static final long serialVersionUID = 1L;

    public Paciente() {
        super();
    }

    public Paciente(Date dataNascimento, String nome, String sobrenome, Sexo sexo) {
        super(dataNascimento, nome, sobrenome, sexo);
    }

}
