package com.servlet;

import com.entities.Couple;
import com.entities.Supplier;
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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "servlet.UserServlet", urlPatterns = { "/user" })
public class UserServlet extends HttpServlet {
	private DataBaseServiceImpl dbService = new DataBaseServiceImpl();
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
			if (isSupplier)
				newUser = new User(firstName, lastName, email, password, UserType.SUPPLIER);
			else
				newUser = new User(firstName, lastName, email, password, UserType.COUPLE);
			try {
				if (dbService.isEmailAlreadyExist(newUser.getEmail())) {
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
			if (isSupplier) {
				SupplierService.insertEmptySupplierToDB(newUser.getId());
				request.setAttribute("potentialCouples", null);
				request.getRequestDispatcher("/WEB-INF/onboarding-suppliers.jsp").forward(request, response);
			} else {
				CoupleService.insertEmptyCoupleToDB(newUser.getId());
				request.setAttribute("linkedSuppliers", null);
				request.getRequestDispatcher("/WEB-INF/onboarding-couples.jsp").forward(request, response);
			}
		}

		if (request.getParameter("action_signin") != null) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = dbService.getUserByEmailAndPassword(email, password);

			if (user == null) {
				//todo: fill case of error
				//error
			} else if (user.getType().equals(UserType.SUPPLIER)) {
				//send to supplier page
				ctx.setAttribute("userId", user.getId());
				List<Couple> potentialCouplesForConnection = supplierService
						.getAllFitCouplesIDsToSupplierBySupplierId(user.getId());
				request.setAttribute("potentialCouples", potentialCouplesForConnection);
				Supplier loggedSupplier = SupplierService.getSupplierByID(user.getId());
				ctx.setAttribute("supplier", loggedSupplier);
				request.setAttribute("supplier", loggedSupplier);
				request.getRequestDispatcher("/WEB-INF/onboarding-suppliers.jsp").forward(request, response);
			} else {
				//send to couple page
				try {
					request.setAttribute("linkedSuppliers", coupleService.getSuppliersLinkedByCoupleId(user.getId()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ctx.setAttribute("userId", user.getId());
				Couple loggedCouple = CoupleService.getCoupleByID(user.getId());
				ctx.setAttribute("couple", loggedCouple);
				request.setAttribute("couple", loggedCouple);
				request.getRequestDispatcher("/WEB-INF/onboarding-couples.jsp").forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("action_signin") != null) {

		}
	}
}
