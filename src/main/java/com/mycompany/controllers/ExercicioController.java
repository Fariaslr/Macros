package com.mycompany.controllers;

import com.mycompany.models.Exercicio;
import com.mycompany.repositories.ExercicioRepository;
import java.util.List;

public class ExercicioController {

    ExercicioRepository exercicioRepository;

    List<Exercicio> all() {
        return exercicioRepository.findAll();
    }
}
