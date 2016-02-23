package br.com.ppc.controller;

import java.util.Arrays;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ppc.enums.TamanhoEmpresaEnum;
import br.com.ppc.enums.condicoescomercial.TipoCondicaoComercialEnum;
import br.com.ppc.service.IPpcNossaEmpresaService;

/**
 * The Class PreVendaController.
 *
 * @author Christian Oscar Tejada Pacheco
 */
public class PpcController {

	private static final Logger logger = LoggerFactory.getLogger(PpcController.class);

	private HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

	/** The produto selected. */
	private Long produtoSelected;

	private String produtoSelectedLabel;

	private String cnpjFormatado;

	private SelectItem[] cidadesByEstado;

	@Autowired
	private IPpcNossaEmpresaService ppcNossaEmpresaService;

	private boolean editMode;

    private StreamedContent filePDF;

	/**
	 * Gets the produto selected.
	 *
	 * @return the produto selected
	 */
	public Long getProdutoSelected() {
		return produtoSelected;
	}

	/**
	 * Sets the produto selected.
	 *
	 * @param produtoSelected
	 *            the new produto selected
	 */
	public void setProdutoSelected(final Long produtoSelected) {
		this.produtoSelected = produtoSelected;
	}

	public IPpcNossaEmpresaService getPpcNossaEmpresaService() {
		return ppcNossaEmpresaService;
	}

	public void setPpcNossaEmpresaService(final IPpcNossaEmpresaService ppcNossaEmpresaService) {
		this.ppcNossaEmpresaService = ppcNossaEmpresaService;
	}

	/**
	 * Retorna os tipos da condição comercial em forma de lista
	 * @return Lista
	 */
	public List<TipoCondicaoComercialEnum> getTipoCC() {
		return Arrays.asList(TipoCondicaoComercialEnum.values());
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(final HttpServletRequest request) {
		this.request = request;
	}


	public SelectItem[] getTamanhosEmpresa() {
		SelectItem[] tipoEmpresaEnum = new SelectItem[TamanhoEmpresaEnum.values().length];
		int i = 0;
		for (TamanhoEmpresaEnum empresaEnum : TamanhoEmpresaEnum.values()) {
			tipoEmpresaEnum[i++] = new SelectItem(empresaEnum.getId(), empresaEnum.getLabel());
		}
		return tipoEmpresaEnum;
	}

	public SelectItem[] getCidadesByEstado() {
		return cidadesByEstado;
	}

	public void setCidadesByEstado(final SelectItem[] cidadesByEstado) {
		this.cidadesByEstado = cidadesByEstado;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(final boolean editMode) {
		this.editMode = editMode;
	}

	public StreamedContent getFilePDF() {
		return filePDF;
	}

	public void setFilePDF(final StreamedContent filePDF) {
		this.filePDF = filePDF;
	}

	public String getProdutoSelectedLabel() {
		return produtoSelectedLabel;
	}

	public void setProdutoSelectedLabel(final String produtoSelectedLabel) {
		this.produtoSelectedLabel = produtoSelectedLabel;
	}

	public String getCnpjFormatado() {
		return cnpjFormatado;
	}

	public void setCnpjFormatado(final String cnpjFormatado) {
		this.cnpjFormatado = cnpjFormatado;
	}

}
