package Produtos_Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Produtos_Entitiy.Veiculo;

public interface VeiculoRepository extends JpaRepository <Veiculo, Long>  {

}
