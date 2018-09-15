package com.servlet;

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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@WebServlet(name = "servlet.CoupleServlet", urlPatterns = {"/couple"})
public class CoupleServlet extends HttpServlet {
    private CoupleService coupleService = new CoupleService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        //get couple
        ServletContext ctx = getServletConfig().getServletContext();
        String id = getServletConfig().getServletContext().getAttribute("userId").toString();
        Couple couple = CoupleService.getCoupleByID(id);
        try {
            request.setAttribute("linkedSuppliers", coupleService.getSuppliersLinkedByCoupleId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //when
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

        CoupleService.pushAllCouplesToDB(couple);
        //todo: try not to refresh page when moving to JSP
        request.getRequestDispatcher("/WEB-INF/onboarding-couples.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
//        List<Supplier> allSuppliers = supplierService.getAllSuppliers();
//        request.setAttribute("allSuppliers", allSuppliers); // Will be available as ${allSuppliers} in JSP
//        request.getRequestDispatcher("/WEB-INF/couples-suggestions.jsp").forward(request, response);

    }
}
