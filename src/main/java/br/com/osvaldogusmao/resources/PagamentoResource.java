package br.com.osvaldogusmao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.osvaldogusmao.domain.Pagamento;
import br.com.osvaldogusmao.services.PagamentoService;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoResource {

	@Autowired
	private PagamentoService pagamentoService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pagamento pagamento = pagamentoService.buscar(id);
		return ResponseEntity.ok().body(pagamento);
	}

}
