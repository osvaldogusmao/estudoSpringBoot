package br.com.osvaldogusmao.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.osvaldogusmao.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {

		Categoria catUm = new Categoria(1, "Categoria Um");
		Categoria catDois = new Categoria(2, "Categoria Dois");

		List<Categoria> lista = new ArrayList<>();
		lista.add(catUm);
		lista.add(catDois);

		return lista;
	}

}
