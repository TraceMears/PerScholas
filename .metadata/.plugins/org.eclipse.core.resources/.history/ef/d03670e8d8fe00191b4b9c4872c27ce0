package com.perscholas.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perscholas.beans.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product p = new Product();
//		p = (Product) request.getAttribute("product1");
		p.setProductId("1");
		p.setProductName("Phone");
		p.setProductDescription("New xPhone 50");
		
		request.setAttribute("product1", p);
		
		request.getRequestDispatcher("/WEB-INF/views/UpdatePage.jsp").forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("pName");
		String desc = request.getParameter("pDesc");
		String id = request.getParameter("pid");
		
		Product p = new Product();
		
		p.setProductDescription(desc);
		p.setProductName(name);
		p.setProductId(id);
		
		System.out.println("Product ID " + p.getProductId() + " updated to:" + 
				"\nName: " + p.getProductName() + 
				"\nDescription: " + p.getProductDescription());
		
		doGet(request, response);
	}

}
