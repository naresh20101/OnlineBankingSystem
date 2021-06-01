package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DaoImp.AccountDaoImp;
import com.Model.Account;

/**
 * Servlet implementation class DepositeAmount
 */
@WebServlet("/DepositeAmount")
public class DepositeAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;
      AccountDaoImp accountDaoImp=new AccountDaoImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositeAmount() {
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
		response.setContentType("text/html");
		Account account=new Account();
		Double deposite=Double.parseDouble(request.getParameter("deposite"));
		Double balance=Double.parseDouble(request.getParameter("balance"));
		Double remainingBalance=balance+deposite;
		
		account.setAccountId(Integer.parseInt(request.getParameter("id")));
		account.setAccountNo(Integer.parseInt(request.getParameter("accNo")));
		account.setAccountHolder(request.getParameter("name"));
		account.setPassword(request.getParameter("password"));
		account.setAddress(request.getParameter("address"));
		account.setBalance(remainingBalance);
		int result=accountDaoImp.updateAccount(account);
		if (result > 0) {
			response.sendRedirect("ViewAllAccounts.jsp");
		} else {
			response.getWriter().print("<h1>Error</h1>");
		}
	}

}
