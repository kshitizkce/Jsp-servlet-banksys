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
 * Servlet implementation class Depositeserv
 */
@WebServlet("/Depositeserv")
public class Depositeserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Depositeserv() {
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
		int accountnumber=Integer.parseInt(request.getParameter("an"));
		 float amount=Float.parseFloat(request.getParameter("am"));
		 request.setAttribute("amount", "RS."+amount + "has been deposited from account"+ "------->> "+accountnumber);
		
		Customeraction csr=new Customeractionimpl();
		csr.depositeamount(accountnumber,amount);
		
			request.getRequestDispatcher("Homepage.jsp").forward(request, response);
		

		}
	}


