package br.com.buscarposto.entidade;

import java.util.Calendar;

public class Combustivel {
	private int codCombustivel;
	private String nome;
	private float preco;
	private Calendar dataAtualizacao;
	
	public int getCodCombustivel() {
		return codCombustivel;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
}
