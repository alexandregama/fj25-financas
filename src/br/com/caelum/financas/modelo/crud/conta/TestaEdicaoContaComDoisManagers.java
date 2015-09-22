package br.com.caelum.financas.modelo.crud.conta;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaEdicaoContaComDoisManagers {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = new Conta("Limaaaa", "11111", "22222");
		manager.getTransaction().begin();
		Conta conta2 = manager.merge(conta);
		System.out.println(conta2);
		conta.setTitular("Liminha");
		manager.getTransaction().commit();
		
		manager.close();
	}
	
}
