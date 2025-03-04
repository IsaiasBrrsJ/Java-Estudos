package br.com.desafio.gestaoescolar.domain.Turma;

import br.com.escolinha.gestaoescolar.dominio.Curso;
import br.com.escolinha.gestaoescolar.dominio.Periodo;

import java.time.LocalDate;
import java.util.UUID;

public class Turma {
	private UUID codigo;
	private Curso curso;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Periodo periodo;

	private Turma(Curso curso, LocalDate dataInicio, LocalDate dataFim, Periodo periodo) {
		this.codigo = UUID.randomUUID();
		this.curso = curso;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.periodo = periodo;
	}

	public UUID getCodigo() {
		return codigo;
	}

	public Curso getCurso() {
		return curso;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	@Override
	public String toString() {
		return "Turma{" +
				"codigo=" + codigo +
				", curso=" + curso +
				", dataInicio=" + dataInicio +
				", dataFim=" + dataFim +
				", periodo=" + periodo +
				'}';
	}

	public static class Facotries {
		public static Turma Create(Curso curso, LocalDate dataInicio, LocalDate dataFim, Periodo periodo) {
			return new Turma(curso, dataInicio, dataFim, periodo);
		}
	}
}
