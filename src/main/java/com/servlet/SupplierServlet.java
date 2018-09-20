package com.servlet;

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

@WebServlet(name = "servlet.SupplierServlet", urlPatterns = { "/supplier" })
public class SupplierServlet extends HttpServlet {
	private SupplierService supplierService = new SupplierService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		List<Couple> potentialCouplesForConnection = null;
		ServletContext ctx = getServletConfig().getServletContext();
		String supplierId = ctx.getAttribute("userId").toString();
		if (request.getParameter("connectSupplierCouple") != null) {
			String coupleId = request.getParameter("coupleId");
			supplierService.connectWithCouple(supplierId, coupleId);
			potentialCouplesForConnection = supplierService
					.getAllFitCouplesIDsToSupplierBySupplierId(supplierId);

		} else if (request.getParameter("action_onboarding_suppliers") != null) {
			String venueName = request.getParameter("venueName");
			String phone = request.getParameter("phone");
			String maxCapacity = request.getParameter("maxCapacity");
			String area = request.getParameter("area");
			String minPrice = request.getParameter("minPrice");
			String style = request.getParameter("style");

			Supplier supplier = SupplierService.getSupplierByID(supplierId);
			supplier.setMaxCapacity(Integer.parseInt(maxCapacity));
			supplier.setArea(Area.valueOf(area).getBitValue());
			supplier.setMinPricePerPerson(Integer.parseInt(minPrice));
			supplier.setStyle(Style.valueOf(style).getBitValue());
			supplier.setPhone(phone);
			supplier.setVenueName(venueName);
			supplierService.pushSupplierToDB(supplier);
			ctx.setAttribute("supplier", supplier);
			ctx.setAttribute("userId", supplierId);
			request.setAttribute("supplier", supplier);
			potentialCouplesForConnection = supplierService
					.getAllFitCouplesIDsToSupplierBySupplier(supplier);

		}
		request.setAttribute("loggedName", getServletConfig().getServletContext().getAttribute("loggedName"));
		ctx.setAttribute("loggedName", getServletConfig().getServletContext().getAttribute("loggedName"));
		request.setAttribute("potentialCouples", potentialCouplesForConnection);
		request.getRequestDispatcher("/WEB-INF/onboarding-suppliers.jsp").forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
			ServletException, IOException {
		List<Couple> potentialCouplesForConnection = supplierService
				.getAllFitCouplesIDsToSupplierBySupplierId(getServletConfig().getServletContext().getAttribute("userId").toString());
		request.setAttribute("potentialCouples", potentialCouplesForConnection);
		request.getRequestDispatcher("/WEB-INF/onboarding-suppliers.jsp").forward(request, response);
	}
}
