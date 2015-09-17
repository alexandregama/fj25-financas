package br.com.caelum.financas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Table(name = "Categoria")
@Entity
public class Categoria {

	@Id
	@TableGenerator(table = "Categoria_PK", 
			name = "categoria_generator",
			pkColumnValue = "conta")
	@GeneratedValue(strategy = GenerationType.TABLE,
			generator = "categoria_generator")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	public Categoria(Long id, String nome) {
		if (id != null) {
			this.id = id;
		}
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
