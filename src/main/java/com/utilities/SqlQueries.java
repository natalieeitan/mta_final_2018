package com.utilities;

import com.entities.Supplier;
import com.entities.User;

public class SqlQueries {
	public static String INSERT_COUPLE_SUPPLIER_LINK = "INSERT INTO WedAppServer.dbo.CoupleSupplier VALUES (";
	public static final String GET_ALL_COUPLES = "Select * From Couple";
	public static final String GET_ALL_SUPPLIERS = "Select * From Supplier";
	//	public static final String GET_NUM_OF_COUPLES_ON_THURSDAY = "Select  From Supplier";
	//SELECT Count(CustomerName) FROM Customers
	//	Where City = "Berlin";

	//General Expressions
	public static final String WHERE_ID = "' WHERE ID = ";
	public static final String SUPPLIER_TABLE_NAME = "WedAppServer.dbo.Supplier";
	public static final String USER_TABLE_NAME = "WedAppServer.dbo.Users";

	//USERS Table UPDATE Queries
	public static final String UPDATE_USER_FIRST_NAME = "UPDATE WedAppServer.dbo.Users SET FirstName = '";
	public static final String UPDATE_USER_LAST_NAME = "UPDATE WedAppServer.dbo.Users SET LastName = '";
	public static final String UPDATE_USER_EMAIL = "UPDATE WedAppServer.dbo.Users SET Email = '";
	public static final String UPDATE_USER_PASSWORD = "UPDATE WedAppServer.dbo.Users SET Password = '";
	public static final String UPDATE_USER_EMAIL_VERIFIED = "UPDATE WedAppServer.dbo.Users SET EmailVerified = ";

	public static String insertIntoCoupleSupplierTable(String supplierId, String coupleId) {
		return "INSERT INTO WedAppServer.dbo.CoupleSupplier (SupplierID, CoupleID) VALUES ('" + supplierId + "','" + coupleId + "');";
	}

	public static String insertIntoUserTable(User user) {
		return "INSERT INTO WedAppServer.dbo.Users (ID, FirstName, LastName, Email, Password, Type) VALUES ('" + user.getId() + "','" + user
				.getFirstName() + "','" + user.getLastName() + "','" + user.getEmail() + "','" + user.getPassword() + "','" + user.getType()
				+ "');";
	}

	public static String insertIntoSupplierTable(Supplier supplier) {
		int isGardenBit = supplier.getIsGarden() ? 1 : 0;
		return "INSERT INTO " + SUPPLIER_TABLE_NAME
				+ " (ID, venueName, PhoneNumber, MaxCapacity, IsGarden, City, Area, MinPricePerPerson, Style) VALUES ('" + supplier.getVenueName()
				+ "','" + supplier.getPhone() + "'," + supplier.getMaxCapacity() + ",'" + isGardenBit + "', 'Tel Aviv' ,'" + supplier
				.getArea().getName() + "','" + supplier.getMinPricePerPerson() + "','" + supplier.getStyle().getName() + "');";

	}

	public static String isEmailAlreadyExistsOnUserTable(String email) {
		return "SELECT * FROM " + USER_TABLE_NAME + " WHERE Email='" + email + "';";
	}
	//	public static String getCouplesOptinalConnectionsBySupplierId(String supplierId){
	//		return "INSERT INTO WedAppServer.dbo.CoupleSupplier (SupplierId, CoupleId) VALUES ("+supplierId+","+coupleId+");";
	//	}
}
