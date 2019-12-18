package com.perscholas.JDBCLogin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
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
		//creating strings with value based on form submission 
		String login = request.getParameter("login");
		String register = request.getParameter("register");
		String delete = request.getParameter("delete");
		String update = request.getParameter("updatePass");
		
		
		//if else to choose which to redirect to based on form submission
		if ( login != null) {
			RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
			req.include(request, response);			
		}
		else if ( register != null) {
			RequestDispatcher req = request.getRequestDispatcher("Register.jsp");
			req.include(request, response);
			
		}
		else if ( delete != null) {
			RequestDispatcher req = request.getRequestDispatcher("Delete.jsp");
			req.include(request, response);
			
		}
		else if ( update != null) {
			RequestDispatcher req = request.getRequestDispatcher("UpdatePass.jsp");
			req.include(request, response);
			
		}
	}

}
