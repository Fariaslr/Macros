package com.br.macros.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.macros.models.Treino;

public interface TreinoRepository extends JpaRepository<Treino, UUID>{

}
