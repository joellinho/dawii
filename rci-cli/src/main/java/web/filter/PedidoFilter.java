package web.filter;

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

import web.managedbean.LoginManaged;

/**
 * Filtro que previene ingresar a la parte de pedidos si es que no está logeado al sistema
 * @author Alvaro
 * 
 */

@WebFilter("/pedido/*")
public class PedidoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;
	        
    	LoginManaged lm = (LoginManaged) httpRequest.getSession().getAttribute("loginManaged");
    	 
    	//if (lm != null && lm.isLoggedIn()) {
    		chain.doFilter(request, response);
	    //} else {            
	        //httpResponse.sendRedirect(httpRequest.getContextPath() + "/auth/loginOrRegister.xhtml"); 
	    //} 
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
