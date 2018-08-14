package com.servlet;

import com.entities.User;
import com.exceptions.EmailAlreadyExistException;
import com.services.ListsServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "servlet.UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
	ListsServiceImpl dbService = new ListsServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ServletContext ctx = getServletConfig().getServletContext();
		if (request.getParameter("action_signup")!=null) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("userPass");
			String email = request.getParameter("userEmail");
			boolean isSupplier= Boolean.valueOf(request.getParameter("isSupplier"));
			User newUser = new User(firstName, lastName, email, password);
			String id = null;
			try {
				id = dbService.addUser(newUser,isSupplier);
				ctx.setAttribute("userId", id);
			} catch (EmailAlreadyExistException e) {
				return;
				//todo- need to preset message to user about email exist
			}
			if(isSupplier){
				response.sendRedirect("/client/html/onboarding-suppliers.html?id="+id);}
			else{
				response.sendRedirect("/client/html/onboarding-couples.html?id="+id);}
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
			String id = request.getParameter("id");
			dbService.updateSupplier(id,vanueName, phone,maxCapacity,isGarden, area, minPrice, style);
			response.sendRedirect("/client/html/supplier-dashboard.html?id="+id);
		}

		else {
			response.sendRedirect("/client/html/onboarding-couples.html");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("action_signin")!=null){
			Optional<User> res = dbService.getUserByPasswordAndEmail(request.getParameter("password"),request.getParameter("email"));
			if(res.isPresent()){
				response.sendRedirect("/client/html/found.html");
			}
			else{
				response.sendRedirect("/client/html/not-found.html");
			}
		}
	}
}
