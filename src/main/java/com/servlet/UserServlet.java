package com.servlet;

import com.entities.User;
import com.exceptions.EmailAlreadyExistException;
import com.services.ListsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "servlet.UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
	ListsServiceImpl dbService = new ListsServiceImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		if (request.getParameter("action_signup")!=null) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("userPass");
			String email = request.getParameter("userEmail");
			//todo - pass true in this value when it's supplier
			boolean isSupplier= request.getParameter("isSupplier") != null;
			User newUser = new User(firstName, lastName, email, password);
			try {
				dbService.addUser(newUser,isSupplier);
			} catch (EmailAlreadyExistException e) {
				//todo- need to preset message to user about email exist
			}
			String newUserId = newUser.getId();
			if(isSupplier){
			response.sendRedirect("/client/html/onboarding-suppliers.html?id="+newUserId);}
			else{
				response.sendRedirect("/client/html/onboarding-couples.html?id="+newUserId);}
		//todo-use id's sent on url to know who to update on db
		}

		else if (request.getParameter("action_onboarding_suppliers")!=null) {
			String vanueName = request.getParameter("vanueName");
			String phone = request.getParameter("phone");
			String maxCapacity = request.getParameter("maxCapacity");
			String isGarden = request.getParameter("isGarden");
			String area = request.getParameter("area");
			String minPrice = request.getParameter("minPrice");
			String style = request.getParameter("style");
			dbService.updateSupplier();
            ;response.sendRedirect("/client/html/supplier-dashboard.html");
		}

		else {
			response.sendRedirect("/client/html/onboarding-couples.html");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
