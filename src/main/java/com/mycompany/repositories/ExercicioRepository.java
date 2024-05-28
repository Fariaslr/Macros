package com.mycompany.repositories;

import com.mycompany.models.Exercicio;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository<Exercicio, UUID>{

}
