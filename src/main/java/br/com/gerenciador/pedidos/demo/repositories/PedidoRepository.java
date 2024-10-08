package br.com.gerenciador.pedidos.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gerenciador.pedidos.demo.models.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
