package br.com.caelum.financas.modelo.crud;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaBuscaConta {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDao dao = new ContaDao(manager);
		
		Conta novaConta = new Conta("Alexandre Gama", "1234567", "123");
		manager.getTransaction().begin();
		dao.adiciona(novaConta);
		manager.getTransaction().commit();
		
		Conta conta = dao.buscaPorId(novaConta.getId());
		
		System.out.println(conta);
		manager.close();
	}
	
}
