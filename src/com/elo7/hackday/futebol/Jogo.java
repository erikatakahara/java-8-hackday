package com.elo7.hackday.futebol;

import java.util.List;

public class Jogo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Time time = new Time();
		List<Jogador> atacantes = time.atacantes();
		atacantes.forEach(jogador -> System.out.println(jogador.getNome()));
		
		// Method Reference
		atacantes.forEach(System.out::println);
		
		System.out.println("------------------ Sorting Name ----------------");
		time.ordenadoPorNome().forEach(System.out::println);
		
		System.out.println("------------------ Sorting Reversed Name ----------------");
		time.ordenadoPorNomeReverso().forEach(System.out::println);
		
		System.out.println("------------------ Sorting Goals ----------------");
		time.ordenadoPorTotalDeGols().forEach(System.out::println);
		
		System.out.println("------------------ Sorting Name and Goals ----------------");
		time.ordenadoPorNomeReverso().forEach(System.out::println);
		
		System.out.println("------------------ Todos jogadores fizeram Gol ----------------");
		System.out.println(time.todosFizeramGol());
		
		System.out.println("------------------ Pode aparecer no Fantastico ----------------");
		System.out.println(time.podeAparecerNoFantastico());
		
		System.out.println("------------------ Fez gol contra ----------------");
		System.out.println(time.fezGolContra());
		
		System.out.println("------------------ Lista de jogadores ----------------");
		System.out.println(time.nomeJogadores());
		
		System.out.println("------------------ String de jogadores ----------------");
		System.out.println(time.escalacao());
		
		System.out.println("------------------ Estatisticas ----------------");
		System.out.println("Total de gols: " + time.totalDeGols());
		System.out.println("Maior numero de gols: " + time.maiorGol());
		System.out.println("Menor numero de gols: " + time.menorGol());
		System.out.println("Media de gols: " + time.mediaDeGols());
		
		System.out.println("------------------ Jogadores agrupados por posicao ----------------");
		System.out.println("Ataque: " + time.agrupadosPorPosicao().get(Posicao.ATAQUE));
		System.out.println("Defesa: " + time.agrupadosPorPosicao().get(Posicao.DEFESA));
		System.out.println("Goleiro: " + time.agrupadosPorPosicao().get(Posicao.GOLEIRO));

		System.out.println("------------------ Jogadores que podem ir ao Fantastico ----------------");
		System.out.println(time.jogadoresFantasticos());
		
		
		System.out.println("------------------ Sorting Name and Goals ----------------");
		time.ordenadoPorNomeEGols().forEach(System.out::println);
	}

}
