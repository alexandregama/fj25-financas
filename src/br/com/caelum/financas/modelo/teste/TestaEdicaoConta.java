package br.com.caelum.financas.modelo.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaEdicaoConta {

	public static void main(String[] args) {
		Conta novaConta = new Conta("Alexandre Gama", "1234567", "123");
		
		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDao dao = new ContaDao(manager);
		manager.getTransaction().begin();
		dao.adiciona(novaConta);
		
		Conta conta = dao.buscaPorId(novaConta.getId());
		conta.setTitular("Gama");
		manager.merge(conta);
		
		manager.getTransaction().commit();
		manager.close();
	}
	
}
