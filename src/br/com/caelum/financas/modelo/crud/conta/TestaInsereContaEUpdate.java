package br.com.caelum.financas.modelo.crud.conta;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaInsereContaEUpdate {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = new Conta("Alexandre Gama", "1234567", "123");
		
		manager.getTransaction().begin();
		manager.persist(conta); // gera sql de insert
		conta.setTitular("Lima"); //gera sql de update
		manager.getTransaction().commit();
		
		manager.close();
	}
	
}
