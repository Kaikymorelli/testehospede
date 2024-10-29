package com.teste.produtos.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import Produtos_Entitiy.Cliente;
import Produtos_Repository.ClienteRepository;

class Clientetest {

	@DataJpaTest
	class ClienteRepositoryTest {

		@Autowired
		private ClienteRepository clienteRepository;


		@DisplayName("Testando o save")
		@Test
		void test() {

			Cliente cliente1 = new Cliente(null, "Neymar",
					"(15)997856473",
					"11111111111",
					"22222222222-2");

			Cliente saveCliente = clienteRepository.save(cliente1);

			Assertions.assertNotNull(saveCliente);
			Assertions.assertTrue(saveCliente.getId() > 0);
		}

		@DisplayName("Testando get para todos os Hospedes")
		@Test
		void testGetAllRepsitory() {
			Cliente cliente1 = new Cliente (null, "Neymar",
					"(15)997856473",
					"11111111111",
					"22222222222-2");
			Cliente cliente2 = new Cliente (null, "Dybala",
					"(67)992346531",
					"12121212121",
					"33333333333-3");
			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);

			List<Cliente> clienteList = clienteRepository.findAll();

			Assertions.assertNotNull(clienteList);
			Assertions.assertEquals(2, clienteList.size());
		}
		@DisplayName("Testando Get By ID")
		@Test
		void testGetById() {
			Cliente cliente1 = new Cliente (null, "Neymar",
					"(15)997856473",
					"11111111111",
					"22222222222-2");
			clienteRepository.save(cliente1);

			Cliente saveCliente = clienteRepository.findById(cliente1.getId()).get();

			Assertions.assertNotNull(saveCliente);
			Assertions.assertEquals(cliente1.getId(), saveCliente.getId());
		}
		@DisplayName("Testando o Update")
		@Test
		void testUpdateCliente() {
			Cliente cliente1 = new Cliente (null, "Neymar",
					"(15)997856473",
					"11111111111",
					"22222222222-2");
			clienteRepository.save(cliente1);

			Cliente saveCliente = clienteRepository.findById(cliente1.getId()).get();
			cliente1.setNome("Neymar");
			cliente1.setTelefone("(15)997856473");
			cliente1.setCpf("11111111111");
			cliente1.setRg("22222222222-2");

			Cliente updateCliente = clienteRepository.save(saveCliente);

			Assertions.assertNotNull(updateCliente);
			Assertions.assertEquals("Neymar", updateCliente.getNome());
			Assertions.assertEquals("(15)997856473", updateCliente.getTelefone());
			Assertions.assertEquals("11111111111", updateCliente.getCpf());
			Assertions.assertEquals("22222222222-2", updateCliente.getRg());
		}
		@DisplayName("Testando o Delete")
		@Test
		void testDeleteCliente() {
			Cliente cliente1 = new Cliente (null, "Neymar",
					"(15)997856473",
					"11111111111",
					"22222222222-2");
			clienteRepository.save(cliente1);

			clienteRepository.deleteById(cliente1.getId());
			Optional <Cliente> clienteOptional = clienteRepository.findById(cliente1.getId());

			Assertions.assertTrue(clienteOptional.isEmpty());
		}

	}}
