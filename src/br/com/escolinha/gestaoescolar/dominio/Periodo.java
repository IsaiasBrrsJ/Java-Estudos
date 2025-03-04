package br.com.escolinha.gestaoescolar.dominio;

public enum Periodo {

	MATUTINO("Matutino"),
	VESPERTINO("Verspertino"),
	NOTURNO("Noturno"),
	SABADOS("Sabados");

	private final String nome;

	private Periodo(String nome) {
		this.nome = nome;
	}
}
