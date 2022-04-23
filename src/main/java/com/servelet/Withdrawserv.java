package com.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.services.Customeraction;
import com.services.Customeractionimpl;

/**
 */
@WebServlet("/Withdrawserv")
public class Withdrawserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdrawserv() {
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
		request.setAttribute("message3", "Deposite sucessfulll!!!");

		int accountnumber1=Integer.parseInt(request.getParameter("an1"));
		float amount1=Float.parseFloat(request.getParameter("am1"));
		 request.setAttribute("amount1", "RS."+amount1 + "has been withdraw from account" + "-------->> "+accountnumber1);

		
		Customeraction csr=new Customeractionimpl();
		csr.withdrawamount(accountnumber1, amount1);
		request.getRequestDispatcher("Homepage.jsp").forward(request, response);
	}

}
