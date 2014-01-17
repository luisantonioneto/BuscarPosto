package br.com.buscarposto.entidade;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@ManagedBean

public class Empresa implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codEmpresa;
	private String razaoSocial;
	private String CNPJ;
	private String nomeFantasia;
	//private String localizacao;
	
	// Relacionameto Empresa <-> Endereco
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codEndereco")
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.MERGE)
	private  Endereco endereco;
	
	// Relacionamento Usuário <-> Empresa
	@ManyToMany(
			fetch=FetchType.LAZY
	)
	@JoinTable(
			name="usuario_empresa",
			joinColumns={@JoinColumn(name="codEmpresa")},
			inverseJoinColumns={@JoinColumn(name="codUsuario")}
	)
	private Collection<Usuario> usuario;
	

	// Relacionamento Empresa <-> Combustivel	
	@ManyToMany(
			targetEntity = Combustivel.class,
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL
	)
	@JoinTable(
			name="relEmpresa",
			joinColumns = {@JoinColumn(name = "codEmpresa")},
			inverseJoinColumns = {@JoinColumn(name = "codCombustivel")}
	)
	private Collection<Combustivel> combustivel;
	
	// Relacionamento Empresa <-> Serviço
	@ManyToMany(
			targetEntity = Servico.class,
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL
	)
	@JoinTable(
			name="relEmpresa",
			joinColumns = {@JoinColumn(name = "codEmpresa")},
			inverseJoinColumns = {@JoinColumn(name = "codServico")}
	)
	private Collection<Servico> servico;
	
	// Relacionamento Empresa <-> Conveniencia
	@ManyToMany(
			targetEntity = Conveniencia.class,
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL
	)
	@JoinTable(
			name="relEmpresa",
			joinColumns = {@JoinColumn(name = "codEmpresa")},
			inverseJoinColumns = {@JoinColumn(name = "codConveniencia")}
	)
	private Collection<Conveniencia> conveniencia;
	
	
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
