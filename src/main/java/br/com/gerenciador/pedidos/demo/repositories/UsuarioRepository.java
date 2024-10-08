package br.com.gerenciador.pedidos.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gerenciador.pedidos.demo.models.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
