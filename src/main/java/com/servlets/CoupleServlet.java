package com.servlets;

import com.entities.Couple;
import com.services.CoupleService;
import com.utilities.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@WebServlet(name = "servlets.CoupleServlet", urlPatterns = { "/couple" })
public class CoupleServlet extends HttpServlet {
	private CoupleService coupleService = new CoupleService();
	private static final String WEB_INF_COUPLES_JSP = "/WEB-INF/onboarding-couples.jsp";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		ServletContext ctx = getServletConfig().getServletContext();
		String id = getServletConfig().getServletContext().getAttribute("userId").toString();
		Couple couple = CoupleService.getCoupleByID(id);

		request.setAttribute("linkedSuppliers", coupleService.getSuppliersLinkedByCoupleId(id));
		if (request.getParameter("action_gotMarried") != null) {
			couple.setCoupleMarried(true);
			String dateStr = request.getParameter("dateMarried");
			String weddingPlace = request.getParameter("whereMarried");
			String weddingDetails = request.getParameter("detailsMarried");
			String byPerfectMatch = request.getParameter("byPerfectMatch");
			int usedPerfectMatch = byPerfectMatch.equals("true")?1:0;
			coupleService.insertWeddingDetails(id, dateStr, weddingPlace, weddingDetails,usedPerfectMatch);
		}

		//when
		else {
			if (request.getParameter("action_When") != null) {
				SchedulingRange whenType = SchedulingRange.valueOf(request.getParameter("whenRadio"));
				couple.setSchedulingRange(whenType.getBitValue());
				couple.setDate(null);
				couple.setPreferredMonths(0);
				couple.setDaysToMarry(0);
				switch (whenType) {
				case SEASON: {
					String[] monthValues = request.getParameterValues("chooseSeasonCB");
					if (monthValues != null)
						couple.setPreferredMonths(Month.convertStringArrayMonthToBits(monthValues));
					String[] daysValues = request.getParameterValues("chooseDaysCB");
					if (daysValues != null)
						couple.setDaysToMarry(Day.convertStringArrayDaysToBits(daysValues));
					break;
				}
				case SPECIFIC: {
					String dateStr = request.getParameter("specificDate");
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					try {
						java.util.Date date = df.parse(dateStr);
						couple.setDate(date);
					} catch (java.text.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				}
			}

			//where
			if (request.getParameter("action_Where") != null) {
				String[] areaValues = request.getParameterValues("AreaCB");
				if (areaValues != null)
					couple.setArea(Area.convertStringArrayAreasToBits(areaValues));
			}

			//style
			if (request.getParameter("action_Style") != null) {
				String[] styleValues = request.getParameterValues("styleCB");
				if (styleValues != null)
					couple.setStyles(Style.convertStringArrayStyleToBits(styleValues));
			}

			//budget
			if (request.getParameter("action_Budget") != null) {
				String peopleNumValue = request.getParameter("howManyPeople");
				if (peopleNumValue != null)
					couple.setNumOfInvites(Integer.parseInt(peopleNumValue));

				PriceRange price = null;
				String budgetValue = request.getParameter("price");
				if (budgetValue != null)
					price = PriceRange.valueOf(budgetValue);
				couple.setPricing(price.getBitValue());
			}
		}

		CoupleService.pushAllCouplesToDB(couple);
		request.setAttribute("loggedName", getServletConfig().getServletContext().getAttribute("loggedName"));
		ctx.setAttribute("loggedName", getServletConfig().getServletContext().getAttribute("loggedName"));
		ctx.setAttribute("userId", id);
		request.setAttribute("userId", id);
		request.setAttribute("couple", couple);

		request.getRequestDispatcher(WEB_INF_COUPLES_JSP).forward(request, response);
	}
}
