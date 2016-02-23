package br.com.ppc.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ppc.controller.bean.NossaEmpresa;
import br.com.ppc.dao.PpcNossaEmpresaDAO;

/**
 * The Class PpcProspectoDAOImpl.
 *
 * @author Christian Oscar Tejada Pacheco
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class PpcNossaEmpresaDAOImpl extends AbstractHibernateDAOImpl<NossaEmpresa, Long>
		implements PpcNossaEmpresaDAO {

    /* (non-Javadoc)
     * @see br.com.ppc.dao.impl.AbstractHibernateDAOImpl#getDomainClass()
     */
    @Override
    protected Class<NossaEmpresa> getDomainClass() {
        return NossaEmpresa.class;
    }

    /*
     * (non-Javadoc)
     * @see br.com.ppc.dao.PpcNossaEmpresaDAO#evict(br.com.ppc.controller.bean.NossaEmpresa)
     */
    public void evict(final NossaEmpresa nossaEmpresa) {
        currentSession().evict(nossaEmpresa);
    }
}
