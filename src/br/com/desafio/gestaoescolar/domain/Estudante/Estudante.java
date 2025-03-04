package br.com.desafio.gestaoescolar.domain.Estudante;

import br.com.desafio.gestaoescolar.domain.Endereco.Endereco;

import java.util.Scanner;
import java.util.UUID;

public class Estudante {
	private UUID id;
	private String CPF;
	private String Email;
	private String Telefone;
	private final Endereco endereco;

	public Estudante(String CPF, String email, String telefone, Endereco endereco) {
		this.id = UUID.randomUUID();
		this.CPF = CPF;
		Email = email;
		Telefone = telefone;
		this.endereco = endereco;
	}

	public UUID getId() {
		return id;
	}

	public String getCPF() {
		return CPF;
	}

	public String getEmail() {
		return Email;
	}

	public String getTelefone() {
		return Telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return
				id +
						"," + CPF +
						"," + Email +
						"," + Telefone +
						"," + endereco;

	}

	public static class Factories {
		public static Estudante Create() {

			var read = new Scanner(System.in);
			System.out.print("CPF: ");
			var _cpf = read.next();
			System.out.print("Email: ");
			var _email = read.next();
			System.out.print("Telefone: ");
			var _telefone = read.next();

			var _endereco = Endereco.Factories.Create();
			return new Estudante(_cpf, _email, _telefone, _endereco);
		}
	}
}
