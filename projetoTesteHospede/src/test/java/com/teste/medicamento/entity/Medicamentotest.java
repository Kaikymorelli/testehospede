package com.teste.medicamento.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.teste.hospede.medicamento.Medicamento;

class Medicamentotest {

private Medicamento medicamento;
	
	@BeforeEach
	void setUp() {
		medicamento = new Medicamento (1L, "revotril", "nao beber sem agua", "2025/12");
	}
	@Test
	@DisplayName ("Testando o id")
	void testId() {
		medicamento.setId(2L);
		//Assert
		Assertions.assertEquals(2L,medicamento.getId());
	}

	@Test
	@DisplayName ("Testando o nome")
	void testNome() {
		medicamento.setNome("revotril");
		//Assert
		Assertions.assertEquals("revotril",medicamento.getNome());
	}
	
	@Test
	@DisplayName ("Testando a bula")
	void testBula() {
		medicamento.setBula("nao beber sem agua");
		//Assert
		Assertions.assertEquals("nao beber sem agua",medicamento.getBula());
	}
	
	@Test
	@DisplayName ("Testando a data de validade")
	void testdataValidade() {
		medicamento.setDataValidade("2025/12");
		//Assert
		Assertions.assertEquals("2025/12",medicamento.getDataValidade());
	}
	
	@Test
	@DisplayName ("Testando o contrutor medicamento")
	void testConstrutorAll () {
		Medicamento novoMedicamento = new Medicamento (3L, "dipirona", "nao correr", "2026/12");
		Assertions.assertAll("novoHospede",
				()-> Assertions.assertEquals(3L, novoMedicamento.getId()),
				()-> Assertions.assertEquals("dipirona", novoMedicamento.getNome()),
				()-> Assertions.assertEquals("nao correr", novoMedicamento.getBula()),
				()-> Assertions.assertEquals( "2026/12", novoMedicamento.getDataValidade()));
				
				
		
		
	}
	
	
	

}
