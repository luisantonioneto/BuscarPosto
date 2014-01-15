package br.com.buscarposto.entidade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity

public class Combustivel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codCombustivel;
	private String nome;
	private float preco;
	private Calendar dataAtualizacao;
	// Teste
	
	@ManyToMany(
			targetEntity = Empresa.class,
			fetch=FetchType.LAZY
	)
	@JoinTable(
			name="relEmpresa",
			joinColumns={@JoinColumn(name="codCombustivel")},
			inverseJoinColumns={@JoinColumn(name="codEmpresa")}
	)
	private Collection<Empresa> empresas;
	
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
