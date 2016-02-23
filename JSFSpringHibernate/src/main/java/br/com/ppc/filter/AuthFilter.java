package br.com.ppc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Christian Oscar Tejada Pacheco
 *
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.jsf"})
public class AuthFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

	public AuthFilter() {

	}

	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		try {
			logger.debug("Filtrando request.");
			// check whether session variable is set
			String loginURI = "/ppc/loginBean.jsf";
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			HttpSession session = req.getSession(false);
			String reqURI = req.getRequestURI();
			logger.debug("Validando uri: " + reqURI);
			if (validateRequest(reqURI, session, loginURI)) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath() + "/loginBean.jsf");
			}
		}
		catch(Throwable t) {
			logger.error("Erro filtrando request. ", t);
		}
	}

	private boolean validateRequest(final String reqURI, final HttpSession session, final String loginURI) {
//		if (reqURI.indexOf(loginURI) >= 0
//				|| reqURI.indexOf("javax.faces.resource") >= 0
//				|| session != null && session.getAttribute("usuarioSistema") != null){
//			return false;
//		}
		return true;
	}

	public void init(final FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}
}