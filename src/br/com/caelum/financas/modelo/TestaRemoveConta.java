package br.com.caelum.financas.modelo;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.infra.JPAUtil;

public class TestaRemoveConta {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDao dao = new ContaDao(manager);
		Conta novaConta = new Conta("Alexandre Gama", "1234567", "123");
		Conta conta = dao.buscaPorId(novaConta.getId());
		
		manager.getTransaction().begin();
		dao.remove(conta);
		manager.getTransaction().commit();
		manager.close();
	}
	
}
