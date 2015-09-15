package br.com.caelum.financas.modelo.crud;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta {

	public static void main(String[] args) {
		Conta conta = new Conta("Alexandre Gama", "1234567", "123");
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		ContaDao contaDao = new ContaDao(manager);
		contaDao.adiciona(conta);
		manager.getTransaction().commit();
		manager.close();
	}
	
}
