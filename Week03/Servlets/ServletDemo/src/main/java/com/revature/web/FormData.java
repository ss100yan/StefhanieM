package com.revature.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FormData
 */
public class FormData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Let's attempt to access the data that was sent back in the request body. In
		 * order to do so, we'll need to use the request object's getParameter method.
		 * Note that this method gets request parameters by NAME (the name of the
		 * element in the HTML document).
		 * 
		 * Note that you'll want to check that the request parameters are not null
		 * or empty strings.
		 */
		
		String userEmail = request.getParameter("userEmail");
		String password = request.getParameter("userPassword");
		
		if(userEmail.equals("jojo@star.com")) {
			
			/*
			 * Let's talk about session handling. Typically, when a user successfully
			 * logs in, they are granted a session. This session is then used to
			 * verify that this user has access to a certain resource.
			 * 
			 * We'll use an HttpSession to track user interactions with our
			 * website. We can use this session to store user information for later
			 * use and simply verify that the user has a session.
			 */
			
			HttpSession session = request.getSession();
			/*
			 * We can now store some session attributes for later use:
			 */
			
			session.setAttribute("User Email", userEmail);
			/*
			 * Note that we can later grab these session attributes and use them
			 * as we see fit. Note that this just returns an object:
			 */
			
			String email = (String) session.getAttribute("User Email");
		}
		
		
//		response.setContentType("text/plain");
//		PrintWriter write = response.getWriter();
//		write.write("The user email is: " + userEmail + " and the password is: " + password);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Just for demo purposes.
//		System.out.println(request.getRequestURI());
//		RequestDispatcher dispatchy = request.getRequestDispatcher("/views/how-to.html");
//		dispatchy.forward(request, response);
		
				doGet(request, response);
	}

}
