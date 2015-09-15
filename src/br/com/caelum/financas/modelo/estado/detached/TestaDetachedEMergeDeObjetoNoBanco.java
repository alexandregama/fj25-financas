package br.com.caelum.financas.modelo.estado.detached;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

/*
 
 No código abaixo temos os seguintes passos:
 - Criação da conta
 - Merge da conta que já existe no banco
 
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
        
 Temos um select antes do insert justamente para o Hibernate saber se ele faz o update ou insert        
 
 */

public class TestaDetachedEMergeDeObjetoNoBanco {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta("Alexandre Gama", "1234567", "123");
		
		manager.getTransaction().begin();
		manager.persist(conta); //cria a query de insert
		manager.getTransaction().commit(); //executa a query de insert
		
		manager.getTransaction().begin();
		Conta contaParaUpdate = manager.find(Conta.class, conta.getId());
		contaParaUpdate.setTitular("Gama");
		manager.merge(contaParaUpdate); //monta a query de update
		manager.getTransaction().commit(); //executa a query de update
		
		manager.close();
	}
	
}
