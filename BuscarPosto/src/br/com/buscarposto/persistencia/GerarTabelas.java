package br.com.buscarposto.persistencia;

import javax.persistence.*;

import br.com.buscarposto.entidade.Empresa;
import br.com.buscarposto.entidade.Usuario;

public class GerarTabelas {
	public static void main (String[] args){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("buscarPosto");
		EntityManager manager = factory.createEntityManager();
		
		Usuario usuario = new Usuario();
		Empresa empresa = new Empresa();

		factory.close();
	}
}
