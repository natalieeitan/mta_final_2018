package com.servlets;

import com.entities.Couple;
import com.entities.Supplier;
import com.services.SupplierService;
import com.utilities.Area;
import com.utilities.Style;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "servlets.SupplierServlet", urlPatterns = { "/supplier" })
public class SupplierServlet extends HttpServlet {
	private SupplierService supplierService = new SupplierService();
	private static final String WEB_INF_SUPPLIERS_JSP = "/WEB-INF/onboarding-suppliers.jsp";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		List<Couple> potentialCouplesForConnection = null;
		ServletContext ctx = getServletConfig().getServletContext();
		String supplierId = ctx.getAttribute("userId").toString();
		Supplier supplier = null;
		if (request.getParameter("connectSupplierCouple") != null) {
			String coupleId = request.getParameter("coupleId");
			supplier = (Supplier) ctx.getAttribute("supplier");
			ctx.setAttribute("supplier", supplier);
			ctx.setAttribute("userId", supplierId);
			request.setAttribute("supplier", supplier);
			supplierService.connectWithCouple(supplierId, coupleId);

		} else if (request.getParameter("action_onboarding_suppliers") != null) {
			String venueName = request.getParameter("venueName");
			String phone = request.getParameter("phone");
			String maxCapacity = request.getParameter("maxCapacity");
			String area = request.getParameter("area");
			String minPrice = request.getParameter("minPrice");
			String style = request.getParameter("style");
			String webSite = request.getParameter("website");
			if(!webSite.contains("http://") || !webSite.contains("https://")){
				webSite = "http://"+webSite;
			}
			supplier = SupplierService.getSupplierByID(supplierId);
			supplier.setMaxCapacity(Integer.parseInt(maxCapacity));
			supplier.setArea(Area.valueOf(area).getBitValue());
			supplier.setMinPricePerPerson(Integer.parseInt(minPrice));
			supplier.setStyle(Style.valueOf(style).getBitValue());
			supplier.setPhone(phone);
			supplier.setVenueName(venueName);
			supplier.setWebsite(webSite);
			supplierService.pushSupplierToDB(supplier);
			ctx.setAttribute("supplier", supplier);
			ctx.setAttribute("userId", supplierId);
			request.setAttribute("supplier", supplier);
		}
		//collect couples from db to table in jsp
		potentialCouplesForConnection = supplierService
				.getAllFitCouplesToSupplierBySupplier(supplier);
		List<String> couplesConnected = supplierService.getAllCouplesConnectedToSupplierBySupplierId(supplierId);
		List<Couple> couplesAlreadyConnected = potentialCouplesForConnection.stream().filter(c -> couplesConnected.contains(c.getID())).collect(
				Collectors.toList());
		List<Couple> potentialCouples = potentialCouplesForConnection.stream().filter(c -> !couplesConnected.contains(c.getID())).collect(
				Collectors.toList());
		request.setAttribute("potentialCouples", potentialCouples);
		request.setAttribute("couplesAlreadyConnected", couplesAlreadyConnected);

		request.setAttribute("loggedName", getServletConfig().getServletContext().getAttribute("loggedName"));
		ctx.setAttribute("loggedName", getServletConfig().getServletContext().getAttribute("loggedName"));

		request.getRequestDispatcher(WEB_INF_SUPPLIERS_JSP).forward(request, response);
	}
}
