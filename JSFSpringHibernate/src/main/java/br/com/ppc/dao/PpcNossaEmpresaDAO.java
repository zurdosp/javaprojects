package br.com.ppc.dao;

import org.springframework.stereotype.Repository;

import br.com.ppc.controller.bean.NossaEmpresa;
/**
 *
 * @author Christian Oscar Tejada Pacheco
 *
 */
@Repository
public interface PpcNossaEmpresaDAO extends AbstractDAO<NossaEmpresa, Long> {

	public void evict(final NossaEmpresa nossaEmpresa);

}
