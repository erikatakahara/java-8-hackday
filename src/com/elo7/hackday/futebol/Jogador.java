package com.elo7.hackday.futebol;

public class Jogador {

	private String nome;
	private Posicao posicao;
	private int numeroDeGols;

	public Jogador(String nome, Posicao posicao, int numeroDeGols) {
		this.setNome(nome);
		this.setPosicao(posicao);
		this.setNumeroDeGols(numeroDeGols);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public int getNumeroDeGols() {
		return numeroDeGols;
	}

	public void setNumeroDeGols(int numeroDeGols) {
		this.numeroDeGols = numeroDeGols;
	}
	
	public boolean fezGol() {
		return this.numeroDeGols > 0;
	}

	public boolean fezGolContra() {
		return numeroDeGols < 0;
	}

	@Override
	public String toString() {
		return nome + ", " + numeroDeGols;
	}
}
