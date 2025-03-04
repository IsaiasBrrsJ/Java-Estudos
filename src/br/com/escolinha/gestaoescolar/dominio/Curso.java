package br.com.escolinha.gestaoescolar.dominio;

import java.time.LocalDate;

public class Curso {
	private String nome;
	private int cargaHoraria;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Curso curso;

	public Curso(String nome, int cargaHoraria) {
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
	}

	public String getNome() {
		return nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}
}
