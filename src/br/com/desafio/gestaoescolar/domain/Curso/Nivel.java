package br.com.desafio.gestaoescolar.domain.Curso;


public enum Nivel {

	BASIC("Basico"),
	INTERMEDIARIO("Intermediario"),
	AVANCADO("Avancado");

	public final String name;

	private Nivel(String name) {
		this.name = name;
	}
}
