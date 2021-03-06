package br.com.osvaldogusmao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.osvaldogusmao.domain.Pagamento;
import br.com.osvaldogusmao.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
