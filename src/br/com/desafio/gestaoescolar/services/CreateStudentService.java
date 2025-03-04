package br.com.desafio.gestaoescolar.services;

import br.com.desafio.gestaoescolar.domain.Estudante.Estudante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateStudentService {

	public static boolean Create(Estudante estudante) {

		if (ValidateIfCPFIsUnique(estudante.getCPF()) &&
				ValidateIfEmailIsUnique(estudante.getEmail())) {

			System.out.println("EMAIL AND CPF  SHOULD BE UNIQUE");

			return false;
		}

		return AddFile.Save(estudante);
	}

	private static boolean ValidateIfCPFIsUnique(String CPF) {
		return ExistDataInFile(CPF);
	}

	private static boolean ValidateIfEmailIsUnique(String email) {
		return ExistDataInFile(email);
	}

	private static boolean ExistDataInFile(String field) {
		try {
			var path = Path.of(Estudante.class.getName() + ".txt");

			if (!Files.exists(path)) {
				Files.createFile(path);
				return false;
			}

			var file = Files.readAllLines(path);

			for (var line : file) {
				if (line.contains(field)) {
					return true;
				}
			}
			return false;

		} catch (IOException ex) {
			System.out.println("Error in read file " + ex.getMessage());
			return false;
		}
	}
}
