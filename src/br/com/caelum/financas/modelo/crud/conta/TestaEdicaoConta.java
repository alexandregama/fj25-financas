package br.com.caelum.financas.modelo.crud.conta;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaEdicaoConta {

	public static void main(String[] args) {
		Conta novaConta = new Conta("Alexandre Gama", "1234567", "123");
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		manager.persist(novaConta);
		
		Conta conta = manager.find(Conta.class, novaConta.getId());
		conta.setTitular("Gama");
		manager.merge(conta);
		conta.setTitular("Gaminha");
		
		manager.getTransaction().commit();
		manager.close();
	}
	
}
