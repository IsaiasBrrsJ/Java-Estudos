package br.com.desafio.gestaoescolar.domain.Endereco;

import java.util.Scanner;
import java.util.UUID;

public final class Endereco {

	private UUID id;
	private String rua;
	private TipoAcesso tipoAcesso;
	private int numero;
	private String bairro;

	private Endereco(String rua, TipoAcesso tipoAcesso, int numero, String bairro) {
		this.id = UUID.randomUUID();
		this.rua = rua;
		this.tipoAcesso = tipoAcesso;
		this.numero = numero;
		this.bairro = bairro;
	}

	public UUID getId() {
		return id;
	}

	public String getRua() {
		return rua;
	}

	public TipoAcesso getTipoAcesso() {
		return tipoAcesso;
	}

	public int getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	@Override
	public String toString() {
		return "Endereco{" +
				",id=" + id +
				",rua='" + rua + '\'' +
				",tipoAcesso=" + tipoAcesso +
				",numero=" + numero +
				",bairro='" + bairro + '\'' +
				'}';
	}

	public static class Factories {
		public static Endereco Create() {

			System.out.println("\n");
			var read = new Scanner(System.in);
			System.out.print("Rua: ");
			var _rua = read.next();
			System.out.print("\nTipo Acesso: [1]- Asfalto\n[2]- Cascalho\n[3]- Lama \n: ");
			var _tipoAcesso = read.nextInt();

			System.out.print("Numero: ");
			var _numero = read.nextInt();
			System.out.println("Bairro: ");
			var _bairro = read.next();

			TipoAcesso tipoAcessoR = null;
			switch (_tipoAcesso) {
				case 1:
					tipoAcessoR = TipoAcesso.ALSFALTO;
					break;
				case 2:
					tipoAcessoR = TipoAcesso.CASCALHO;
					break;
				case 3:
					tipoAcessoR = TipoAcesso.LAMA;
					break;
			}

			return new Endereco(_rua, tipoAcessoR, _numero, _bairro);
		}
	}
}
