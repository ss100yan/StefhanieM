package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigAndContext
 */
public class ServletConfigAndContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   /*
    * Servlets have access to both a Servlet Config and Servlet Context. A Servlet's
    * Config is unique to that servlet, which means that only that servlet has access
    * to its own unique config. The Servlet Context, on the other hand, is shared by
    * all servlets, so they all have access to the context. Note that the config
    * and context are really just maps which contain keys and values.
    * 
    * Where do we create these key-value pairs? In the web.xml.
    */
    public ServletConfigAndContext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * This is how we access our Servlet Config.
		 */
//		response.getWriter().append("The servlet config is: ").append(this.getInitParameter("My Servlet Config Param"));
		
		/*
		 * And this is how we access our Servlet Context:
		 */
		
		response.getWriter().append("The servlet context: ")
		.append(this.getServletContext()
				.getInitParameter("Servlet Context Param"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
