package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.SuperPet;

/*
 * How do we create a servlet? We simply extend the HttpServlet class in order to
 * make our class a user-defined servlet class.
 */
public class HelloWorldServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	/*
	 * GET vs POST
	 * ===========
	 * 
	 * GET and POST are HTTP methods/verbs. They have conventional uses. GET is used
	 * to request a resource from the server while POST is traditionally used to send
	 * data from the client side to the server side. There are also some differences
	 * in how GET and POST work under the hood:
	 * 
	 * 1)POST is more secure than GET because POST appends data to the body of the
	 *   request while GET appends data to the URL.
	 *   
	 * 2)POST can store a near limitless amount of data in the request body while GET
	 *   has a limit of a little over 2000 characters.
	 *   
	 *   
	 *GET and POST are just two of the HTTP verbs available to us. There are actually
	 *several more HTTP verbs:
	 *
	 *-GET: traditionally used to request a resource from the server
	 *-POST: traditionally used to send data from the client to the server
	 *-DELETE: traditionally used to handle deleting data (e.g. from your DB)
	 *-PUT: traditionally used to update data
	 *-PATCH: traditionally used to update data, but only partially
	 *-HEAD: traditionally used to request only the head of the response
	 *-OPTIONS: used to view the options a server provides
	 *-TRACE: typically use for debugging; it attempts to make contact with the server
	 *
	 *Which leads me to...our HTTP Request and Response bodies:
	 *
	 *All HTTP requests and responses have heads and bodies.
	 *
	 *An HTTP request head contains information about the HTTP verb, the request URI,
	 *request headers that have been added(e.g. CORS information, API keys)
	 *
	 *An HTTP request body contains the payload (what data is being transferred from
	 *the client to the server). For instance, your request parameters are located
	 *inside of the body.
	 *
	 *An HTTP response head contains information about the status code that is being
	 *returned. You can also add response headers (e.g. CORS policies, cookie 
	 *information).
	 *
	 *An HTTP response body contains the payload that is being transferred from the
	 *server to the client.
	 *
	 *As an aside: HTTP Status Codes
	 *
	 *There are various status codes that can be sent back in the response head. These
	 *have traditional uses:
	 *
	 *100 level status codes (used for info)
	 *200 level status codes (used to indicate that everything is OK; so your request
	 *was successful and you will receive the response you're looking for)
	 *300 level status codes (used for redirects)
	 *400 level status codes (used to indicate a client-side error)
	 *500 level status codes (used to indicate a server-side error)
	 */
	
	
	/*
	 * The doGet method is called during the service method if the Http Request from 
	 * the client is a GET request.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		/*
		 * We can use our servlet to send a response back to our client. We can send
		 * a wide variety of things back to our client:
		 * 
		 * -JSON
		 * -XML
		 * -HTML
		 * -plain text
		 * -css
		 */
		
		/*
		 * The getWriter method returns a PrintWriter that we can use to send
		 * output to the client side. We use it to write to our response body.
		 */
		PrintWriter writer = response.getWriter();
		
		/*
		 * We use this to specify what we are sending back to our client. In this
		 * case, we are sending plain text.
		 */
//		response.setContentType("text/plain"); //Plain Text
//		response.setContentType("text/html"); //HTML
		response.setContentType("application/json"); //JSON
		
		/*
		 * Write to our response body.
		 */
//		writer.write("Hello World!");
//		writer.write("<h1>Hi. This is not recommended, but you can write HTML from"
//				+ " the Java side.</h1><h3>It's</h3><h3>Really</h3><h3>Gross</h3>");
		
		/*
		 * The Object Mapper will convert our Java objects in JSON. We can also use
		 * it to marshal JSON received from the client side into Java objects.
		 */
		ObjectMapper imTheMap = new ObjectMapper();
		
		List<SuperPet> superPets = new ArrayList<>();
		superPets.add(new SuperPet(1, "Krypto", "spotted", "super dog", 100));
		superPets.add(new SuperPet(2, "Garfield", "oragne", "sassy cat", 5));
		superPets.add(new SuperPet(3, "Courage", "purple", "cowardice", 10));
		
		writer.write(imTheMap.writeValueAsString(superPets));
	}
	
	/*
	 * The doPost method is called during the service method if the Http Request from
	 * the client is a POST request.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}

}
