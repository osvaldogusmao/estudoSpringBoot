package br.com.osvaldogusmao;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.osvaldogusmao.domain.Categoria;
import br.com.osvaldogusmao.domain.Cidade;
import br.com.osvaldogusmao.domain.Cliente;
import br.com.osvaldogusmao.domain.Endereco;
import br.com.osvaldogusmao.domain.Estado;
import br.com.osvaldogusmao.domain.Pagamento;
import br.com.osvaldogusmao.domain.PagamentoComCartao;
import br.com.osvaldogusmao.domain.Pedido;
import br.com.osvaldogusmao.domain.Produto;
import br.com.osvaldogusmao.domain.enums.EstadoPagamento;
import br.com.osvaldogusmao.domain.enums.TipoCliente;
import br.com.osvaldogusmao.repositories.CategoriaRepository;
import br.com.osvaldogusmao.repositories.CidadeRepository;
import br.com.osvaldogusmao.repositories.ClienteRepository;
import br.com.osvaldogusmao.repositories.EnderecoRepository;
import br.com.osvaldogusmao.repositories.EstadoRepository;
import br.com.osvaldogusmao.repositories.PagamentoRepository;
import br.com.osvaldogusmao.repositories.PedidoRepository;
import br.com.osvaldogusmao.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaReporitory;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto prod1 = new Produto(null, "Computador", 2000.00);
		Produto prod2 = new Produto(null, "Impressora", 800.00);
		Produto prod3 = new Produto(null, "Mouse", 80.00);

		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));

		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));

		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");
		Estado estado3 = new Estado(null, "Pernambuco");

		Cidade cidade1 = new Cidade(null, "Uberlândia");
		Cidade cidade2 = new Cidade(null, "São Paulo");
		Cidade cidade3 = new Cidade(null, "Campinas");

		estado1.setCidades(Arrays.asList(cidade1));
		estado2.setCidades(Arrays.asList(cidade2, cidade3));

		cidade1.setEstado(estado1);
		cidade2.setEstado(estado2);
		cidade3.setEstado(estado2);

		categoriaReporitory.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));

		estadoRepository.saveAll(Arrays.asList(estado1, estado2, estado3));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));

		Cliente cliente = new Cliente(null, "Maria Silva", "maria.silva@gmail.com", "12345678912",
				TipoCliente.PESSOA_FISICA);
		cliente.getTelefones().add("81981823001");
		cliente.getTelefones().add("81982293001");
		cliente.getTelefones().addAll(Arrays.asList("81988887777", "81999998877"));

		Endereco enderecoUm = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "51030370", cidade1,
				cliente);

		Endereco enderecoDois = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "51030370", cidade2,
				cliente);

		cliente.getEnderecos().addAll(Arrays.asList(enderecoUm, enderecoDois));
		
		clienteRepository.saveAll(Arrays.asList(cliente));
		enderecoRepository.saveAll(Arrays.asList(enderecoUm, enderecoDois));

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, dateFormat.parse("03/04/2019 12:20:00"), cliente, enderecoUm);

		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);

		cliente.getPedidos().addAll(Arrays.asList(ped1));

		pedidoRepository.saveAll(Arrays.asList(ped1));
		pagamentoRepository.saveAll(Arrays.asList(pag1));

	}

}
