package br.com.caelum.financas.modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 No mapeamento abaixo estamos usando uma sequence que poderia ser usada para o Postgres ou Oracle.
 O MySQL Não suporta Sequences, ou seja, teremos um erro no commit
 */

@Table(name = "Usuario")
//@Entity //esta comentado pois gera excecao
public class Usuario {

	//Esta Sequence seria para Postgres e Oracle
	@Id
	@SequenceGenerator(name = "usuarioGenerator", 
			initialValue = 1, 
			allocationSize = 10,
			sequenceName = "SEQ_USUARIO")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "usuarioGenerator")
	private Long id;
	
	@Column(name = "nome", length = 50)
	private String nome;
	
	public Usuario(Long id, String nome) {
		if (id != null) {
			this.id = id;
		}
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
