package com.servlets;

import com.entities.Couple;
import com.entities.Supplier;
import com.entities.User;
import com.services.CoupleService;
import com.services.DataBaseService;
import com.services.SupplierService;
import com.utilities.UserType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "servlets.UserServlet", urlPatterns = { "/user" })
public class UserServlet extends HttpServlet {
	private static final String WEB_INF_DASHBOARD_JSP = "/WEB-INF/dashboard.jsp";
	private static final String WEB_INF_SUPPLIERS_JSP = "/WEB-INF/onboarding-suppliers.jsp";
	private static final String WEB_INF_COUPLES_JSP = "/WEB-INF/onboarding-couples.jsp";
	private DataBaseService dbService = new DataBaseService();
	private SupplierService supplierService = new SupplierService();
	private CoupleService coupleService = new CoupleService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ServletContext ctx = getServletConfig().getServletContext();
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("action_signup") != null) {
			User newUser;
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("userPass");
			String email = request.getParameter("userEmail");
			boolean isSupplier = Boolean.valueOf(request.getParameter("isSupplier"));
			//check if email is already exist in db
			if (dbService.isEmailAlreadyExist(email)) {

				request.setAttribute("isDuplicateMail", "כתובת האימייל כבר קיימת במערכת!");
				request.setAttribute("isCorrectLogin", " ");
				request.getRequestDispatcher(WEB_INF_DASHBOARD_JSP).forward(request, response);
				return;
			}
			if (isSupplier) {
				newUser = new User(firstName, lastName, email, password, UserType.SUPPLIER);
				request.setAttribute("loggedName", firstName + " " + lastName);
				ctx.setAttribute("loggedName", firstName + " " + lastName);

			} else {
				newUser = new User(firstName, lastName, email, password, UserType.COUPLE);
				request.setAttribute("loggedName", firstName + " ו" + lastName);
				ctx.setAttribute("loggedName", firstName + " ו" + lastName);
			}
			dbService.insertUserToDb(newUser);
			//save id on context to use on other servlets
			ctx.setAttribute("userId", newUser.getId());
			ctx.setAttribute("user", newUser);

			request.setAttribute("loggedName", firstName + " " + lastName);
			ctx.setAttribute("loggedName", firstName + " " + lastName);
			if (isSupplier) {
				SupplierService.insertEmptySupplierToDB(newUser.getId());
				request.setAttribute("potentialCouples", null);
				request.getRequestDispatcher(WEB_INF_SUPPLIERS_JSP).forward(request, response);
			} else {
				CoupleService.insertEmptyCoupleToDB(newUser.getId());
				request.setAttribute("linkedSuppliers", null);
				request.getRequestDispatcher(WEB_INF_COUPLES_JSP).forward(request, response);
			}
		}

		if (request.getParameter("action_logOff") != null)

		{
			HttpSession session = request.getSession();
			session.invalidate();
			request.setAttribute("isCorrectLogin", " ");
			request.setAttribute("isDuplicateMail", " ");
			request.getRequestDispatcher(WEB_INF_DASHBOARD_JSP).forward(request, response);
		}

		if (request.getParameter("action_signin") != null)

		{
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = dbService.getUserByEmailAndPassword(email, password);

			if (user == null) {
				request.setAttribute("isCorrectLogin", "שם משתמש או סיסמה לא נכונים!");
				request.setAttribute("isDuplicateMail", " ");
				request.getRequestDispatcher(WEB_INF_DASHBOARD_JSP).forward(request, response);

			} else if (user.getType().equals(UserType.SUPPLIER)) {
				//send to supplier page
				ctx.setAttribute("user", user);
				request.setAttribute("user", user);
				request.setAttribute("loggedName", user.getFirstName() + " " + user.getLastName());
				ctx.setAttribute("loggedName", user.getFirstName() + " " + user.getLastName());
				ctx.setAttribute("userId", user.getId());
				Supplier loggedSupplier = SupplierService.getSupplierByID(user.getId());
				ctx.setAttribute("supplier", loggedSupplier);
				request.setAttribute("supplier", loggedSupplier);

				//collect couples from db to table in jsp
				List<Couple> potentialCouplesForConnection = supplierService
						.getAllFitCouplesToSupplierBySupplier(loggedSupplier);
				List<String> couplesConnected = supplierService.getAllCouplesConnectedToSupplierBySupplierId(loggedSupplier.getID());
				List<Couple> couplesAlreadyConnected = potentialCouplesForConnection.stream()
						.filter(c -> couplesConnected.contains(c.getID()))
						.collect(
								Collectors.toList());
				List<Couple> potentialCouples = potentialCouplesForConnection.stream().filter(c -> !couplesConnected.contains(c.getID()))
						.collect(
								Collectors.toList());
				request.setAttribute("potentialCouples", potentialCouples);
				request.setAttribute("couplesAlreadyConnected", couplesAlreadyConnected);

				request.getRequestDispatcher(WEB_INF_SUPPLIERS_JSP).forward(request, response);
			} else {
				//send to couple page
				request.setAttribute("linkedSuppliers", coupleService.getSuppliersLinkedByCoupleId(user.getId()));
				ctx.setAttribute("user", user);
				request.setAttribute("user", user);
				request.setAttribute("loggedName", user.getFirstName() + " ו" + user.getLastName());
				ctx.setAttribute("loggedName", user.getFirstName() + " ו" + user.getLastName());
				ctx.setAttribute("userId", user.getId());
				Couple loggedCouple = CoupleService.getCoupleByID(user.getId());
				ctx.setAttribute("couple", loggedCouple);
				request.setAttribute("couple", loggedCouple);
				request.getRequestDispatcher(WEB_INF_COUPLES_JSP).forward(request, response);
			}
		}

	}
}
