package br.com.osvaldogusmao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.osvaldogusmao.domain.Produto;
import br.com.osvaldogusmao.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto buscar(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElse(null);
	}

}
