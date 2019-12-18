package com.perscholas.JDBCLogin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginRedirectServlet
 */
@WebServlet("/LoginRedirectServlet")
public class LoginRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRedirectServlet() {
        super();
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//creating variables from the form submission
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		
		//saving boolean from validateLogin method using
		//the form submission outputs as method parameters
		boolean validation = LoginDAO.validateLogin(user, password);
		
		//if else to choose which to redirect to based on validateLogin return value
		if ( validation == true) {
			RequestDispatcher req = request.getRequestDispatcher("Welcome.jsp");
			req.include(request, response);			
		}
		//if validation fails then reload page
		else {
			RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
			req.include(request, response);			
		}
		
	}

}
