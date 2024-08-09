package com.br.macros;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.macros.repositories.ExercicioRepository;

@SpringBootTest
public class MacrosApplicationTests {

	@Autowired
	ExercicioRepository exercicioRepository;

	@Test
	public void contextLoads() {

	}

}
