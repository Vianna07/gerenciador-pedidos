package br.com.gerenciador.pedidos.demo.controllers;

import java.util.Objects;

import br.com.gerenciador.pedidos.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gerenciador.pedidos.demo.models.Pedido;
import br.com.gerenciador.pedidos.demo.repositories.PedidoRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController extends BaseController<Pedido, PedidoRepository> {
	@Autowired
	private ProdutoRepository produtoRepository;

	public PedidoController() {
		super("pedido");
	}

	public void listModel(Model model) {
		model.addAttribute("pedidos", repository.findAll());
	}
	
	public void formModel(Model model, Pedido pedido) {
		model.addAttribute("produtos", produtoRepository.findAll());

		if (Objects.isNull(pedido)) {
			model.addAttribute("pedido", new Pedido());
			return;
		}

		model.addAttribute("pedido", pedido);
	}

}
