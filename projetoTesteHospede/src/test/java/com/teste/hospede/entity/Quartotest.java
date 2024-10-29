package com.teste.hospede.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Quartotest {

	private Quarto quarto;
	
	@BeforeEach
	void setUp() {
		quarto = new Quarto (1L, "1100", "Master");
	}
	@Test
	@DisplayName ("Testando o id")
	void testId() {
		quarto.setId(2L);
		//Assert
		Assertions.assertEquals(2L,quarto.getId());
	}

	@Test
	@DisplayName ("Testando o numero")
	void testNum() {
		quarto.setNum("1100");
		//Assert
		Assertions.assertEquals("1100",quarto.getNum());
	}
	
	@Test
	@DisplayName ("Testando o tipo")
	void testTipo() {
		quarto.setTipo("Master");
		//Assert
		Assertions.assertEquals("Master",quarto.getTipo());
	}
	

	@Test
	@DisplayName ("Testando o construtor")
	void testConstrutorAll () {
		Quarto novoQuarto = new Quarto (3L, "1200", "Basico");
		Assertions.assertAll("novoQuarto",
				()-> Assertions.assertEquals(3L, novoQuarto.getId()),
				()-> Assertions.assertEquals("1200", novoQuarto.getNum()),
				()-> Assertions.assertEquals("Basico", novoQuarto.getTipo()));
				
				
				
		
		
	}
}
