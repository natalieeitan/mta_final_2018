package com.servlet;

import com.entities.User;
import com.exceptions.EmailAlreadyExistException;
import com.services.CoupleService;
import com.services.DataBaseServiceImpl;
import com.services.SupplierService;
import com.utilities.UserType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlet.UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
	DataBaseServiceImpl dbService = new DataBaseServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ServletContext ctx = getServletConfig().getServletContext();
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("action_signup")!=null) {
			User newUser;
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("userPass");
			String email = request.getParameter("userEmail");
			boolean isSupplier= Boolean.valueOf(request.getParameter("isSupplier"));
			if(isSupplier)
                newUser = new User(firstName, lastName, email, password, UserType.SUPPLIER);
			else
                newUser = new User(firstName, lastName, email, password, UserType.COUPLE);
			try {
				if(dbService.isEmailAlreadyExist(newUser.getEmail())){
					throw new EmailAlreadyExistException();
				}
				dbService.insertUserToDb(newUser);
				//save id on context to use on other servlets
				ctx.setAttribute("userId", newUser.getId());
				ctx.setAttribute("user", newUser);
			} catch (EmailAlreadyExistException e) {
				return;
				//todo- need to preset message to user about email exist
			}
			if(isSupplier){
                SupplierService.insertEmptySupplierToDB(newUser.getId());
				response.sendRedirect("/client/html/onboarding-suppliers.html");}
			else{
                CoupleService.insertEmptyCoupleToDB(newUser.getId());
				response.sendRedirect("/client/html/onboarding-couples.html");}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("action_signin")!=null){

		}
	}
}
