package Produtos_Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Produtos_Entitiy.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {

}
