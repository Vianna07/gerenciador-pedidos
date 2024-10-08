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

import br.com.gerenciador.pedidos.demo.models.Pedido;
import br.com.gerenciador.pedidos.demo.repositories.PedidoRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	private PedidoRepository repository;
	private final String LIST = "pedido/list";
	private final String LIST_URL = "/pedido/list";
	private final String FORM = "pedido/form";
	
	public void listModel(Model model) {
		model.addAttribute("pedidos", repository.findAll());
	}
	
	public void formModel(Model model, Pedido pedido) {
		if (Objects.isNull(pedido)) {
			model.addAttribute("pedido", new Pedido());
			return;
		}
		
		model.addAttribute("pedido", pedido);
	}
	
	@GetMapping
	public String entrypoint() {
		return "redirect:" + this.LIST_URL;
	}

	@GetMapping("/list")
	public String list(Model model) {
		this.list(model);
		return this.LIST;
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		this.formModel(model, null);
		return this.FORM;
	}
	
	@PostMapping("/save")
	public String save(Pedido pedido) {
		repository.save(pedido);
		return "redirect:" + this.LIST_URL;
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Optional<Pedido> pedidoOpt = repository.findById(id);
		
		if (pedidoOpt.isPresent()) {
			this.formModel(model, pedidoOpt.get());
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
