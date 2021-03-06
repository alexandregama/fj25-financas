package br.com.caelum.financas.modelo.estado.detached;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

/*
 
 No código abaixo temos os seguintes passos:
 - Criação da conta
 - Merge da conta que não existe no banco
 - A última alteração do titular não e refletida, pois o merge não altera o estado do objeto
 
 Query gerada pelo Hibernate:
 
 Hibernate: 
    select
        conta0_.id as id1_0_0_,
        conta0_.agencia as agencia2_0_0_,
        conta0_.numero as numero3_0_0_,
        conta0_.titular as titular4_0_0_ 
    from
        Conta conta0_ 
    where
        conta0_.id=?
 Hibernate: 
    insert 
    into
        Conta
        (agencia, numero, titular) 
    values
        (?, ?, ?)
        
 Temos um select antes do insert justamente para o Hibernate saber se ele faz o update ou insert        
 
 */

public class TestaDetachedEMergeDeObjetoTransientAlterado {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta(1L, "Alexandre Gama", "1234567", "123");
		
		manager.getTransaction().begin();
		manager.merge(conta);
		conta.setTitular("Gaminha"); //merge não altera o estado do objeto. A session do Hibernate sim
		manager.getTransaction().commit();
		
		manager.close();
	}
	
}
