package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class ContaDao {

	private EntityManager manager;

	public ContaDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void adiciona(Conta conta) {
		manager.persist(conta);
	}
	
	public Conta buscaPorId(Long id) {
		return manager.find(Conta.class, id);
	}
	
	public void remove(Conta conta) {
		manager.remove(conta);
	}
	
	@SuppressWarnings("unchecked")
	public List<Conta> lista() {
		String jpql = "select c from Conta c";
		
		return manager.createQuery(jpql).getResultList();
	}
	
}
