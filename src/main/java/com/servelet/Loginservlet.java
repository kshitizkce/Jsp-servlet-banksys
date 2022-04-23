package com.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.services.Signuploginimpl;
import com.services.Signuplogininterfaces;

/**
 * Servlet implementation class Loginservlet
 */
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("Uname");
		String psw=request.getParameter("Psw");
		
		Signuplogininterfaces sig=new Signuploginimpl();
		
		if(sig.adminlogin(un, psw)) {
			request.setAttribute("User", un);
			request.getRequestDispatcher("Homepage.jsp").forward(request, response);
			
		}else {
			request.setAttribute("message2", "USER NOT FOUND");
			request.getRequestDispatcher("Login.jsp").forward(request, response);

		}
		
		

		
	}

}
