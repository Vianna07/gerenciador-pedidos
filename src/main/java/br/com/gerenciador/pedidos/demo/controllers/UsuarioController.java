package br.com.gerenciador.pedidos.demo.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gerenciador.pedidos.demo.models.Usuario;
import br.com.gerenciador.pedidos.demo.repositories.UsuarioRepository;



@Controller
@RequestMapping("/usuario")
public class UsuarioController extends BaseController<Usuario, UsuarioRepository> {
	public UsuarioController() {
		super("usuario");
	}

	@Override
	public void listModel(Model model) {
		model.addAttribute("usuarios", repository.findAll());
	}

	@Override
	public void formModel(Model model, Usuario usuario) {
		if (Objects.isNull(usuario)) {
			model.addAttribute("usuario", new Usuario());
			return;
		}

		model.addAttribute("usuario", usuario);
	}

}
