package br.com.gerenciador.pedidos.demo.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import br.com.gerenciador.pedidos.demo.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@ManyToMany
//	@JoinTable(
//			name = "pedido_produto",
//			joinColumns = @JoinColumn(name = "pedido_id"),
//			inverseJoinColumns = @JoinColumn(name = "produto_id")
//	)
//	private Set<Produto> produtos = new HashSet<Produto>();
	@OneToOne
	@JoinColumn
	private Produto produto;
	private int quantidade;
	private LocalDate data;
	private float valor;
	@Enumerated(EnumType.STRING)
	private StatusPedido statusPedido;
	
	public Pedido(int id, Produto produto, int quantidade, LocalDate data, StatusPedido statusPedido) {
		this.id = id;
//		this.produtos.add(produto);
		this.produto = produto;
		this.quantidade = quantidade;
		this.data = data;
		this.valor = produto.getPreco() * quantidade;
		this.statusPedido = statusPedido;
	}
}
