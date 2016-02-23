package br.com.ppc.service;

import java.util.List;

import br.com.ppc.controller.bean.NossaEmpresa;

/**
 *
 * @author Christian Oscar Tejada Pacheco
 *
 */
public interface IPpcNossaEmpresaService {

	/**
	 * FIXME. este servico tem que ir ao banco para recuperar dados.
	 * @return NossaEmpresa dados a empresa geradora de contratos.
	 */
	public NossaEmpresa getNossaEmpresa();

	public void salvarNossaEmpresa(final NossaEmpresa nossaEmpresa);

	public List<NossaEmpresa> getAll();

	public NossaEmpresa findNossaEmpresaById(final Long id);

	public void removeNossaEmpresa(final Long id);
}