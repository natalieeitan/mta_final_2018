package com.servlet;

import com.entities.Supplier;
import com.services.DataBaseServiceImpl;
import com.services.SupplierService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "servlet.StatisticsServlet", urlPatterns = { "/statistics" })
public class StatisticsServlet extends HttpServlet {
	DataBaseServiceImpl dbService = new DataBaseServiceImpl();
	SupplierService supplierService = new SupplierService();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
