package com.elo7.hackday.futebol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Time {

	private static List<Jogador> jogadores = Arrays.asList(
			new Jogador("Eric", Posicao.DEFESA, -1),
			new Jogador("Erika", Posicao.ATAQUE, 7),
			new Jogador("Erika", Posicao.ATAQUE, 5),
			new Jogador("Hanna", Posicao.ATAQUE, 10),
			new Jogador("Isabela", Posicao.DEFESA, 1),
			new Jogador("Greg", Posicao.DEFESA, 2),
			new Jogador("Otavio", Posicao.GOLEIRO, 0)
	);
	
	public List<Jogador> lista() {
		return jogadores;
	}

	public List<Jogador> atacantes() {
		return jogadores.stream()
				.filter(jogador -> jogador.getPosicao().equals(Posicao.ATAQUE))
				.collect(Collectors.toList());
	}
	
	public List<Jogador> ordenadoPorNome() {
		return jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getNome))
				.collect(Collectors.toList());
	}
	
	public List<Jogador> ordenadoPorNomeReverso() {
		return jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getNome).reversed())
				.collect(Collectors.toList());
	}
	
	public List<Jogador> ordenadoPorTotalDeGols() {
		return jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getNumeroDeGols).reversed())
				.collect(Collectors.toList());
	}
	
	public List<Jogador> ordenadoPorNomeEGols() {
		return jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getNome).thenComparing(Jogador::getNumeroDeGols).reversed())
				.collect(Collectors.toList());
	}
	
	public boolean todosFizeramGol() {
		return jogadores.stream().allMatch(Jogador::fezGol);
	}
	
	public boolean podeAparecerNoFantastico() {
		return jogadores.stream().anyMatch(j -> j.getNumeroDeGols() > 3);
	}
	
	public boolean fezGolContra() {
		return jogadores.stream().anyMatch(Jogador::fezGolContra);
	}
	
	public List<String> nomeJogadores(){
		return jogadores.stream()
				.map(Jogador::getNome).collect(Collectors.toList());
		
	}
	
	public String escalacao(){
		return jogadores.stream()
				.map(Jogador::getNome).collect(Collectors.joining(","));
	}
	
	public long totalDeGols(){
//		Usando redução
//		return jogadores.stream()
//				.map(Jogador::getNumeroDeGols)
//				.reduce((i1, i2) -> i1+i2).get();
		
//		Usando Sum ao inves do summary. O Sum, Min e Max fo MapToInt e mais performatico
//		return jogadores.stream().mapToInt(Jogador::getNumeroDeGols).sum();
		
		return sumarioDeGols().getSum();
	}
	
	public int maiorGol() {
		return sumarioDeGols().getMax();
	}
	
	public int menorGol() {
		return sumarioDeGols().getMin();
	}
	
	public double mediaDeGols(){
		return sumarioDeGols().getAverage();
	}
	
	private IntSummaryStatistics sumarioDeGols() {
		return jogadores.stream().mapToInt(Jogador::getNumeroDeGols).summaryStatistics();
	}
	
	public Map<Posicao, List<Jogador>> agrupadosPorPosicao(){
		return jogadores.stream().collect(Collectors.groupingBy(Jogador::getPosicao));
	}
	
	public List<Jogador> jogadoresFantasticos() {
		return jogadores.stream().collect(Collectors.partitioningBy(jogador -> jogador.getNumeroDeGols() > 3)).get(true);
	}
	
	public Map<Boolean, List<String>> nomeDosJogadoresFantasticos() {
		return jogadores.stream().collect(Collectors.partitioningBy(jogador -> jogador.getNumeroDeGols() > 3,
				Collectors.mapping(Jogador::getNome, Collectors.toList())));
	}
	
}
