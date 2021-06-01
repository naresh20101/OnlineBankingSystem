package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DaoImp.UserDaoImp;
import com.Model.User;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImp userDaoImp=new UserDaoImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
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
		int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String cnic=request.getParameter("CNIC");
        String password=request.getParameter("password");
        User user=new User();
        user.setUserId(id);
        user.setUserName(name);
        user.setNIC(cnic);
        user.setUserPassword(password);
        int result=userDaoImp.updateUser(user);
        if (result > 0) {
			response.sendRedirect("ViewAllUsers.jsp");
		} else {
			response.getWriter().print("<h1>Error</h1>");
		}
	}

}
