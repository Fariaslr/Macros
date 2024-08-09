package com.br.macros.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.macros.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, UUID>{

}
