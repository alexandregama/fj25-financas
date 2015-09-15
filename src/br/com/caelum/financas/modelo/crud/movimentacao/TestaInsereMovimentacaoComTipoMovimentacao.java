package br.com.caelum.financas.modelo.crud.movimentacao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoAtendimento;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaInsereMovimentacaoComTipoMovimentacao {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Calendar hoje = Calendar.getInstance();
		Date hojeDate = new Date();
		Movimentacao movimentacao = new Movimentacao(null, "Cerveja", 
				TipoMovimentacao.ENTRADA, 
				TipoAtendimento.PREMIUM,
				new BigDecimal(100), 
				hoje, 
				hojeDate);
		
		manager.getTransaction().begin();
		manager.persist(movimentacao);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
}
