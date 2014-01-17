package br.com.buscarposto.entidade;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity

public class Cidade {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codCidade;
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codEstado")
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.MERGE)
	private Estado estado;
	
	@OneToMany(mappedBy="cidade",fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	private Collection<Endereco> endereco;
	
	public int getCodCidade() {
		return codCidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
