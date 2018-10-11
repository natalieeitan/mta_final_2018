package com.servlets;

import com.services.ContactUsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlets.ContactUsServlet", urlPatterns = { "/contactUs" })
public class ContactUsServlet extends HttpServlet {
	private ContactUsService contactUsService = new ContactUsService();
	private static final String WEB_INF_DASHBOARD_JSP = "/WEB-INF/dashboard.jsp";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("action_contact") != null) {
			boolean isCouple = Boolean.valueOf(request.getParameter("weAreCouple"));
			String name = request.getParameter("contactName");
			String phone = request.getParameter("contactPhone");
			String email = request.getParameter("contactEmail");
			String message = request.getParameter("contactMessage");
			contactUsService.insertContactUsDetails(name, phone, email, message, isCouple);
		}
		request.getRequestDispatcher(WEB_INF_DASHBOARD_JSP).forward(request, response);
	}
}
