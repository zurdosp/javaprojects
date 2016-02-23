package br.com.ppc.controller.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Classe que representa a empresa cliente (nossa empresa) que usa o sistema Ppc.
 * @author Christian Oscar Tejada Pacheco
 *
 */
@Entity
@Table(name = "NOSSA_EMPRESA")
@NamedQuery(name="NossaEmpresa.findAll", query="SELECT e FROM NossaEmpresa e")
public class NossaEmpresa  implements Serializable {

	private static final long serialVersionUID = 19879878977665L;

	@Id
	@SequenceGenerator(name="NOSSA_EMPRESA_GENERATOR", sequenceName="seqNOSSA_EMPRESA", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOSSA_EMPRESA_GENERATOR")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DADOS_PJ_ID")
	private DadosPJ dadosPJ;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="RL_NOSSA_EMPRESA_DADOS_PF", joinColumns = @JoinColumn(name="NOSSA_EMPRESA_ID"),
	inverseJoinColumns = @JoinColumn(name="DADOS_PF_ID"))
	private DadosPF representante;

	@Column(name = "DATA_CRIACAO", nullable = false)
	private Timestamp dataCriacao;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="RL_NOSSA_EMPRESA_USU_SIS", joinColumns={@JoinColumn(name="NOSSA_EMPRESA_ID",
    referencedColumnName="ID")}
    , inverseJoinColumns={@JoinColumn(name="USUARIO_SISTEMA_ID", referencedColumnName="ID")})


//    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name="RL_NOSSA_EMPRESA_PRODUTO", joinColumns={@JoinColumn(name="NOSSA_EMPRESA_ID",
//    referencedColumnName="ID")}
//    , inverseJoinColumns={@JoinColumn(name="PRODUTO_ID", referencedColumnName="ID")})
//	private List<UsuarioSistema> produto;

	public DadosPF getRepresentante() {
		if (representante == null) {
			representante = new DadosPF();
		}
		return representante;
	}

	public void setRepresentante(final DadosPF representante) {
		this.representante = representante;
	}

	public DadosPJ getDadosPJ() {
		if (dadosPJ == null){
			dadosPJ = new DadosPJ();
		}
		return dadosPJ;
	}

	public void setDadosPJ(final DadosPJ dadosPJ) {
		this.dadosPJ = dadosPJ;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Timestamp getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(final Timestamp dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this);
	}

//	public List<UsuarioSistema> getProduto() {
//		return produto;
//	}
//
//	public void setProduto(final List<UsuarioSistema> produto) {
//		this.produto = produto;
//	}

}
