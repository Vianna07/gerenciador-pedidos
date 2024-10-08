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

import br.com.gerenciador.pedidos.demo.models.Produto;
import br.com.gerenciador.pedidos.demo.repositories.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repository;
	private final String LIST = "produto/list";
	private final String LIST_URL = "/produto/list";
	private final String FORM = "produto/form";
	
	public void listModel(Model model) {
		model.addAttribute("produtos", repository.findAll());
	}
	
	public void formModel(Model model, Produto produto) {
		if (Objects.isNull(produto)) {
			model.addAttribute("produto", new Produto());
			return;
		}
		
		model.addAttribute("produto", produto);
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
	public String save(Produto produto) {
		repository.save(produto);
		return "redirect:" + this.LIST_URL;
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Optional<Produto> produtoOpt = repository.findById(id);
		
		if (produtoOpt.isPresent()) {
			this.formModel(model, produtoOpt.get());
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
