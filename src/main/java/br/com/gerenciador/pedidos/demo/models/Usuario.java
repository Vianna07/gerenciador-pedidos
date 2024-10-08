package br.com.gerenciador.pedidos.demo.models;

import br.com.gerenciador.pedidos.demo.enums.TipoUsuario;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	private String telefone;
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;

	public Usuario(String nome, String email, String telefone, TipoUsuario tipoUsuario) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.tipoUsuario = tipoUsuario;
	}	
}
