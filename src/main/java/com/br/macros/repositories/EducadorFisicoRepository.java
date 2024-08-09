package com.br.macros.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.macros.models.EducadorFisico;

@Repository
public interface EducadorFisicoRepository extends JpaRepository<EducadorFisico, UUID> {

}
