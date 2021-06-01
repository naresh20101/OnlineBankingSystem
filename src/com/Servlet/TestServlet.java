package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DaoImp.UserDaoImp;
import com.Model.User;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
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
		   
		   String email=request.getParameter("email");
	       String password=request.getParameter("password");
	       System.out.print(email);
	       
	       
	          UserDaoImp uDao=new UserDaoImp();
	       List<User> list=uDao.getUsers();
	       if(email!=null &&password!=null)
		   {
		      for(User user:list)
		      {
		        if(user.getUserName().equalsIgnoreCase(email) && user.getUserPassword().equalsIgnoreCase(password))
		         {
			         HttpSession session=request.getSession();  
			          session.setAttribute("user", user);
				  
		
			   response.sendRedirect("dashboard.jsp");
		         }
		        else {
		        	continue;
		        }
	}
		   }

}
}
