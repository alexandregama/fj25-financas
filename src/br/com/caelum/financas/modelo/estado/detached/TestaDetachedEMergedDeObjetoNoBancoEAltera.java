package br.com.caelum.financas.modelo.estado.detached;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

/*
 
 
 */

public class TestaDetachedEMergedDeObjetoNoBancoEAltera {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta("Alexandre Gama", "1234567", "123");
		
		manager.getTransaction().begin();
		manager.persist(conta); //cria a query de insert
		manager.getTransaction().commit(); //executa a query de insert e update
		
		manager.getTransaction().begin();
		Conta contaParaMerge = manager.find(Conta.class, conta.getId()); //cache de 1 nível é usado
		contaParaMerge.setTitular("Gaminha");
		manager.merge(contaParaMerge);
		contaParaMerge.setTitular("Ale Gama");
		manager.getTransaction().commit(); //executa a query de insert e update
		
		manager.close();
	}
	
}
