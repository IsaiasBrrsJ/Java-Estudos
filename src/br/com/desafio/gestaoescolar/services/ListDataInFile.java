package br.com.desafio.gestaoescolar.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ListDataInFile {

	public static <T> void GetDataInFile(T data) {
		try {

			var path = Path.of(data + ".txt");

			var allLine = Files.readAllLines(path);

			if (allLine.isEmpty())
				System.out.println("Data File is Empty");


			for (var item : allLine) {
				System.out.println(item.toString());
				System.out.println("===================");
			}

		} catch (IOException ex) {
			System.out.println("Erro in dataFile " + ex.getMessage());
		}
	}
}
