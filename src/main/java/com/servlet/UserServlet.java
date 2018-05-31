package com.servlet;

import com.entities.User;
import com.exceptions.EmailAlreadyExistException;
import com.services.DatabaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "servlet.UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
	DatabaseService dbService = new DatabaseService();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		if (request.getParameter("action_signup")!=null) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("userPass");
			String email = request.getParameter("userEmail");
			try {
				dbService.addUser(new User(firstName, lastName, email, password),true);
			} catch (EmailAlreadyExistException e) {
				//todo- need to preset message to user about email exist
			}
			response.sendRedirect("/client/html/onboarding-when.html");
		}
		else {
			response.sendRedirect("/client/html/onboarding-when.html");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
