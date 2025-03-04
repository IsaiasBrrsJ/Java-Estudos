package br.com.desafio.gestaoescolar.domain.Turma;

public enum Periodo {
	MATUTINO("Matutino"),
	VESPERTINO("Vespertino"),
	NOTUNO("Noturno"),
	SABADO("Sabado");

	public final String name;

	private Periodo(String name) {
		this.name = name;
	}
}
