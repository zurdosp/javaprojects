package br.com.ppc.controller.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.ppc.util.PpcUtil;

/**
 * Classe que reporesenta a entidade de negocio Dados da pessoa fisica.
 * @author Christian Oscar Tejada Pacheco
 *
 *
 */
@Entity
@Table(name = "DADOS_PF")
@NamedQuery(name="DadosPF.findAll", query="SELECT e FROM DadosPF e")
public class DadosPF {

	@Id
	@SequenceGenerator(name="DADOS_PF_GENERATOR", sequenceName="seqDADOS_PF", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DADOS_PF_GENERATOR")
	private Long id;

	@Column(name = "NOME", length = 100, nullable = false)
	private String nome;

	@Column(name = "SOBRE_NOME", length = 100, nullable = false)
	private String sobreNome= "";

	@Column(name = "APELIDO", length = 50)
	private String apelido= "";

	@Column(name = "RG", length = 15)
	private String rg= "";

	@Column(name = "CPF", length = 11)
	private String cpf= "";

	@Column(name = "EMAIL_1", length = 200, nullable = false)
	private String email1;

	@Column(name = "EMAIL_2", length = 200)
	private String email2;

	@Column(name = "CARGO", length = 50)
	private String cargo;

	@Column(name = "TELEFONE_FIXO_DDD", length = 2, nullable = false)
	private String telefoneFixoDDD = null;

	@Column(name = "TELEFONE_FIXO_NRO", length = 12, nullable = false)
	private String telefoneFixo = null;

	@Column(name = "TELEFONE_CELULAR_DDD", length = 2)
	private String telefoneCelularDDD = null;

	@Column(name = "TELEFONE_CELULAR_NRO", length = 12)
	private String telefoneCelular = null;

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(final String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(final String apelido) {
		this.apelido = apelido;
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

	public String getTelefoneCelularDDD() {
		return telefoneCelularDDD;
	}

	public void setTelefoneCelularDDD(final String telefoneCelularDDD) {
		this.telefoneCelularDDD = telefoneCelularDDD;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(final String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(final String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(final String cpf) {
		this.cpf = PpcUtil.limpaCPF(cpf);
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(final String cargo) {
		this.cargo = cargo;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

}
