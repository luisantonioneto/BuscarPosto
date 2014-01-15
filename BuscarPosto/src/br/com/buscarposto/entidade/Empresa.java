package br.com.buscarposto.entidade;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity

public class Empresa implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codEmpresa;
	private String razaoSocial;
	private String CNPJ;
	private String nomeFantasia;
	//private String localizacao;
	//teste
	
	@ManyToMany(
			fetch=FetchType.LAZY
	)
	@JoinTable(
			name="usuario_empresa",
			joinColumns={@JoinColumn(name="codEmpresa")},
			inverseJoinColumns={@JoinColumn(name="codUsuario")}
	)
	private Collection<Usuario> usuarios;	
	

	public int getCodEmpresa() {
		return codEmpresa;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
}
