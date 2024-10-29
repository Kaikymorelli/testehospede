package com.teste.hospede.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Hospedetest {

	private Hospede hospede;
	
	@BeforeEach
	void setUp() {
		hospede = new Hospede (1L, "Kaiky morelli", "morelli@gmail.com", "(15)3736223652");
	}
	@Test
	@DisplayName ("Testando o id")
	void testId() {
		hospede.setId(2L);
		//Assert
		Assertions.assertEquals(2L,hospede.getId());
	}

	@Test
	@DisplayName ("Testando o nome")
	void testNome() {
		hospede.setNome("Kaiky morelli");
		//Assert
		Assertions.assertEquals("Kaiky morelli",hospede.getNome());
	}
	
	@Test
	@DisplayName ("Testando o email")
	void testEmail() {
		hospede.setEmail("morelli@gmail.com");
		//Assert
		Assertions.assertEquals("morelli@gmail.com",hospede.getEmail());
	}
	
	@Test
	@DisplayName ("Testando o telefone")
	void testTelefone() {
		hospede.setTelefone("(15)3736223652");
		//Assert
		Assertions.assertEquals("(15)3736223652",hospede.getTelefone());
	}
	
	@Test
	@DisplayName ("Testando o construtor")
	void testConstrutorAll () {
		Hospede novoHospede = new Hospede (3L, "Gustavo morelli", "gustavo@gmail.com", "(15)3736226203");
		Assertions.assertAll("novoHospede",
				()-> Assertions.assertEquals(3L, novoHospede.getId()),
				()-> Assertions.assertEquals("Gustavo morelli", novoHospede.getNome()),
				()-> Assertions.assertEquals("gustavo@gmail.com", novoHospede.getEmail()),
				()-> Assertions.assertEquals( "(15)3736226203", novoHospede.getTelefone()));
				
				
		
		
	}
	
	
	

}
