package br.com.gerenciador.pedidos.demo.controllers;

import java.util.Optional;

//import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public abstract class BaseController<T, K extends JpaRepository<T, Integer>> {
	@Autowired
	public K repository;

	public String LIST;
	public String LIST_URL;
	public String FORM;
	
	public BaseController(String baseUrl) {
		this.LIST = baseUrl + "/list";
		this.LIST_URL = "/" + baseUrl + "/list";
		this.FORM = baseUrl + "/form";
	}
	
	public abstract void listModel(Model model);
	public abstract void formModel(Model model, T entity);
	
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
	public String save(T entity) {
		repository.save(entity);
		return "redirect:" + this.LIST_URL;
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Optional<T> entityOpt = repository.findById(id);
		
		if (entityOpt.isPresent()) {
			this.formModel(model, entityOpt.get());
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
