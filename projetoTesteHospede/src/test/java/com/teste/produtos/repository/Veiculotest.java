package com.teste.produtos.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import Produtos_Entitiy.Veiculo;
import Produtos_Repository.VeiculoRepository;

class Veiculotest {

	@DataJpaTest
	class VeiculoRepositoryTest {

		@Autowired
		private VeiculoRepository veiculoRepository;


		@DisplayName("Testando o save")
		@Test
		void test() {

			Veiculo Veiculo1 = new Veiculo(null, "Mercedes","AMG G-63",2023,"Preto");

			Veiculo saveVeiculo = veiculoRepository.save(Veiculo1);

			assertNotNull(saveVeiculo);
		}

		@DisplayName("Testando get para todos os Veiculos")
		@Test
		void testGetAllRepsitory() {
			Veiculo Veiculo1 = new Veiculo (null, "Mercedes","AMG G-63",2023,"Preto");
			Veiculo Veiculo2 = new Veiculo (null, "BMW","320i",2024,"Branco");
			veiculoRepository.save(Veiculo1);
			veiculoRepository.save(Veiculo2);

			List<Veiculo> VeiculoList = veiculoRepository.findAll();

			assertNotNull(VeiculoList);
			assertEquals(2, VeiculoList.size());
		}
		
		@DisplayName("Testando o Update")
		@Test
		void testUpdateVeiculo() {
			Veiculo Veiculo1 = new Veiculo (null, "Mercedes","AMG G-63",2023,"Preto");
			veiculoRepository.save(Veiculo1);

			Veiculo saveVeiculo = veiculoRepository.findById(Veiculo1.getId()).get();
			Veiculo1.setMarca("Mercedes");
			Veiculo1.setModelo("AMG G-63");
			Veiculo1.setAno(2023);
			Veiculo1.setCor("Preto");

			Veiculo updateVeiculo = veiculoRepository.save(saveVeiculo);

			assertNotNull(updateVeiculo);
			assertEquals("Mercedes", updateVeiculo.getMarca());
			assertEquals("AMG G-63", updateVeiculo.getModelo());
			assertEquals(2023, updateVeiculo.getAno());
			assertEquals("Preto", updateVeiculo.getCor());
		}
		@DisplayName("Testando o Delete")
		@Test
		void testDeleteVeiculo() {
			Veiculo Veiculo1 = new Veiculo (null, "Mercedes","AMG G-63",2023,"Preto");
			veiculoRepository.save(Veiculo1);

			veiculoRepository.deleteById(Veiculo1.getId());
			Optional <Veiculo> VeiculoOptional = veiculoRepository.findById(Veiculo1.getId());

			assertTrue(VeiculoOptional.isEmpty());
		}
	}
}
