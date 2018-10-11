package com.services;

import com.entities.Supplier;
import com.entities.User;
import com.utilities.SqlQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DataBaseService {

	private WedAppServer wedAppServer;

	public DataBaseService() {
		this.wedAppServer = new WedAppServer();
	}

	public boolean isEmailAlreadyExist(String email) {
		int result = wedAppServer.checkIfEmailExistInUsersTable(email);

		if (result == 1)
			return true;

		return false;
	}

	public void insertUserToDb(User user) {
		wedAppServer.executeQuery(SqlQueries.insertIntoUserTable(user));
	}

	public void executeQuery(String query) {
		wedAppServer.executeQuery(query);
	}

	public void connectCoupleAndSupplier(String coupleId, String supplierId) {
		wedAppServer.executeQuery(SqlQueries.insertIntoCoupleSupplierTable(supplierId, coupleId));
	}

	public User getUserByEmailAndPassword(String email, String password) {
		return wedAppServer.getUserByEmailAndPassword(email, password);
	}

	public List<Supplier> getSuppliersLinkedByCoupleId(String coupleId) {
		ResultSet resultSet = wedAppServer.getDataFromDB(SqlQueries.getSuppliersIdByCoupleIdFromCoupleSupplierTable(coupleId));
		return SupplierService.getSuppliersListSuppliersIds(resultSet);
	}

	public void insertContactUsDetails(String fullName, String phone, String email, String details, boolean isCouple) {
		try {
			wedAppServer.insertToDB(SqlQueries.insertIntoContactUsTable(fullName, phone, email, details, isCouple ? 0 : 1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
