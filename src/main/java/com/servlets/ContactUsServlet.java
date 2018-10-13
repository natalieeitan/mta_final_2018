package com.servlets;

import com.entities.Couple;
import com.entities.Supplier;
import com.entities.User;
import com.services.ContactUsService;
import com.services.CoupleService;
import com.services.SupplierService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "servlets.ContactUsServlet", urlPatterns = {"/contactUs"})
public class ContactUsServlet extends HttpServlet {
    private ContactUsService contactUsService = new ContactUsService();
    private SupplierService supplierService = new SupplierService();
    private CoupleService coupleService = new CoupleService();

    private static final String WEB_INF_DASHBOARD_JSP = "/WEB-INF/dashboard.jsp";
    private static final String WEB_INF_COUPLES_JSP = "/WEB-INF/onboarding-couples.jsp";
    private static final String WEB_INF_SUPPLIERS_JSP = "/WEB-INF/onboarding-suppliers.jsp";


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        ServletContext ctx;
        String name;
        String phone;
        String email;
        String message;
        if (request.getParameter("action_contact") != null) {
            boolean isCouple = Boolean.valueOf(request.getParameter("weAreCouple"));
            name = request.getParameter("contactName");
            phone = request.getParameter("contactPhone");
            email = request.getParameter("contactEmail");
            message = request.getParameter("contactMessage");
            contactUsService.insertContactUsDetails(name, phone, email, message, isCouple);
            request.getRequestDispatcher(WEB_INF_DASHBOARD_JSP).forward(request, response);
        }
        else {
            ctx = getServletConfig().getServletContext();
            User user = (User) ctx.getAttribute("user");
            name = user.getFirstName() + " " + user.getLastName();
            email = user.getEmail();
            message = request.getParameter("contactMessage");


            if (request.getParameter("action_contactUsCouples") != null) {
                request.setAttribute("loggedName", getServletConfig().getServletContext().getAttribute("loggedName"));
                ctx.setAttribute("loggedName", getServletConfig().getServletContext().getAttribute("loggedName"));
                String id = getServletConfig().getServletContext().getAttribute("userId").toString();
                Couple couple = (Couple) ctx.getAttribute("couple");
                ctx.setAttribute("userId", id);
                ctx.setAttribute("couple", couple);
                request.setAttribute("userId", id);
                request.setAttribute("couple", couple);
                request.setAttribute("linkedSuppliers", coupleService.getSuppliersLinkedByCoupleId(user.getId()));
                contactUsService.insertContactUsDetails(name, null, email, message, true);
                request.getRequestDispatcher(WEB_INF_COUPLES_JSP).forward(request, response);
            }

            if (request.getParameter("action_contactUsSuppliers") != null) {
                Supplier supplier = (Supplier) ctx.getAttribute("supplier");
                phone = supplier.getPhone();
                ctx.setAttribute("supplier", supplier);
                ctx.setAttribute("userId", supplier.getId());
                request.setAttribute("supplier", supplier);
                String supplierId = ctx.getAttribute("userId").toString();
                List<Couple> potentialCouplesForConnection = null;
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
                contactUsService.insertContactUsDetails(name, phone, email, message, false);
                request.getRequestDispatcher(WEB_INF_SUPPLIERS_JSP).forward(request, response);
            }
        }
    }
}
