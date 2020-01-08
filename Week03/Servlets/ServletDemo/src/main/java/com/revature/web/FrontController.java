package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Let's first discuss the MVC design pattern. MVC stands for "Model View Controller".
 * This is a design pattern which can describe client-server communication, but is not
 * limited to such. It generally describes how the view communicates with the model
 * by way of the controller.
 * 
 * For example, in this application, we do, indeed have a model, view, and controller.
 * Our models are our Java Beans. They model real-world data. Our view is our presentation
 * layer, that layer being whatever the end user sees. Our controller is our web layer
 * which contains our servlets. This layer is responsible for mediating communication
 * between the view and the model.
 */

/*
 * The front controller design pattern is a design pattern in which there exists what
 * we refer to as a "front controller." This front controller is a servlet which
 * intercepts all requests from the client side. This provides a single point at which
 * we can validate that a user's request contains any necessary information.
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
