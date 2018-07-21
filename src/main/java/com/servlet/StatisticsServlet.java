package com.servlet;

import com.entities.User;
import com.exceptions.EmailAlreadyExistException;
import com.services.ListsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlet.UserServlet", urlPatterns = {"/user"})
public class StatisticsServlet extends HttpServlet {
	ListsServiceImpl dbService = new ListsServiceImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
