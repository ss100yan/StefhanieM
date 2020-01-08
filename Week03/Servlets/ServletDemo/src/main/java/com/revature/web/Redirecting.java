package com.revature.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Redirecting
 */
public class Redirecting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Redirecting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * There are several ways of handling redirecting users across your site. We
		 * are going to discuss two methods of doing so:
		 * 
		 * sendRedirect
		 * RequestDispatcher (this is not a Java method); forward() is the actual method
		 */
		
		//Let's first try to use sendRedirect(). This method comes from the response
		//object. It sends a response back to the client side and makes an entirely
		//new request for the requested resource and then sends yet another response
		//to the client side. This means that, ultimately, we get two responses and
		//requests. This is slower than using a Request Dispatcher, but it allows
		//you to redirect users to resources that are not hosted on your site.
		
//		response.sendRedirect("./redirect.html");
		
		//Let's now try using a RequestDispatcher. We can get a RequestDispatcher from
		//our request object. Note that when using a RequestDispatcher, we never leave
		//leave the server side to redirect the user, so only request is made and only
		//one response is sent back the client. This is faster than using sendRedirect.
		//Note that the RequestDispatcher obscures the resource's location on your server.
		
		RequestDispatcher dispatchy = request.getRequestDispatcher("./views/redirect.html");
		dispatchy.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
