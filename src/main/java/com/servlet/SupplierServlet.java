package com.servlet;

import com.entities.Supplier;
import com.entities.User;
import com.services.DataBaseServiceImpl;
import com.services.SupplierService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "servlet.SupplierServlet", urlPatterns = { "/supplier" })
public class SupplierServlet extends HttpServlet {
	DataBaseServiceImpl dbService = new DataBaseServiceImpl();
	SupplierService supplierService = new SupplierService();

	//todo - add city to supplier form
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("action_onboarding_suppliers") != null) {
			String venueName = request.getParameter("venueName");
			String phone = request.getParameter("phone");
			String maxCapacity = request.getParameter("maxCapacity");
			String area = request.getParameter("area");
			String minPrice = request.getParameter("minPrice");
			String style = request.getParameter("style");
			ServletContext ctx = getServletConfig().getServletContext();

			String id = getServletConfig().getServletContext().getAttribute("userId").toString();
			//todo - fix - Area.valueof not working, Style.valueOf not working
			//			Supplier supplier = new Supplier(id, venueName, phone, Integer.parseInt(maxCapacity), Boolean.valueOf(isGarden),
			//					Area.valueOf(area), Integer.parseInt(minPrice), Style.valueOf(style));
			Supplier supplier = new Supplier((User) ctx.getAttribute("user"),id, venueName, phone, Integer.parseInt(maxCapacity),
					1, Integer.parseInt(minPrice), 1);
			supplierService.insertSupplierToDb(supplier);
			//listService.updateSupplier(id,venueName, phone,maxCapacity,isGarden, area, minPrice, style);

			response.sendRedirect("/client/html/supplier-dashboard.html?id=" + id);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Supplier> allSuppliers = supplierService.getAllSuppliers();
		request.setAttribute("allSuppliers", allSuppliers); // Will be available as ${allSuppliers} in JSP
		request.getRequestDispatcher("/WEB-INF/couples-suggestions.jsp").forward(request, response);

	}
}
