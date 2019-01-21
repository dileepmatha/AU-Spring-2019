package com.accolite.servletapp.filter;

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

@WebFilter("/FilterHandle")
public class FilterHandle implements Filter {

    public FilterHandle() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpSession session = ((HttpServletRequest) request).getSession();
//		if(session.getAttribute("check") == null)
//		{
//			((HttpServletResponse) response).sendRedirect("./index.jsp");
//		}
//		else {
			chain.doFilter(request, response);
//		}
		System.out.println(((HttpServletRequest)request).getRequestURL()+"?"+((HttpServletRequest)request).getQueryString());
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}