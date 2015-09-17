package br.com.caelum.financas.modelo.crud.usuario;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Usuario;

public class TestaInsereUsuario {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Usuario usuario = new Usuario(null, "Gama");
		
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit(); //Erro pois o MySQL não suporta Sequences
		
		manager.close();
	}
	
}
