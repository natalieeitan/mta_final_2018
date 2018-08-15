package com.utilities;

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

	//USERS Table UPDATE Queries
	public static final String UPDATE_USER_FIRST_NAME = "UPDATE WedAppServer.dbo.Users SET FirstName = '";
	public static final String UPDATE_USER_LAST_NAME = "UPDATE WedAppServer.dbo.Users SET LastName = '";
	public static final String UPDATE_USER_EMAIL = "UPDATE WedAppServer.dbo.Users SET Email = '";
	public static final String UPDATE_USER_PASSWORD = "UPDATE WedAppServer.dbo.Users SET Password = '";
	public static final String UPDATE_USER_EMAIL_VERIFIED = "UPDATE WedAppServer.dbo.Users SET EmailVerified = ";

	public static String insertIntoCoupleSupplierTable(String supplierId, String coupleId){
		return "INSERT INTO WedAppServer.dbo.CoupleSupplier (SupplierID, CoupleID) VALUES ('"+supplierId+"','"+coupleId+"');";
	}

	public static String insertIntoUserTable(User user){
		return "INSERT INTO WedAppServer.dbo.Users (ID, FirstName, LastName, Email, Password, Type) VALUES ('"+user.getId()+"','"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getType()+"');";
	}

//	public static String getCouplesOptinalConnectionsBySupplierId(String supplierId){
//		return "INSERT INTO WedAppServer.dbo.CoupleSupplier (SupplierId, CoupleId) VALUES ("+supplierId+","+coupleId+");";
//	}
}
