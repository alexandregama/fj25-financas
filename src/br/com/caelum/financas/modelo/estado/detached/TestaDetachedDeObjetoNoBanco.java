package br.com.caelum.financas.modelo.estado.detached;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

/*
 
 Teremos o seguinte erro no código abaixo:
 
 org.hibernate.PersistentObjectException: detached entity passed to persist
 
 Estamos tentando persistir uma conta que foi detached
 
 */

public class TestaDetachedDeObjetoNoBanco {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta("Alexandre Gama", "1234567", "123");
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();

		manager.detach(conta);
		
		manager.persist(conta);
		
		manager.close();
	}
	
}
