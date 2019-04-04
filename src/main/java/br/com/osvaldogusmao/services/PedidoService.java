package br.com.osvaldogusmao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.osvaldogusmao.domain.Pedido;
import br.com.osvaldogusmao.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido buscar(Integer id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return pedido.orElse(null);
	}

}
