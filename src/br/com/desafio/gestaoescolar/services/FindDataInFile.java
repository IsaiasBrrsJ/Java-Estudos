package br.com.desafio.gestaoescolar.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class FindDataInFile {
	public static <T> String Find(String className, UUID id) {
		try {
			var path = Path.of(className + ".txt");

			var allLine = Files.readAllLines(path);

			for (var item : allLine) {
				if (item.contains(id.toString())) {
					return item;
				}
			}
			return "Data Not Found";

		} catch (IOException ex) {

			System.out.println("Error in read database " + ex.getMessage());
			return "";
		}
	}
}
