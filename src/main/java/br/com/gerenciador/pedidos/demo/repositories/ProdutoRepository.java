package br.com.gerenciador.pedidos.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gerenciador.pedidos.demo.models.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
