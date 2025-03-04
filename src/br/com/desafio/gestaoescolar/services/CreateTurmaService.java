package br.com.desafio.gestaoescolar.services;

import br.com.desafio.gestaoescolar.domain.Turma.Turma;

public class CreateTurmaService {

	public static boolean Create(Turma turma) {
		return AddFile.Save(turma);
	}
}
