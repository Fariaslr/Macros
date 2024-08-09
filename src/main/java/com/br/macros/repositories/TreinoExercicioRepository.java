package com.br.macros.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.macros.models.TreinoExercicio;

public interface TreinoExercicioRepository extends JpaRepository<TreinoExercicio, UUID>{

}
