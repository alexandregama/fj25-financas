package br.com.caelum.financas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Movimentacao", schema = "controlefinancas")
@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "tipo_movimentacao")
	private TipoMovimentacao tipoMovimentacao;
	
	@Enumerated(value = EnumType.ORDINAL) //valor default
	@Column(name = "tipo_atendimento")
	private TipoAtendimento tipoAtendimento;
	
	public Movimentacao(Long id, TipoMovimentacao tipoMovimentacao,
			TipoAtendimento tipoAtendimento) {
		if (id != null) {
			this.id = id;
		}
		this.tipoMovimentacao = tipoMovimentacao;
		this.tipoAtendimento = tipoAtendimento;
	}

	@Override
	public String toString() {
		return "Movimentacao [id=" + id + ", tipoMovimentacao="
				+ tipoMovimentacao + ", tipoAtendimento=" + tipoAtendimento
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}
	
}
