package br.com.desafio.gestaoescolar;

import br.com.desafio.gestaoescolar.domain.Curso.Curso;
import br.com.desafio.gestaoescolar.domain.Estudante.Estudante;
import br.com.desafio.gestaoescolar.domain.Turma.Turma;
import br.com.desafio.gestaoescolar.services.CreateCourseService;
import br.com.desafio.gestaoescolar.services.CreateStudentService;
import br.com.desafio.gestaoescolar.services.FindDataInFile;
import br.com.desafio.gestaoescolar.services.ListDataInFile;

import java.util.Scanner;
import java.util.UUID;

public class Program {

	public static void main(String[] args) {
		var option = -1;
		var read = new Scanner(System.in);
		do {
			option = Menu();

			switch (option) {

				case 1:
					var student = Estudante.Factories.Create();
					if (CreateStudentService.Create(student))
						System.out.println("Student Created with success");
					break;
				case 2:
					var curso = Curso.Factories.Create();
					if (CreateCourseService.Create(curso))
						System.out.println("Course created with success");
					break;
				case 5:
					ListDataInFile.GetDataInFile(Estudante.class.getName());
					break;
				case 6:
					ListDataInFile.GetDataInFile(Curso.class.getName());
					break;
				case 7:
					var className = GetClassName();
					System.out.println("Informe o ID: ");
					var id = read.next();
					System.out.println(FindDataInFile.Find(className, UUID.fromString(id)).toString());
					break;
				default:
					break;

			}
		} while (option != 0);

	}

	private static String GetClassName() {
		var read = new Scanner(System.in);

		System.out.println("[1] - Estudante\n[2] - Curso\n[3] - Turma : ");
		var option = read.nextInt();

		switch (option) {

			case 1:
				return Estudante.class.getName();

			case 2:
				return Curso.class.getName();

			case 3:
				return Turma.class.getName();
			default:
				throw new IllegalArgumentException("Invalid operation");

		}
	}

	private static int Menu() {
		System.out.println("\t============================");
		System.out.println("\tWelcome To School System ADM");
		System.out.println("\t============================");

		var read = new Scanner(System.in);
		System.out.println("\t[ 1 ] - Cadastrar Estudante");
		System.out.println("\t[ 2 ] - Cadastrar Curso");
		System.out.println("\t[ 3 ] - Cadastrar Turma");
		System.out.println("\t[ 4 ] - Listar Turmas");
		System.out.println("\t[ 5 ] - Listar Estudantes");
		System.out.println("\t[ 6 ] - Listar Cursos");
		System.out.println("\t[ 7 ] - Buscar Por Id: ");
		System.out.println("\t[ 0 ] - Sair");
		System.out.print("Opcao: ");
		var option = read.nextInt();

		return option;
	}
}
