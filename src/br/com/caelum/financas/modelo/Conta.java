package br.com.caelum.financas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Conta", schema = "controlefinancas") //Por default o schema é o nome do banco de dados
@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "titular", nullable = false)
	private String titular;

	@Column(name = "numero", nullable = false)
	private String numero;

	@Column(name = "agencia", nullable = false)
	private String agencia;
	
	// Hibernate eyes only
	Conta() {
	}
	
	public Conta(String titular, String numero, String agencia) {
		this.titular = titular;
		this.numero = numero;
		this.agencia = agencia;
	}
	
	public Conta(Long id, String titular, String numero, String agencia) {
		this.id = id;
		this.titular = titular;
		this.numero = numero;
		this.agencia = agencia;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", titular=" + titular + ", numero="
				+ numero + ", agencia=" + agencia + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

}
