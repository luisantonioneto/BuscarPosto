package br.com.buscarposto.entidade;

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

public class Conveniencia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codConveniencia;
	
	@ManyToMany(
			fetch = FetchType.LAZY
	)
	@JoinTable(
			name="relEmpresaConveniencia",
			joinColumns = {@JoinColumn(name="codConveniencia")},
			inverseJoinColumns= {@JoinColumn(name="codEmpresa")}
	)
	private Collection<Empresa> empresas;

	public int getCodConveniencia() {
		return codConveniencia;
	}	
}
