package com.utilities;

import com.entities.Supplier;
import com.entities.User;
import com.services.WedAppServer;

public class SqlQueries {
	public static String INSERT_COUPLE_SUPPLIER_LINK = "INSERT INTO WedAppServer.dbo.CoupleSupplier VALUES (";
	public static final String GET_ALL_COUPLES = "Select * From WedAppServer.dbo.Couple";
	public static final String GET_ALL_SUPPLIERS = "Select * From WedAppServer.dbo.Supplier";
	public static final String GET_ALL_USERS = "Select * From WedAppServer.dbo.Users";
	//	public static final String GET_NUM_OF_COUPLES_ON_THURSDAY = "Select  From Supplier";
	//SELECT Count(CustomerName) FROM Customers
	//	Where City = "Berlin";

	//General Expressions
	public static final String WHERE_ID = "' WHERE ID = ";
	public static final String COMMA_AND_APOSTROPHES = "', '";
	public static final String SUPPLIER_TABLE_NAME = "WedAppServer.dbo.Supplier";
	public static final String USER_TABLE_NAME = "WedAppServer.dbo.Users";
	public static final String COUPLE_TABLE_NAME = "WedAppServer.dbo.Couple";

	//USERS Table UPDATE Queries
	public static String updateUserInTable(User user) {
		return SqlQueries.UPDATE_USER_FIRST_NAME + user.getFirstName()
				+"', LastName = '"+ user.getLastName()
				+"', Email = '" + user.getEmail()
				+"', Password = '"+ user.getPassword()
				+"', Type = '"+user.getType()
				+ SqlQueries.WHERE_ID + user.getId();
	}
	public static final String UPDATE_USER_FIRST_NAME = "UPDATE WedAppServer.dbo.Users SET FirstName = '";
	public static final String UPDATE_USER_LAST_NAME = "UPDATE WedAppServer.dbo.Users SET LastName = '";
	public static final String UPDATE_USER_EMAIL = "UPDATE WedAppServer.dbo.Users SET Email = '";
	public static final String UPDATE_USER_PASSWORD = "UPDATE WedAppServer.dbo.Users SET Password = '";
	public static final String UPDATE_USER_EMAIL_VERIFIED = "UPDATE WedAppServer.dbo.Users SET EmailVerified = ";
	public static final String UPDATE_USER_TYPE="UPDATE WedAppServer.dbo.Users SET Type = ";

	//SUPPLIER Table UPDATE Queries
    public static String updateSupplierInTable(Supplier supplier) {
        return SqlQueries.UPDATE_SUPPLIER_VENUE_NAME+supplier.getVenueName()
                + "', PhoneNumber = '" + supplier.getPhone()
                + "', MaxCapacity = " + supplier.getMaxCapacity()
                + ", IsGarden = '" + supplier.getIsGarden()
                + "', Area = " + supplier.getArea()
                + ", MinPricePerPerson = " + supplier.getMinPricePerPerson()
                + ", Style = " + supplier.getStyle()
                + " WHERE ID = " + supplier.getID();
    }
	public static final String UPDATE_SUPPLIER_ID = "UPDATE WedAppServer.dbo.Supplier SET ID = '";
	public static final String UPDATE_SUPPLIER_VENUE_NAME = "UPDATE WedAppServer.dbo.Supplier SET VenueName = '";
	public static final String UPDATE_SUPPLIER_MAX_CAPACITY = "UPDATE WedAppServer.dbo.Supplier SET MaxCapacity = '";
	public static final String UPDATE_SUPPLIER_PHONE = "UPDATE WedAppServer.dbo.Supplier SET PhoneNumber = '";
	public static final String UPDATE_SUPPLIER_IS_GARDEN = "UPDATE WedAppServer.dbo.Supplier SET IsGarden = '";
	public static final String UPDATE_SUPPLIER_AREA = "UPDATE WedAppServer.dbo.Supplier SET Area = ";
	public static final String UPDATE_SUPPLIER_MIN_PRICE_PER_PERSON="UPDATE WedAppServer.dbo.Supplier SET MinPricePerPerson = ";
	public static final String UPDATE_SUPPLIER_STYLE="UPDATE WedAppServer.dbo.Supplier SET Style = ";

	public static String insertIntoCoupleSupplierTable(String supplierId, String coupleId) {
		return "INSERT INTO WedAppServer.dbo.CoupleSupplier (SupplierID, CoupleID) VALUES ('" + supplierId + "','" + coupleId + "');";
	}

	public static String insertIntoUserTable(User user) {
		return "INSERT INTO WedAppServer.dbo.Users (ID, FirstName, LastName, Email, Password, Type) VALUES ('"
                + user.getId() + "','"
                + user.getFirstName() + "','"
                + user.getLastName() + "','"
                + user.getEmail() + "','"
                + user.getPassword() + "','"
                + user.getType() + "');";
	}

	public static String insertIntoSupplierTable(Supplier supplier) {
	    return "INSERT INTO " + SUPPLIER_TABLE_NAME
				+ " (ID, VenueName, PhoneNumber, MaxCapacity, IsGarden, Area, MinPricePerPerson, Style) VALUES ('"
				+ supplier.getID() + "', '"
				+ supplier.getVenueName() + "', '"
				+ supplier.getPhone() + "', "
				+ supplier.getMaxCapacity() + ", '"
				+ supplier.getIsGarden()+ "', "
				+ supplier.getArea() + ", "
				+ supplier.getMinPricePerPerson() + ", "
				+ supplier.getStyle() + ");";
	}

	public static String isEmailAlreadyExistsOnUserTable(String email) {
		return "SELECT * FROM " + USER_TABLE_NAME + " WHERE Email='" + email + "';";
	}
	//	public static String getCouplesOptinalConnectionsBySupplierId(String supplierId){
	//		return "INSERT INTO WedAppServer.dbo.CoupleSupplier (SupplierId, CoupleId) VALUES ("+supplierId+","+coupleId+");";
	//	}
}
