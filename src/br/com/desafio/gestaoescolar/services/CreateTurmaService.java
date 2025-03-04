package br.com.desafio.gestaoescolar.services;

import br.com.desafio.gestaoescolar.domain.Curso.Curso;

public class CreateTurmaService {

	public static boolean Create(Curso curso) {
		return AddFile.Save(curso);
	}
}
