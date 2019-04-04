package br.com.osvaldogusmao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.osvaldogusmao.domain.Pagamento;
import br.com.osvaldogusmao.repositories.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository pagamentoRepository;

	public Pagamento buscar(Integer id) {
		Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
		return pagamento.orElse(null);
	}

}
