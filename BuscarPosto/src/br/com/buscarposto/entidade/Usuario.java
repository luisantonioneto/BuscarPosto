package br.com.buscarposto.entidade;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity

public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codUsuario;
	private String email;
	private String senha;
	
	@ManyToMany(
			targetEntity = Empresa.class,
			fetch = FetchType.LAZY, cascade = CascadeType.ALL
	)
	@JoinTable(
			name = "usuario_empresa", 
			joinColumns = {@JoinColumn(name = "codUsuario")},
			inverseJoinColumns = {@JoinColumn (name = "codEmpresa")}
	)
	
	private Collection<Empresa> empresas;
	
	public int getCodUsuario() {
		return codUsuario;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
