package br.com.caelum.financas.modelo.crud.categoria;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Categoria;

public class TestaInsereCategoria {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Categoria categoria = new Categoria(null, "Poupanca");
		
		manager.getTransaction().begin();
		manager.persist(categoria);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
}

/*
Primeira Execução:
Hibernate: 
    select
        sequence_next_hi_value 
    from
        Categoria_PK 
    where
        sequence_name = 'conta' for update
            
Hibernate: Nao temos esse insert na segunda execução
    insert 
    into
        Categoria_PK
        (sequence_name, sequence_next_hi_value) 
    values
        ('conta', ?)
Hibernate: 
    update
        Categoria_PK 
    set
        sequence_next_hi_value = ? 
    where
        sequence_next_hi_value = ? 
        and sequence_name = 'conta'
Hibernate: 
    insert 
    into
        Categoria
        (nome, id) 
    values
        (?, ?)

 */
