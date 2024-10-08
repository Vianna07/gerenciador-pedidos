package br.com.gerenciador.pedidos.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int estoque;
	private float preco;
	
	public Produto(String nome, int estoque, float preco) {
		this.nome = nome;
		this.estoque = estoque;
		this.preco = preco;
	}

}
