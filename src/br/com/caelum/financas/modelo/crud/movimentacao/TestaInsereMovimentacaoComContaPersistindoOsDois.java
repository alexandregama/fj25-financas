package br.com.caelum.financas.modelo.crud.movimentacao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoAtendimento;
import br.com.caelum.financas.modelo.TipoMovimentacao;

/*
 
Geramos 2 inserts no banco de dados
 
Hibernate: 
    insert 
    into
        Conta
        (agencia, numero, titular) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        Movimentacao
        (conta_id, data, data_criacao, data_vencimento, descricao, tipo_atendimento, tipo_movimentacao, valor) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?)  
  
 */

public class TestaInsereMovimentacaoComContaPersistindoOsDois {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Calendar hoje = Calendar.getInstance();
		Date hojeDate = new Date();
		Movimentacao movimentacao = new Movimentacao(null, "Cerveja", 
				TipoMovimentacao.ENTRADA, 
				TipoAtendimento.PREMIUM,
				new BigDecimal(100), 
				hoje, 
				hojeDate);
		
		Conta conta = new Conta("Alexandre Gama", "1234567", "123");
		movimentacao.setConta(conta);
		
		manager.persist(conta);
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();
		manager.close();
	}
	
}
