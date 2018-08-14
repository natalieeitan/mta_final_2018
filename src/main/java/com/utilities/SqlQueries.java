package com.utilities;

public class SqlQueries {

	public static final String GET_ALL_COUPLES = "Select * From Couple";
	public static final String GET_ALL_SUPPLIERS = "Select * From Supplier";
//	public static final String GET_NUM_OF_COUPLES_ON_THURSDAY = "Select  From Supplier";
//SELECT Count(CustomerName) FROM Customers
//	Where City = "Berlin";

	//General Expressions
	public static final String WHERE_ID = "' WHERE ID = ";

	//USERS Table UPDATE Queries
	public static final String UPDATE_USER_FIRST_NAME="UPDATE WedAppServer.dbo.Users SET FirstName = '";
	public static final String UPDATE_USER_LAST_NAME ="UPDATE WedAppServer.dbo.Users SET LastName = '";
    public static final String UPDATE_USER_EMAIL="UPDATE WedAppServer.dbo.Users SET Email = '";
    public static final String UPDATE_USER_PASSWORD="UPDATE WedAppServer.dbo.Users SET Password = '";
    public static final String UPDATE_USER_EMAIL_VERIFIED="UPDATE WedAppServer.dbo.Users SET EmailVerified = ";
}
