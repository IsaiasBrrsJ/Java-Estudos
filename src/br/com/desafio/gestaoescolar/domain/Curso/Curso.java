package br.com.desafio.gestaoescolar.domain.Curso;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.UUID;

public class Curso {
	private UUID id;
	private String nome;
	private LocalTime cargaHoraria;
	private Nivel nivel;

	private Curso(String nome, LocalTime cargaHoraria, Nivel nivel) {
		id = UUID.randomUUID();
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.nivel = nivel;
	}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalTime getCargaHoraria() {
		return cargaHoraria;
	}

	public Nivel getNivel() {
		return nivel;
	}

	@Override
	public String toString() {
		return
				id +
						"," + nome +
						"," + cargaHoraria +
						"," + nivel;
	}

	public static class Factories {

		public static Curso CreateWithParameters(String nome, LocalTime cargaHoraria, String nivel) {
			return new Curso(nome, cargaHoraria, Enum.valueOf(Nivel.class, nivel));
		}

		public static Curso Create() {

			var read = new Scanner(System.in);

			System.out.print("Informe o nome: ");
			var name = read.nextLine();

			System.out.print("CargaHoraria: ");
			var cargaHor = read.nextLine();

			var caHoraria = LocalTime.parse(cargaHor);

			System.out.print("\nNivel [1] - Basico\n[2]- Intermediario\n[3] - Avancado   :");
			var nivelTip = read.nextInt();
			Nivel nivelHard = null;

			switch (nivelTip) {
				case 1:
					nivelHard = Nivel.BASIC;
					break;
				case 2:
					nivelHard = Nivel.INTERMEDIARIO;
					break;
				case 3:
					nivelHard = Nivel.AVANCADO;
					break;
			}

			return new Curso(name, caHoraria, nivelHard);
		}
	}


}

