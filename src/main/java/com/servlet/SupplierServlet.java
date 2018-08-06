package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servlet.SupplierServlet", urlPatterns = { "/supplier" })
public class SupplierServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		ServletContext ctx = getServletConfig().getServletContext();
		if (request.getParameter("action_get_offers") != null) {
			String supplierId = ctx.getAttribute("userId").toString();


		}
	}
}
