package br.com.caelum.financas.modelo.estado.transiente;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

/*
 
 Neste teste persistimos um objeto com o mesmo manager mas com transacoes diferentes
 Aqui é executado um insert e em seguida um update pelo Hibernate
 
 */

public class TestaTransientComDuasTransactions {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = new Conta("Alexandre Gama", "1234567", "123");
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		conta.setTitular("Gama");
		manager.getTransaction().commit();
		
		manager.close();
	}
	
}
