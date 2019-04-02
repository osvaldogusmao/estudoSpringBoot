package br.com.osvaldogusmao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.osvaldogusmao.domain.Endereco;
import br.com.osvaldogusmao.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService enderecoService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Endereco endereco = enderecoService.buscar(id);
		return ResponseEntity.ok().body(endereco);
	}

}
