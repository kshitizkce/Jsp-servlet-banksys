package com.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.Admin;
import com.model.Customer;
import com.services.Customeraction;
import com.services.Customeractionimpl;
import com.services.Signuploginimpl;
import com.services.Signuplogininterfaces;

/**
 * Servlet implementation class Customeraddserv
 */
@WebServlet("/Customeraddserv")
public class Customeraddserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customeraddserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Homepage.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message","Customer added Sucessfully");
		String fn=request.getParameter("fl");
		request.setAttribute("customer", fn);
		float cb=Float.parseFloat(request.getParameter("cb"));
		float ob=Float.parseFloat(request.getParameter("ob"));
		
		Customer cs=new Customer();
		cs.setFullName(fn);
		cs.setCurrentbalanace(cb);
		cs.setOpeningBalance(ob);
		
		
		Customeraction csr= new Customeractionimpl();
		csr.addcustomer(cs);
		request.getRequestDispatcher("Homepage.jsp").forward(request, response);




		
	}

	}


