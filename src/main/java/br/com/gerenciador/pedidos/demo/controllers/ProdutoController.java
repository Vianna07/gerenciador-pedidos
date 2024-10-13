package br.com.gerenciador.pedidos.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import br.com.gerenciador.pedidos.demo.enums.FieldType;
import br.com.gerenciador.pedidos.demo.view.form.Field;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gerenciador.pedidos.demo.models.Produto;
import br.com.gerenciador.pedidos.demo.repositories.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController extends BaseController<Produto, ProdutoRepository> {

	public ProdutoController() {
		super("produto");
	}

	@Override
	public void listModel(Model model) {
		List<String> colunas = Arrays.asList("id", "nome", "estoque", "preco");

		model.addAttribute("columns", colunas);
		model.addAttribute("produtos", repository.findAll());
	}

	@Override
	public void formModel(Model model, Produto produto) {
		ArrayList<Field> fields = new ArrayList<>(
			Arrays.asList(
				new Field("nome", "Digite o nome do produto", FieldType.TEXT.toString()),
				new Field("estoque", "Digite a quantidade em estoque", FieldType.INT.toString()),
				new Field("preco", "Digite o preço do produto", FieldType.INT.toString())
			)
		);

		model.addAttribute("fields", fields);

		if (Objects.isNull(produto)) {
			model.addAttribute("produto", new Produto());
			return;
		}
		
		model.addAttribute("produto", produto);
	}

}
