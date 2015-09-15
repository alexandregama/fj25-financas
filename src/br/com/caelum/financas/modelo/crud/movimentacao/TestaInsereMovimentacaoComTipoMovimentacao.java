package br.com.caelum.financas.modelo.crud.movimentacao;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoAtendimento;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaInsereMovimentacaoComTipoMovimentacao {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Movimentacao movimentacao = new Movimentacao(null, TipoMovimentacao.ENTRADA, TipoAtendimento.PREMIUM);
		
		manager.getTransaction().begin();
		manager.persist(movimentacao);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
}
