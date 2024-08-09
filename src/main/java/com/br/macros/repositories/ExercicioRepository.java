package com.br.macros.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.macros.models.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, UUID>{

}
