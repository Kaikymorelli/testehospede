package Produtos_Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Produtos_Entitiy.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {

}
