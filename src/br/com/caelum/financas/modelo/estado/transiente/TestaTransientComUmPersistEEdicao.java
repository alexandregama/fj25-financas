package br.com.caelum.financas.modelo.estado.transiente;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
/*
 
 Neste teste estamos persistindo uma conta
 - Criamos a conta
 - Persistimos a conta
 - Editamos novamente a conta
 - Commit da Transacao
 
 Neste caso o Hibernate executa um insert e em seguida um update
 
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

public class TestaTransientComUmPersistEEdicao {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = new Conta("Alexandre Gama", "1234567", "123");
		
		manager.getTransaction().begin();
		manager.persist(conta); //cria a query de insert aqui
		
		conta.setTitular("Gama");
		conta.setNumero("987654");
		
		manager.getTransaction().commit(); //cria a query de update devido ao set
		manager.close();
	}
	
}
