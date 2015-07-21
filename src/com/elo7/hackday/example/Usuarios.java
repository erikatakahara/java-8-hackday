package com.elo7.hackday.example;

import java.util.Arrays;
import java.util.List;

public class Usuarios {

	private static List<Usuario> lista = Arrays.asList(
			new Usuario("Erika", 25, Genero.FEMININO),
			new Usuario("Bianca", 22, Genero.FEMININO),
			new Usuario("Hanna", 20, Genero.FEMININO),
			new Usuario("Mateus", 27, Genero.MASCULINO),
			new Usuario("Eric", 22, Genero.MASCULINO),
			new Usuario("Otavio", 29, Genero.MASCULINO),
			new Usuario("Isabela", 26, Genero.FEMININO),
			new Usuario("Gabriela", 27, Genero.FEMININO),
			new Usuario("Yago", 20, Genero.MASCULINO),
			new Usuario("Ana", 21, Genero.FEMININO)
	);
	
	public List<Usuario> lista() {
		return lista;
	}
	
}
