package com.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.Admin;
import com.services.Signuploginimpl;
import com.services.Signuplogininterfaces;


@WebServlet("/Signupservlet")
public class Signupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signupservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message1","Account Successfully created");
		String fn=request.getParameter("Fname");
		request.setAttribute("Admin1", fn);
		
		String ln=request.getParameter("Lname");
		String un=request.getParameter("Uname");
		String psw=request.getParameter("Psw");
		String id=request.getParameter("adminid");
		
		Admin ad=new Admin();
		ad.setFname(fn);
		ad.setLname(ln);
		ad.setUname(un);
		ad.setPassword(psw);
		ad.setId(id);
		
		Signuplogininterfaces sg=new Signuploginimpl();
		sg.adminsignup(ad);
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);




		
	}

}
