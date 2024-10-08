package br.com.gerenciador.pedidos.demo.models;

import java.time.LocalDate;

import br.com.gerenciador.pedidos.demo.enums.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn
	private Produto produto;
	private int quantidade;
	private LocalDate data;
	private float valor;
	@Enumerated(EnumType.STRING)
	private StatusPedido statusPedido;
	
	public Pedido(Produto produto, int quantidade, LocalDate data, StatusPedido statusPedido) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.data = data;
		this.valor = produto.getPreco() * quantidade;
		this.statusPedido = statusPedido;
	}
}
