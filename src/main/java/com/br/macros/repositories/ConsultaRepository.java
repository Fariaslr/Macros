package com.br.macros.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.macros.models.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, UUID>{

}
