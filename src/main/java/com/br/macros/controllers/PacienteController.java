package com.br.macros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.br.macros.models.Paciente;
import com.br.macros.repositories.PacienteRepository;

@Controller
public class PacienteController {

	@Autowired
	PacienteRepository pacienteRepository;

	public List<Paciente> allPacientes() {
		return pacienteRepository.findAll();
	}
}
