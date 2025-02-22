package com.perscholas.css_selectors.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/HomeServlet", "/HomeServlet/*"})
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String action = null;
		
		if(request.getPathInfo() == null || request.getServletPath().equals("/")) {
			action = request.getServletPath();
		}
		else {
			action = request.getServletPath() + request.getPathInfo();
		}
		
		try {
			switch(action) {
				case "/HomeServlet":
					showPageOne(request, response);
					break;
				case "/HomeServlet/showPage2":
					showPageTwo(request, response);
					break;
				case "/HomeServlet/xPath1":
					showXPathPageOne(request, response);
					break;
				case "/HomeServlet/xPath2":
					showXPathPageTwo(request, response);
					break;
				default:
					break;
			}
		}
		catch(Exception e){
			e.getMessage();
		}		
	}
	
	private void showPageOne(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/SeleniumCSS.html");
		rd.forward(request, response);
	}
	
	private void showPageTwo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/SeleniumCSS2.html");
		rd.forward(request, response);
	}
	
	private void showXPathPageOne(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/SeleniumXpathMain.jsp");
		rd.forward(request, response);
	}
	
	private void showXPathPageTwo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/SeleniumXpathSecond.jsp");
		rd.forward(request, response);
	}
	
}
