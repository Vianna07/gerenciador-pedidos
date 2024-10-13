package br.com.gerenciador.pedidos.demo.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	public CommandLineRunner populateDatabase() {
		return args -> {
			List<Produto> produtos = new ArrayList<>(
                    Arrays.asList(
                            new Produto(1, "Arroz", 50, 10.5f),
                            new Produto(2, "Feijão", 100, 5.2f),
                            new Produto(3, "Celular", 150, 1999.99f),
                            new Produto(4, "Teclado", 200, 199.99f),
                            new Produto(5, "Monitor", 250, 1399.99f)
                    )
            );
			
			List<Usuario> usuarios = new ArrayList<>(
                    Arrays.asList(
                            new Usuario(1, "Fernando", "fernando@empresa.com", "+55 (99) 9999-9999", TipoUsuario.FUNCIONARIO),
                            new Usuario(2, "Luckas", "luckaspipipipi@desempregado.com", "+55 (99) 9999-9998", TipoUsuario.ALUNO),
                            new Usuario(3, "Vianna", "viannagustavo@gmail.com", "+55 (99) 9999-9997", TipoUsuario.ADMIN),
                            new Usuario(4, "Maycon", "maycon2010@gmail.com", "+55 (99) 9999-9996", TipoUsuario.GERENTE),
                            new Usuario(5, "Joaquim", "joaquim.curitiba@gmail.com", "+55 (99) 9999-9995", TipoUsuario.ALUNO)
                    )
            );
			
			List<Pedido> pedidos = new ArrayList<>(
                    List.of(
//                            new Pedido(4, produtos.getFirst(), 1, LocalDate.now(), StatusPedido.ABERTO)
                    )
            );
			
			
			produtoRepository.saveAll(produtos);
			usuarioRepository.saveAll(usuarios);
			pedidoRepository.saveAll(pedidos);
		};
	}
}
