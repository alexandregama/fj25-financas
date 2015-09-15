package br.com.caelum.financas.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
	
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
