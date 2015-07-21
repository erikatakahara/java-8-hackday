package com.elo7.hackday.example;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<Usuario> usuarios = new Usuarios().lista();
		
		Usuario[] array = (Usuario[]) usuarios.toArray();
		
		// Using filter
		System.out.println(Stream.of(array).filter(new Predicate<Usuario>() {
			@Override
			public boolean test(Usuario usuario) {
				return usuario.getGenero().equals(Genero.FEMININO) && usuario.getIdade() > 24;
			}
		}).collect(Collectors.toList()));
		
		// Using Lambda to filter instead of using Predicate
		System.out.println(
			Stream.of(array)
				.filter(usuario -> usuario.getGenero().equals(Genero.FEMININO) && usuario.getIdade() > 24)
				.collect(Collectors.toList())
		);
		
		// Simplifyng
		System.out.println(
				usuarios.stream()
					.filter(usuario -> usuario.getGenero().equals(Genero.FEMININO) && usuario.getIdade() > 24)
					.collect(Collectors.toList())
		);
		
		// Terminal methods
		// Any Match
		System.out.println(usuarios.stream().anyMatch(u -> u.getIdade() > 25));
		// All Match
		System.out.println(usuarios.stream().allMatch(u -> u.getIdade() > 25));
		// None Match
		System.out.println(usuarios.stream().noneMatch(u -> u.getIdade() < 20));
		
		
		// Map
		System.out.println(
				usuarios.stream()
					.filter(u -> u.getGenero().equals(Genero.FEMININO))
					.map(Usuario::getNome)
					.collect(Collectors.toList())
		);
		
		// Reduce
		System.out.println(
				usuarios.stream()
				.filter(u -> u.getGenero().equals(Genero.FEMININO))
				.map(Usuario::getNome)
				.reduce((nome1, nome2) -> nome1.concat(",").concat(nome2))
				.get()
		);
		
		// Simple way
		System.out.println(
				usuarios.stream()
					.filter(u -> u.getGenero().equals(Genero.FEMININO))
					.map(Usuario::getNome)
					.collect(Collectors.joining(","))
		);
		
		System.out.println(
				usuarios.stream().flatMap(u -> u.getListaDeCompras().stream())
				.map(Compra::getValor)
				.collect(Collectors.toList())
		);
		
	}
	
}
