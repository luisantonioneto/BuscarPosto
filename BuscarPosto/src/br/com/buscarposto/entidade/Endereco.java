package br.com.buscarposto.entidade;

import java.io.Serializable;
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

public class Endereco implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codEndereco;
	private String rua;
	private String qd;
	private String lt;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codCidade")
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.MERGE)
	private Cidade cidade;
	
	@OneToMany(mappedBy="endereco", fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private Collection<Empresa> empresa;
	
	public int getCodEndereco() {
		return codEndereco;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getQd() {
		return qd;
	}
	public void setQd(String qd) {
		this.qd = qd;
	}
	public String getLt() {
		return lt;
	}
	public void setLt(String lt) {
		this.lt = lt;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
}
