package com.servlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.entities.Couple;
import com.entities.Supplier;
import com.services.CoupleService;
import com.services.SupplierService;
import com.utilities.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "servlet.SupplierServlet", urlPatterns = {"/couple"})
public class CoupleServlet extends HttpServlet {
    SupplierService supplierService = new SupplierService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        //get couple
        ServletContext ctx = getServletConfig().getServletContext();
        String id = getServletConfig().getServletContext().getAttribute("userId").toString();
        Couple couple = CoupleService.getCoupleByID(id);

        //when
        if (request.getParameter("action_When") != null) {
            SchedulingRange whenType = SchedulingRange.valueOf(request.getParameter("whenRadio"));
            couple.setSchedulingRange(whenType.getBitValue());
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
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
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
                couple.setArea(Style.convertStringArrayStyleToBits(styleValues));
        }

        //budget
        if (request.getParameter("action_Budget") != null) {
            String peopleNumValue = request.getParameter("howManyPeople");
            if (peopleNumValue != null)
                couple.setNumOfInvites(Integer.parseInt(peopleNumValue));

            PriceRange price = null;
            String budgetValue = request.getParameter("styleCB");
            if (budgetValue != null)
                price = PriceRange.valueOf(budgetValue);
            couple.setPricing(price.getBitValue());
        }

        CoupleService.pushAllCouplesToDB(couple);
        //todo: try not to refresh page when moving to JSP
        response.sendRedirect("client/html/onboarding-couples.html");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        List<Supplier> allSuppliers = supplierService.getAllSuppliers();
        request.setAttribute("allSuppliers", allSuppliers); // Will be available as ${allSuppliers} in JSP
        request.getRequestDispatcher("/WEB-INF/couples-suggestions.jsp").forward(request, response);

    }
}
