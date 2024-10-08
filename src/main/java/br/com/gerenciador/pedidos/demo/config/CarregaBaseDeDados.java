package br.com.gerenciador.pedidos.demo.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.gerenciador.pedidos.demo.enums.StatusPedido;
import br.com.gerenciador.pedidos.demo.enums.TipoUsuario;
import br.com.gerenciador.pedidos.demo.models.Pedido;
import br.com.gerenciador.pedidos.demo.models.Produto;
import br.com.gerenciador.pedidos.demo.models.Usuario;
import br.com.gerenciador.pedidos.demo.repositories.PedidoRepository;
import br.com.gerenciador.pedidos.demo.repositories.ProdutoRepository;
import br.com.gerenciador.pedidos.demo.repositories.UsuarioRepository;


@Configuration
public class CarregaBaseDeDados {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Bean
	public CommandLineRunner executar() {
		return args -> {
			List<Produto> produtos = new ArrayList<Produto>(
					Arrays.asList(
							new Produto("Arroz", 50, 10f),
							new Produto("Feijão", 100, 5f),
							new Produto("Celular", 150, 2000f),
							new Produto("Teclado", 200, 200f),
							new Produto("Monitor", 250, 1400f)
					)
			);
			
			List<Usuario> usuarios = new ArrayList<Usuario>(
					Arrays.asList(
							new Usuario("Fernando", "fernando@empresa.com", "+55 (99) 9999-9999", TipoUsuario.FUNCIONARIO),
							new Usuario("Luckas", "luckaspipipipi@desempregado.com", "+55 (99) 9999-9998", TipoUsuario.ALUNO),
							new Usuario("Vianna", "viannagustavo@gmail.com", "+55 (99) 9999-9997", TipoUsuario.ALUNO),
							new Usuario("Maycon", "maycon2010@gmail.com", "+55 (99) 9999-9996", TipoUsuario.ALUNO),
							new Usuario("Joaquim", "joaquim.curitiba@gmail.com", "55 (99) 9999-9995", TipoUsuario.ALUNO)
					)
			);
			
			List<Pedido> pedidos = new ArrayList<Pedido>(
					Arrays.asList(
							new Pedido(produtos.get(0), 1, LocalDate.now(), StatusPedido.ABERTO),
							new Pedido(produtos.get(1), 2, LocalDate.now().plusDays(1), StatusPedido.CANCELADO),
							new Pedido(produtos.get(2), 3, LocalDate.now().plusDays(2), StatusPedido.ENCERRADO),
							new Pedido(produtos.get(3), 4, LocalDate.now().plusDays(3), StatusPedido.ENCERRADO),
							new Pedido(produtos.get(4), 5, LocalDate.now().plusDays(4), StatusPedido.ABERTO)
					)
			);
			
			
			produtoRepository.saveAll(produtos);
			usuarioRepository.saveAll(usuarios);
			pedidoRepository.saveAll(pedidos);
		};
	}
}
