package br.com.desafio.gestaoescolar.domain.Turma;

import br.com.desafio.gestaoescolar.domain.Curso.Curso;
import br.com.escolinha.gestaoescolar.dominio.Periodo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
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
		return codigo +
				"," + curso +
				"," + dataInicio +
				"," + dataFim +
				"," + periodo;

	}

	public static class Facotries {
		public static Turma Create(String curso) {

			var read = new Scanner(System.in);

			System.out.print("Data inicio: ");
			var _dataInicio = read.next();
			System.out.print("Data Fim: ");
			var _dataFim = read.next();

			var _dataInitConverted = LocalDate.parse(_dataInicio);
			var _dataEndConverted = LocalDate.parse(_dataFim);

			System.out.print("\n[1]- Matutino\n[2]- Vespertino\n[3]-Noturno\n[4]-Sabado \noption: ");
			var _option = read.nextInt();
			Periodo _periodo = null;


			switch (_option) {
				case 1:
					_periodo = Periodo.MATUTINO;
					break;
				case 2:
					_periodo = Periodo.VESPERTINO;
					break;
				case 3:
					_periodo = Periodo.NOTURNO;
					break;
				case 4:
					_periodo = Periodo.SABADOS;
					break;
				default:
					throw new IllegalArgumentException("Invalid operation");
			}

			var _cursoSplited = curso.split(",");
			var course = br.com.desafio.gestaoescolar.domain.Curso.Curso.Factories.CreateWithParameters(_cursoSplited[1], LocalTime.parse(_cursoSplited[2]), _cursoSplited[3]);

			return new Turma(course, _dataInitConverted, _dataEndConverted, _periodo);
		}
	}
}
