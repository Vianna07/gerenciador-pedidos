package br.com.gerenciador.pedidos.demo.controllers;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gerenciador.pedidos.demo.models.Usuario;
import br.com.gerenciador.pedidos.demo.repositories.UsuarioRepository;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;
	private final String LIST = "usuario/list";
	private final String LIST_URL = "/usuario/list";
	private final String FORM = "usuario/form";
	
	public void listModel(Model model) {
		model.addAttribute("usuarios", repository.findAll());
	}
	
	public void formModel(Model model, Usuario usuario) {
		if (Objects.isNull(usuario)) {
			model.addAttribute("usuario", new Usuario());
			return;
		}
		
		model.addAttribute("usuario", usuario);
	}
	
	@GetMapping
	public String entrypoint() {
		return "redirect:" + this.LIST_URL;
	}

	@GetMapping("/list")
	public String list(Model model) {
		this.listModel(model);
		return this.LIST;
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		this.formModel(model, null);
		return this.FORM;
	}
	
	@PostMapping("/save")
	public String save(Usuario usuario) {
		repository.save(usuario);
		return "redirect:" + this.LIST_URL;
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Optional<Usuario> usuarioOpt = repository.findById(id);
		
		if (usuarioOpt.isPresent()) {
			this.formModel(model, usuarioOpt.get());
			return this.FORM;
		}
		
		return "redirect:" + this.LIST_URL;
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		repository.deleteById(id);		
		return "redirect:" + this.LIST_URL;
	}
}
