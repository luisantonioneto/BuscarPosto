package br.com.buscarposto.persistencia;

import javax.persistence.*;

import br.com.buscarposto.entidade.Cidade;
import br.com.buscarposto.entidade.Combustivel;
import br.com.buscarposto.entidade.Conveniencia;
import br.com.buscarposto.entidade.Empresa;
import br.com.buscarposto.entidade.Endereco;
import br.com.buscarposto.entidade.Estado;
import br.com.buscarposto.entidade.Servico;
import br.com.buscarposto.entidade.Usuario;

public class GerarTabelas {
	public static void main (String[] args){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("buscarPosto");
		EntityManager manager = factory.createEntityManager();
		
		Usuario usuario = new Usuario();
		Empresa empresa = new Empresa();
		Combustivel combustivel = new Combustivel();
		Servico servico = new Servico();
		Conveniencia conveniencia = new Conveniencia();
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		Endereco endereco = new Endereco();

		factory.close();
	}
}