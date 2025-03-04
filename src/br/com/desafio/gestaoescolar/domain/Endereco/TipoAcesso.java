package br.com.desafio.gestaoescolar.domain.Endereco;

public enum TipoAcesso {
	ALSFALTO("Asfalto"),
	CASCALHO("Cascalho"),
	LAMA("Lama");

	public final String name;

	private TipoAcesso(String name) {
		this.name = name;
	}
}
