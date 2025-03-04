package br.com.escolinha.gestaoescolar;

import br.com.escolinha.gestaoescolar.dominio.Estudante;
import br.com.escolinha.gestaoescolar.dominio.Turma;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws InterruptedException, IOException {

//	 var conta = new br.com.escolinha.gestaoescolar.funcionalidades.Conta();
//	 var reader = new Scanner(System.in);
//
//	 System.out.print("Informe o valor para sacar: ");
//     var sacar = reader.nextDouble();
//
//	 var isValid = conta
//			 .Sacar(sacar);
//
//	 if(!isValid)
//		 System.out.println("Invalid");
//
//	 var person = br.com.escolinha.gestaoescolar.funcionalidades.Person.Factories.Create("Isaias", "Barros@gmail.com");
//     var personII = br.com.escolinha.gestaoescolar.funcionalidades.Person.Factories.Create("Barros", "isaias@gmail.com");
//	 var list = new ArrayList<br.com.escolinha.gestaoescolar.funcionalidades.Person>();
//
//	 list.add(personII);
//	 list.add(person);
//
//  for(var i :list){
//
//	  System.out.println(i.getId());
//	  System.out.println(i.getEmail());
//	  System.out.println(i.getName());
//	  System.out.println("===========================");
//  }
//	 System.out.println("Cached with success");
		var today = LocalDate.now();
		var formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		var dataNascimento = LocalDate.of(1987, 10, 12);

		System.out.println(today.format(formato));
		System.out.println("\t============================");
		System.out.println("\tWelcome To School System ADM");
		System.out.println("\t============================");
		var path = Path.of("base.txt");

		if (!Files.exists(path)) {
			Files.createFile(path);
		}
		var student = new ArrayList<Estudante>();

		var turma = new ArrayList<Turma>();

		var option = -1;

		do {
			option = ExibirMenu();
			switch (option) {
				case 1:
					var turm = Turma.Factories.Create();
					var result = Save(path, turm);
					break;
				case 2:
					var studen = Estudante.Factories.Create();
					var resul = Save(path, studen);
					break;
				case 3:
					Listar(path);
					break;
				case 4:
					ListarCadastros(student);
					break;
				default:
					System.out.println("Opção inválida");
					break;
			}
			System.out.println("Clique para prosseguir");
			Thread.sleep(220);

		} while (option != 5);
	}

	private static <T> boolean Save(Path path, T data) {
		try {
			Files.writeString(path, data.toString() + "\n",
					StandardOpenOption.APPEND);
			return true;
		} catch (IOException ex) {
			return false;
		}
	}

	private static int ExibirMenu() {
		var read = new Scanner(System.in);
		System.out.println("\t[ 1 ] - Cadatrar br.com.escolinha.gestaoescolar.dominio.Turma");
		System.out.println("\t[ 2 ] - Cadatrar br.com.escolinha.gestaoescolar.dominio.Estudante");
		System.out.println("\t[ 3 ] - Listar Turmas");
		System.out.println("\t[ 4 ] - Listar Estudantes");
		System.out.println("\t[ 5 ] - Sair");
		System.out.print("Opcao: ");
		var option = read.nextInt();
		return option;
	}

	private static <T> void ListarCadastros(ArrayList<T> list) {
		if (!list.isEmpty()) {
			for (T item : list) {
				System.out.println(item.toString());
			}
			return;
		}
		System.out.println("Lista vazia");
	}

	private static void Listar(Path file) throws IOException {
		var dados = Files.readAllLines(file);
		for (var d : dados) {
			System.out.println(d.toString());
		}
	}
}
