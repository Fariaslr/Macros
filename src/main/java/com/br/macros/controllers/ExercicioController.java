package com.br.macros.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.macros.models.Exercicio;
import com.br.macros.records.ExercicioRecordDto;
import com.br.macros.repositories.ExercicioRepository;

import jakarta.validation.Valid;

@RestController
public class ExercicioController {

	@Autowired
	ExercicioRepository exercicioRepository;

	@PostMapping("/exercicios")
    public ResponseEntity<Exercicio> saveExercicio(@RequestBody @Valid ExercicioRecordDto exercicioRecordDto) {
        Exercicio exercicio = new Exercicio();
        BeanUtils.copyProperties(exercicioRecordDto, exercicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(exercicioRepository.save(exercicio));
    }

    @GetMapping("/exercicios")
    public ResponseEntity<List<Exercicio>> getAllExercicios() {
        List<Exercicio> exerciciosList = exercicioRepository.findAll();

        if (!exerciciosList.isEmpty()) {
            for (Exercicio exercicio : exerciciosList) {
                UUID id = exercicio.getId();
                exercicio.add(linkTo(methodOn(ExercicioController.class).getOneExercicio(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(exerciciosList);
    }

    @GetMapping("exercicios/{id}")
    public ResponseEntity<Object> getOneExercicio(@PathVariable(value = "id") UUID id) {
        Optional<Exercicio> exercicio0 = exercicioRepository.findById(id);
        if (exercicio0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exercicio not found");
        }
        exercicio0.get().add(linkTo(methodOn(ExercicioController.class).getAllExercicios()).withRel("Todos Exercicios"));
        return ResponseEntity.status(HttpStatus.OK).body(exercicio0.get());
    }

    @PutMapping("exercicios/{id}")
    public ResponseEntity<Object> updateExercicio(@PathVariable(value = "id") UUID id, @RequestBody @Valid ExercicioRecordDto exercicioRecordDto) {
        Optional<Exercicio> exercicio0 = exercicioRepository.findById(id);

        if (exercicio0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exercicio not found");
        }
        Exercicio exercicio = exercicio0.get();
        BeanUtils.copyProperties(exercicioRecordDto, exercicio);
        return ResponseEntity.status(HttpStatus.OK).body(exercicioRepository.save(exercicio));
    }

    @DeleteMapping("exercicios/{id}")
    public ResponseEntity<Object> deleteExercicio(@PathVariable(value = "id") UUID id) {
        Optional<Exercicio> exercicio0 = exercicioRepository.findById(id);
        if (exercicio0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exercicio not found");
        }
        exercicioRepository.delete(exercicio0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Exercicio deleted successfully");
    }

}
