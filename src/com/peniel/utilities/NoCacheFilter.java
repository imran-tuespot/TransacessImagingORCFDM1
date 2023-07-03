package com.peniel.utilities;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
@WebFilter(filterName = "noCacheFilter", urlPatterns = "/*", description = "Request  annotated filter")
public class NoCacheFilter implements Filter {

	/**
	 * doFilter Method.
	 * <p>
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpServletResponse res = (HttpServletResponse) response;
		
		/*String sessionid =null;
		try{
		    sessionid = request.getServletContext().getAttribute("sessionid").toString();

		}catch (NullPointerException npe) {
		    	sessionid = "NULLPOINTEREXCEPTION";
		 	}
		
	   if (sessionid == "NULLPOINTEREXCEPTION" || sessionid == null) {
		   RequestDispatcher rd = request.getRequestDispatcher("index.jsp?timeout");
			rd.forward(request, response); 

		 
	    }
	     else
	     {*/
	    	 res.setHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
				res.setHeader("Pragma", "no-cache");
				res.setDateHeader("Expires", -1);
			
	  // }
	   chain.doFilter(request, response);
}

	/**
	 * Initial Method.
	 * <p>
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param filterConfig
	 * @throws ServletException
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/**
	 * Destroy Method.
	 * <p>
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * </p>
	 */
	@Override
	public void destroy() {
	}
}
