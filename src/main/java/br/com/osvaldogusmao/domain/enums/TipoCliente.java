package br.com.osvaldogusmao.domain.enums;

public enum TipoCliente {

	PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica");

	private Integer cod;
	private String descricao;

	private TipoCliente(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TipoCliente tc : TipoCliente.values()) {
			if (tc.getCod().equals(cod)) {
				return tc;
			}
		}

		throw new IllegalArgumentException("Id inválido : " + cod);
	}

}
