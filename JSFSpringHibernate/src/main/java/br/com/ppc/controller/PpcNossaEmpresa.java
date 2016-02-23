package br.com.ppc.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ppc.controller.bean.NossaEmpresa;
import br.com.ppc.service.IPpcNossaEmpresaService;
import br.com.ppc.util.PpcUtil;

/**
 * @author Christian Oscar Tejada Pacheco
 */
@ManagedBean(name="ppcNossaEmpresa")
@SessionScoped
public class PpcNossaEmpresa extends PpcController implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -436177356785354496L;

	private static final Logger logger = LoggerFactory.getLogger(PpcNossaEmpresa.class);

	private NossaEmpresa nossaEmpresa;

	@Autowired
	private IPpcNossaEmpresaService ppcNossaEmpresaService;

	public void mostrarNossaEmpresa() {
		logger.info("Monstrando dados da nossa empresa, metodo mostrarNossaEmpresa");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		setEditMode(true);
		try {
			logger.debug("Chamando ppcNossaEmpresa.jsf");
			ec.redirect(ec.getRequestContextPath() + "/ppcNossaEmpresa.jsf");
		} catch (IOException e) {
			logger.error("Erro ao tentar mostrar nossa empresa.", e);
		}
		logger.info("Fim metodo mostrarNossaEmpresa");
	}

	public PpcNossaEmpresa() {

	}

	public void getLogOut() {
		logger.info("Good bye!!");
	}

	public NossaEmpresa getNossaEmpresa() {
		if (nossaEmpresa == null) {
			nossaEmpresa = new NossaEmpresa();
		}
		return nossaEmpresa;
	}

	public void setNossaEmpresa(final NossaEmpresa nossaEmpresa) {
		this.nossaEmpresa = nossaEmpresa;
	}

	public void salvarNossaEmpresa() {
		logger.info("Salvando dados da NossaEmpresa");
		ppcNossaEmpresaService.salvarNossaEmpresa(nossaEmpresa);
		PpcUtil.getSession().setAttribute("nossaEmpresa", nossaEmpresa);
		setEditMode(false);
		logger.info("Fim do processo de salvar NossaEmpresa");
	}

}
