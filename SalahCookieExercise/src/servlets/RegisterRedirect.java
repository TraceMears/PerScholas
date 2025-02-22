package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterRedirect
 */
@WebServlet("/RegisterRedirect")
public class RegisterRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterRedirect() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String first = request.getParameter("username");
		String last = request.getParameter("password");
		String dob = request.getParameter("dob");
		String username = request.getParameter("username");
		String pass1 = request.getParameter("password");
		String pass2 = request.getParameter("password2");
		
		if(!pass1.equals(pass2)) {
			RequestDispatcher req = request.getRequestDispatcher("Register.jsp");
			req.include(request, response);
		}
		Cookie cFirst = new Cookie("firstName", first);
		Cookie cLast = new Cookie("lastName", last);
		Cookie cUser = new Cookie("username", username);
		Cookie cPass = new Cookie("password", pass1);
		
		int dayOfYear = LocalDate.now().getDayOfYear();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY");
		LocalDate dobLD = LocalDate.parse(dob, dtf);
		int dayOfYearDOB = dobLD.getDayOfYear();
		int difference = 0;
		if(dayOfYearDOB < dayOfYear) {
			difference = dayOfYear - dayOfYearDOB;
		}
		else {
			difference = 365 - (dayOfYearDOB - dayOfYear);
		}
		Cookie cDiff = new Cookie("difference", Integer.toString(difference));
		
		RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
		req.include(request, response);
			
	}

}
