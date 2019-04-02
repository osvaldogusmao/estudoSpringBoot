package br.com.osvaldogusmao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.osvaldogusmao.domain.Categoria;
import br.com.osvaldogusmao.domain.Endereco;
import br.com.osvaldogusmao.repositories.EnderecoRepository;
import br.com.osvaldogusmao.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	public Endereco buscar(Integer id) {
		Optional<Endereco> endereco = repository.findById(id);
		return endereco.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo " + Categoria.class.getName()));
	}

}
