package br.com.caelum.financas.modelo.estado;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

/*
  Neste teste persistimos uma conta de forma simples, com somente:
  - Criamos uma conta
  - Persistimos a conta pelo manager
  - O Hibernate gera um insert:
  
Hibernate: 
    insert 
    into
        Conta
        (agencia, numero, titular) 
    values
        (?, ?, ?)  
 */

public class TestaTransientComSomenteUmPersistent {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = new Conta("Alexandre Gama", "1234567", "123");
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
}
