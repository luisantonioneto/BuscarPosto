package br.com.buscarposto.entidade;

public class Servico {
	private int codServico;
	private String nome;
	private float preco;
	private String descricao;
	
	public int getCodServico() {
		return codServico;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
