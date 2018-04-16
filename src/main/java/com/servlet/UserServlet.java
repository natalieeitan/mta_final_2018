package com.servlet;

import com.entities.User;
import com.services.DatabaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(
		name = "user"
)
public class UserServlet extends HttpServlet {
	DatabaseService dbService = new DatabaseService();


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("userName");
		if(firstName==null || firstName=="")
		{
			request.setAttribute("firstNameErrorMessage", "first name can't be empty");
			//request.getRequestDispatcher("/register.html").forward(request, response);
			response.getWriter().println("<html><body>Welcome!!!</body></html>");
		}
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("userPass");
		String email = request.getParameter("userEmail");
		dbService.addUser(new User(firstName,lastName,email,password));
		response.sendRedirect("/client/hello.html");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
