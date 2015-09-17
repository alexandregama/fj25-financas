package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "Movimentacao")
@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; //BigInt no banco de dados
	
	@Column(name = "descricao", length = 100)
	private String descricao;
	
	@Column(name = "valor")
	private BigDecimal valor;
	
	@Column(name = "data")
//	@Temporal(value = TemporalType.TIME) Nao podemos persistir somente TIME
	@Temporal(value = TemporalType.DATE)
	private Calendar data;
	
	@Column(name = "data_criacao") //Se nao usarmos @Temporal é salvo o DateTime por padrão com o tipo Calendar
	private Calendar dataCricao = Calendar.getInstance();

	@Temporal(value = TemporalType.TIMESTAMP)
//	@Temporal(value = TemporalType.TIME) Com o tipo Date podemos usar o Time
	@Column(name = "data_vencimento") //Se nao usarmos @Temporal é salvo o DateTime por padrão com o tipo Date
	private Date dataVencimento = new Date();

	@Enumerated(value = EnumType.STRING)
	@Column(name = "tipo_movimentacao")
	private TipoMovimentacao tipoMovimentacao;
	
	@Enumerated(value = EnumType.ORDINAL) //valor default
	@Column(name = "tipo_atendimento")
	private TipoAtendimento tipoAtendimento;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "conta_id", foreignKey = @ForeignKey(name = "fk_mov_conta")) //Este nome da coluna é o default neste caso
	private Conta conta;
	
	public Movimentacao(Long id, String descricao, TipoMovimentacao tipoMovimentacao,
			TipoAtendimento tipoAtendimento, BigDecimal valor, Calendar data, Date dataVencimento) {
		if (id != null) {
			this.id = id;
		}
		this.dataVencimento = dataVencimento;
		this.data = data;
		this.valor = valor;
		this.descricao = descricao;
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
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public Calendar getData() {
		return data;
	}

	public Calendar getDataCricao() {
		return dataCricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}
