package br.com.buscarposto.entidade;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity

public class Estado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codEstado;
	private String nome;
	private String UF;
	
	@OneToMany(mappedBy = "estado")
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private Collection<Cidade> cidade;
	
	
	public int getCodEstado() {
		return codEstado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	
	
}
