package br.com.osvaldogusmao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.osvaldogusmao.domain.Categoria;
import br.com.osvaldogusmao.domain.Cliente;
import br.com.osvaldogusmao.repositories.ClienteRepository;
import br.com.osvaldogusmao.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente buscar(Integer id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo " + Categoria.class.getName()));
	}

}
