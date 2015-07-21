package com.elo7.hackday.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nome;
	private int idade;
	private Genero genero;
	private List<Compra> listaDeCompras = new ArrayList<Compra>();

	public Usuario(String nome, int idade, Genero genero) {
		this.setNome(nome);
		this.setIdade(idade);
		this.setGenero(genero);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Compra> getListaDeCompras() {
		return listaDeCompras;
	}

	public void setListaDeCompras(List<Compra> listaDeCompras) {
		this.listaDeCompras = listaDeCompras;
	}

}
