package br.com.desafio.gestaoescolar.services;

import br.com.desafio.gestaoescolar.domain.Curso.Curso;
import br.com.desafio.gestaoescolar.domain.Estudante.Estudante;
import br.com.desafio.gestaoescolar.domain.Turma.Turma;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class AddFile {

	public static <T> boolean Save(T data) {

		Path path = null;

		var classType = data.getClass();
		try {
			if (Estudante.class == classType) {
				path = Path.of(data.getClass().getName() + ".txt");
			} else if (Curso.class == classType) {
				path = Path.of(data.getClass().getName() + ".txt");
			} else if (Turma.class == classType) {
				path = Path.of(data.getClass().getName() + ".txt");
			}

			CheckIfFileExistOrCreate(path);

			Files.writeString(path, data.toString() + "\n", StandardOpenOption.APPEND);
			return true;
		} catch (IOException ex) {
			System.out.println("Error in save to  database " + data.getClass() + "\n" + ex.getMessage());
			return false;
		}
	}

	private static void CheckIfFileExistOrCreate(Path path) throws IOException {
		if (!Files.exists(path)) {
			Files.createFile(path);
		}
	}


}
