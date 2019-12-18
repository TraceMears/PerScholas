package com.perscholas.filters;

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

/**
 * Servlet Filter implementation class KeyFilter
 */
@WebFilter("/HomeServlet/SecurePage")
public class KeyFilter implements Filter {

    public KeyFilter() {
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String key = req.getParameter("key");
		
		if(key != null && key.equals("qwerty")) {
			chain.doFilter(request, response);
		} else {
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/WelcomePage.jsp").forward(request, (HttpServletResponse) response);
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
