package com.utilities;

public class SqlQueries {

	public static final String GET_ALL_COUPLES = "Select * From Couple";

	//General Expressions
	public static final String WHERE_ID = "' WHERE ID = ";

	//USERS Table UPDATE Queries
	public static final String UPDATE_USER_FIRST_NAME="UPDATE WedAppServer.dbo.Users SET FirstName = '";
	public static final String UPDATE_USER_LAST_NAME ="UPDATE WedAppServer.dbo.Users SET LastName = '";
    public static final String UPDATE_USER_EMAIL="UPDATE WedAppServer.dbo.Users SET Email = '";
    public static final String UPDATE_USER_PASSWORD="UPDATE WedAppServer.dbo.Users SET Password = '";
    public static final String UPDATE_USER_EMAIL_VERIFIED="UPDATE WedAppServer.dbo.Users SET EmailVerified = ";
}
