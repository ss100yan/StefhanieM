package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */

/*
 * Filters are special types of servlets that intercept requests, typically to
 * perform some sort of authentication. They're often used to protect groups of
 * resources (e.g. all of the views in a certain folder) from unauthorized access.
 */
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		/*
		 * Generic ServletRequest/Responses do not have access to HttpSession methods,
		 * so you'll need to cast them. :(
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		/*
		 * Let's grab the user's existing session information. Note that you should
		 * pass "false" in as an argument to avoid creating a new session. You'll simply
		 * retrieve an existing session (or null if no session exists).
		 */
		
		HttpSession session = req.getSession(false);
		
		if(session == null) {
//			PrintWriter write = resp.getWriter();
//			resp.setContentType("text/plain");
//			write.write("Get outta here!");
			
			//Of course, this isn't a particularly useful thing to do when a user
			//doesn't have a session. Let's instead redirect the user to a different
			//page on our site if they don't have a session.
			
			resp.sendRedirect("../index.html");
			
		}else {
		
		// pass the request along the filter chain; note that response has been
			//committed in the above if block, so you only want to doFilter() if
			//response has not been committed.
		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
