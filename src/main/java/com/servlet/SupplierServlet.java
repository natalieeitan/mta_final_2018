package com.servlet;

import com.entities.Supplier;
import com.services.DataBaseServiceImpl;
import com.utilities.Area;
import com.utilities.Style;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlet.SupplierServlet", urlPatterns = { "/supplier" })
public class SupplierServlet extends HttpServlet {
	DataBaseServiceImpl dbService = new DataBaseServiceImpl();

	//todo - add city to supplier form
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("action_onboarding_suppliers") != null) {
			String venueName = request.getParameter("venueName");
			String phone = request.getParameter("phone");
			String maxCapacity = request.getParameter("maxCapacity");
			String isGarden = request.getParameter("isGarden");
			String area = request.getParameter("area");
			String minPrice = request.getParameter("minPrice");
			String style = request.getParameter("style");
			ServletContext ctx = getServletConfig().getServletContext();

			String id = getServletConfig().getServletContext().getAttribute("userId").toString();
			//todo - fix - Area.valueof not working, Style.valueOf not working
			//			Supplier supplier = new Supplier(id, venueName, phone, Integer.parseInt(maxCapacity), Boolean.valueOf(isGarden),
			//					Area.valueOf(area), Integer.parseInt(minPrice), Style.valueOf(style));
			Supplier supplier = new Supplier(id, venueName, phone, Integer.parseInt(maxCapacity), Boolean.valueOf(isGarden),
					Area.Center, Integer.parseInt(minPrice), Style.AnyStyle);
			dbService.insertSupplierToDb(supplier);
			//listService.updateSupplier(id,venueName, phone,maxCapacity,isGarden, area, minPrice, style);

			response.sendRedirect("/client/html/supplier-dashboard.html?id=" + id);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		ServletContext ctx = getServletConfig().getServletContext();
		if (request.getParameter("action_get_offers") != null) {
			String supplierId = ctx.getAttribute("userId").toString();

		}
	}
}
