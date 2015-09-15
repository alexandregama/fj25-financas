package br.com.caelum.financas.modelo.estado.detached;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

/*
 
 No código abaixo temos os seguintes passos:
 - Criação da conta
 - Persist da Conta
 - Edição do titular da Conta
 
 Query gerada pelo Hibernate:
 
Hibernate: 
    insert 
    into
        Conta
        (agencia, numero, titular) 
    values
        (?, ?, ?)
Hibernate: 
    update
        Conta 
    set
        agencia=?,
        numero=?,
        titular=? 
    where
        id=?
 
 */

public class TestaDetachedEPersistDeObjetoNoBancoEAltera {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta("Alexandre Gama", "1234567", "123");
		
		manager.getTransaction().begin();
		manager.persist(conta); //cria a query de insert
		conta.setTitular("Gama");
		manager.getTransaction().commit(); //executa a query de insert e update
		
		manager.close();
	}
	
}
