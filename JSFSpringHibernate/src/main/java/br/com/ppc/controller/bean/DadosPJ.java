package br.com.ppc.controller.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.ppc.enums.TamanhoEmpresaEnum;
import br.com.ppc.util.PpcUtil;
/**
 *
 * @author Christian Oscar Tejada Pacheco
 *
 */
@Entity
@Table(name = "DADOS_PJ")
@NamedQuery(name="DadosPJ.findAll", query="SELECT e FROM DadosPJ e")
public class DadosPJ {

	@Id
	@SequenceGenerator(name="DADOS_PJ_GENERATOR", sequenceName="seqDADOS_PJ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DADOS_PJ_GENERATOR")
	private Long id;

	@Column(name = "CNPJ", nullable = false, length = 14)
	private String cnpj;

	@Column(name = "NOME_FANTASIA", nullable = false, length = 100)
	private String nomeFantasia;

	@Column(name = "RAZAO_SOCIAL", nullable = false, length = 100)
	private String razaoSocial;

	@Transient
	private TamanhoEmpresaEnum tamanhoEmpresaEnum;

	@Column(name = "TIPO_EMPRESA", length = 10, nullable = false)
	private Integer tamanhoEmpresa;

	@Column(name = "FATURAMENTO_ANUAL", length = 14, scale = 4)
	private BigDecimal faturamentoAnual;

	@Column(name = "DESCRICAO", length = 2000)
	private String descricao;

	@Column(name = "EMAIL_1", length = 100, nullable = false)
	private String email1 = "";

	@Column(name = "EMAIL_2", length = 100)
	private String email2 = "";

	@Column(name = "TELEFONE_FIXO_DDD", nullable = false, length = 2)
	private String telefoneFixoDDD = null;

	@Column(name = "TELEFONE_FIXO_NRO", nullable = false, length = 10)
	private String telefoneFixo = null;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(final String cnpj) {
		this.cnpj = PpcUtil.deixaSoNumeros(cnpj);
	}

	public TamanhoEmpresaEnum getTamanhoEmpresaEnum() {
		return tamanhoEmpresaEnum;
	}

	public void setTamanhoEmpresaEnum(final TamanhoEmpresaEnum tamanhoEmpresaEnum) {
		this.tamanhoEmpresaEnum = tamanhoEmpresaEnum;
	}

	public BigDecimal getFaturamentoAnual() {
		return faturamentoAnual;
	}

	public void setFaturamentoAnual(final BigDecimal faturamentoAnual) {
		this.faturamentoAnual = faturamentoAnual;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(final String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(final String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Integer getTamanhoEmpresa() {
		return tamanhoEmpresa;
	}

	public void setTamanhoEmpresa(final Integer tamanhoEmpresa) {
		this.tamanhoEmpresa = tamanhoEmpresa;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(final String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(final String email2) {
		this.email2 = email2;
	}

	public String getTelefoneFixoDDD() {
		return telefoneFixoDDD;
	}

	public void setTelefoneFixoDDD(final String telefoneFixoDDD) {
		this.telefoneFixoDDD = telefoneFixoDDD;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(final String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

}
