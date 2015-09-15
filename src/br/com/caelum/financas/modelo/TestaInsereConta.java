package br.com.caelum.financas.modelo;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;

public class TestaInsereConta {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Alexandre Gama");
		conta.setNumero("12345678");
		conta.setAgencia("1234");
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		manager.close();
	}
	
}
