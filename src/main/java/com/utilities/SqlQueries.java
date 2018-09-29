package com.utilities;

import com.entities.Couple;
import com.entities.Supplier;
import com.entities.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SqlQueries {
	public static final String GET_ALL_COUPLES = "Select * From WedAppServer.dbo.Couple";
	public static final String GET_ALL_SUPPLIERS = "Select * From WedAppServer.dbo.Supplier";
	public static final String GET_ALL_USERS = "Select * From WedAppServer.dbo.Users";

	//General Expressions
	public static final String SUPPLIER_TABLE_NAME = "WedAppServer.dbo.Supplier";
	public static final String USER_TABLE_NAME = "WedAppServer.dbo.Users";
	public static final String COUPLE_TABLE_NAME = "WedAppServer.dbo.Couple";
	public static final String COUPLE_SUPPLIER_TABLE_NAME = "WedAppServer.dbo.CoupleSupplier";
	public static final String COUPLE_MARRIED_WEDDING_TABLE_NAME = "WedAppServer.dbo.CouplesWedding";
	public static final String NULL = "NULL";

//	//USERS Table UPDATE Queries
//	public static String updateUserInTable(User user) {
//		return SqlQueries.UPDATE_USER_FIRST_NAME + user.getFirstName()
//				+ "', LastName = '" + user.getLastName()
//				+ "', Email = '" + user.getEmail()
//				+ "', Password = '" + user.getPassword()
//				+ "', Type = '" + user.getType()
//				+ " WHERE ID = '" + user.getId() + "'";
//	}
	//SUPPLIER Table UPDATE Queries
	public static String updateSupplierInTable(Supplier supplier) {
		return SqlQueries.UPDATE_SUPPLIER_VENUE_NAME + supplier.getVenueName()
				+ "', PhoneNumber = '" + supplier.getPhone()
				+ "', MaxCapacity = " + supplier.getMaxCapacity()
				+ ", Area = " + supplier.getArea()
				+ ", MinPricePerPerson = " + supplier.getMinPricePerPerson()
				+ ", Style = " + supplier.getStyle()
				+ " WHERE ID = '" + supplier.getID() + "'";
	}
	public static final String UPDATE_SUPPLIER_VENUE_NAME = "UPDATE WedAppServer.dbo.Supplier SET VenueName = '";

	//COUPLE Table UPDATE Queries
	public static String updateCoupleInTable(Couple couple) {
		String query = SqlQueries.UPDATE_COUPLE_SCHEDULING_RANGE + couple.getSchedulingRange();

		if (couple.getDate() == null)
			query = query + ", SpecificDate = NULL";
		else {
			DateFormat destf = new SimpleDateFormat("yyyy-MM-dd");
			String date = destf.format(couple.getDate());
			query = query + ", SpecificDate = '" + date + "'";
		}

		return query + ", DaysToMarry = " + couple.getDayOfWeek()
				+ ", PreferredMonths = " + couple.getPreferredMonths()
				+ ", Areas = " + couple.getArea()
				+ ", Styles = " + couple.getStyle()
				+ ", NumberOfInvites = " + couple.getNumOfInvites()
				+ ", PriceRange = " + couple.getPricing()
				+ ", GotMarried = " + (couple.isCoupleMarried() ? "1" : "0")
				+ " WHERE ID = '" + couple.getID() + "'";
	}

	public static final String UPDATE_COUPLE_ID = "UPDATE WedAppServer.dbo.Couple SET ID = '";
	public static final String UPDATE_COUPLE_SCHEDULING_RANGE = "UPDATE WedAppServer.dbo.Couple SET SchedulingRange = ";

	public static final String insertEmptyCoupleToTable(String id) {
		return "INSERT INTO WedAppServer.dbo.Couple (ID, SchedulingRange, SpecificDate, DaysToMarry, PreferredMonths, Areas, Styles, " +
				"NumberOfInvites , PriceRange, GotMarried) VALUES ('"
				+ id + "', "
				+ NULL + ", "
				+ NULL + ", "
				+ NULL + ", "
				+ NULL + ", "
				+ NULL + ", "
				+ NULL + ", "
				+ NULL + ", "
				+ NULL + ", "
				+ 0 + ");";
	}

	public static String getUserByEmailString(String email) {
		return "SELECT * FROM WedAppServer.dbo.Users WHERE Email = '" + email + "'";
	}

	public static String getCoupleByIDString(String id) {
		return "SELECT * FROM " + SqlQueries.COUPLE_TABLE_NAME + " WHERE ID = '" + id + "'";
	}

	public static String getSupplierByIDString(String id) {
		return "SELECT * FROM " + SqlQueries.SUPPLIER_TABLE_NAME + " WHERE ID = '" + id + "'";
	}

	public static String insertEmptySupplierToTable(String id) {
		return "INSERT INTO " + SUPPLIER_TABLE_NAME
				+ " (ID, VenueName, PhoneNumber, MaxCapacity, Area, MinPricePerPerson, Style) VALUES ('"
				+ id + "', "
				+ NULL + ", "
				+ NULL + ", "
				+ NULL + ", "
				+ NULL + ", "
				+ NULL + ", "
				+ NULL + ");";
	}

	public static String insertIntoCoupleTable(Couple couple) {
		return "INSERT INTO WedAppServer.dbo.Couple (ID, SchedulingRange, SpecificDate, DaysToMarry, PreferredMonths, Areas, Styles, " +
				"NumberOfInvites , PriceRange) VALUES ('"
				+ couple.getID() + "',"
				+ couple.getSchedulingRange() + ", '"
				+ couple.getDate().getYear() + "-" + couple.getDate().getMonth() + "-" + couple.getDate().getDay() + "',"
				+ couple.getDayOfWeek() + ", "
				+ couple.getPreferredMonths() + ", "
				+ couple.getArea() + ", "
				+ couple.getStyle() + ", "
				+ couple.getNumOfInvites() + ", "
				+ couple.getPricing() + ");";
	}

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
				+ " (ID, VenueName, PhoneNumber, MaxCapacity, Area, MinPricePerPerson, Style) VALUES ('"
				+ supplier.getID() + "', '"
				+ supplier.getVenueName() + "', '"
				+ supplier.getPhone() + "', "
				+ supplier.getMaxCapacity() + ","
				+ supplier.getArea() + ", "
				+ supplier.getMinPricePerPerson() + ", "
				+ supplier.getStyle() + ");";
	}

	public static String getFitCouplesToSupplier(Supplier supplier) {
		return "SELECT * FROM " + COUPLE_TABLE_NAME
				+ " join WedAppServer.dbo.Users ON WedAppServer.dbo.Users.ID = Couple.ID WHERE NumberOfInvites <= " + supplier
				.getMaxCapacity()
				+ " AND Areas & " + supplier.getArea() + " != 0"
				+ " AND Styles & " + supplier.getStyle() + " != 0"
				+ " AND PriceRange >= " + PriceRange.convertIntToPriceRange(supplier.getMinPricePerPerson()).getBitValue()
				+ " AND GotMarried != 1;";
		}


	public static String getSuppliersIdByCoupleIdFromCoupleSupplierTable(String coupleId) {
		return "SELECT SupplierID FROM " + COUPLE_SUPPLIER_TABLE_NAME + " WHERE CoupleID='" + coupleId + "';";
	}

	public static String getCouplesIdBySupplierIdFromCoupleSupplierTable(String supplierId) {
		return "SELECT CoupleID FROM " + COUPLE_SUPPLIER_TABLE_NAME + " WHERE SupplierID='" + supplierId + "';";
	}

	public static String insertCoupleWeddingDetailsToCoupleWeddingTable(String id, String weddingDate, String weddingPlace, String details,
			int usedPerfectMatch) {
		return "INSERT INTO "+ COUPLE_MARRIED_WEDDING_TABLE_NAME+ " (ID, WeddingDate, WeddingPlace, Details, UsedPerfectMatch) VALUES ('"+id+"','"+weddingDate+"','" + weddingPlace+"','"+ details+"',"+ usedPerfectMatch+");";
	}
}
