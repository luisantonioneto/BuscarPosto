package br.com.buscarposto.entidade;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity

public class Servico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codServico;
	private String nome;
	private float preco;
	private String descricao;
	
	@ManyToMany
	@JoinTable(
			name="relEmpresaServico",
			joinColumns={@JoinColumn(name="codServico")},
			inverseJoinColumns={@JoinColumn(name="codEmpresa")}
	)
	private Collection<Empresa> empresas;
	
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
