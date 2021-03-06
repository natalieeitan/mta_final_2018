package com.services;

import com.entities.Couple;
import com.entities.Supplier;
import com.entities.User;
import com.utilities.SqlQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierService {
	DataBaseService dataBaseService;

	public SupplierService() {
		dataBaseService = new DataBaseService();
	}

	public void connectWithCouple(String supplierId, String coupleId) {
		dataBaseService.connectCoupleAndSupplier(coupleId, supplierId);
	}

	public static List<Supplier> getAllSuppliers() {
		List<Supplier> suppliersList = new ArrayList<Supplier>();
		WedAppServer db = new WedAppServer();

		try {
			ResultSet rs = db.getDataFromDB(SqlQueries.GET_ALL_SUPPLIERS);
			while (rs.next()) {
				Supplier supplier = getSupplierFromResultSet(rs);
				suppliersList.add(supplier);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return suppliersList;
	}

	public static List<Supplier> getSuppliersListSuppliersIds(ResultSet rs) {
		List<Supplier> suppliersList = new ArrayList<Supplier>();
		try {
			while (rs != null && rs.next()) {
				Supplier supplier = getSupplierFromSupplierId(rs);
				if(supplier != null) {
					suppliersList.add(supplier);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return suppliersList;
	}

	private static Supplier getSupplierFromSupplierId(ResultSet rs) throws SQLException {
		String supplierId = rs.getString("SupplierID");
		Supplier supplier= getSupplierByID(supplierId);
		if(supplier == null){
			return null;
		}
		User user = UserService.getUserByID(supplierId);
		if(user == null){
			return supplier;
		}
		supplier.setFirstName(user.getFirstName());
		supplier.setLastName(user.getLastName());
		return supplier;
	}

	public static Supplier getSupplierFromResultSet(ResultSet rs) {
		String id;
		String venueName;
		String phone;
		int maxCapacity;
		int area;
		int minPrice;
		int style;
		String website;

		try {
			id = rs.getString("ID");
			venueName = rs.getString("VenueName");
			phone = rs.getString("PhoneNumber");
			maxCapacity = rs.getInt("MaxCapacity");
			area = rs.getInt("Area");
			minPrice = rs.getInt("MinPricePerPerson");
			style = rs.getInt("Style");
			website = rs.getString("Website");

			return new Supplier(id, venueName, phone, maxCapacity, area, minPrice, style, website);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public void pushSupplierToDB(Supplier supplier) {
		WedAppServer db = new WedAppServer();
		String query;
		try {
			if (db.checkIfIDExistInTable("Supplier", supplier.getID()) == 1) {
				query = SqlQueries.updateSupplierInTable(supplier);
				db.insertToDB(query);
			} else {
				query = SqlQueries.insertIntoSupplierTable(supplier);
				db.insertToDB(query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeConnection();
	}

	public static void insertEmptySupplierToDB(String id) {
		WedAppServer db = new WedAppServer();

		try {
			db.insertToDB(SqlQueries.insertEmptySupplierToTable(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Supplier getSupplierByID(String id) {
		WedAppServer db = new WedAppServer();
		try {
			ResultSet rs = db.getDataFromDB(SqlQueries.getSupplierByIDString(id));
			rs.next();
			Supplier supplier = getSupplierFromResultSet(rs);
			db.closeConnection();

			return supplier;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public List<Couple> getAllFitCouplesToSupplierBySupplier(Supplier supplier) {
		WedAppServer db = new WedAppServer();
		String query = SqlQueries.getFitCouplesToSupplier(supplier);
		List<Couple> coupleList;

		try {
			ResultSet rs = db.getDataFromDB(query);

			coupleList = CoupleService.getCouplesListFromResultSet(rs);

			db.closeConnection();

			return coupleList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<String> getAllCouplesConnectedToSupplierBySupplierId(String supplierId){
		WedAppServer db = new WedAppServer();
		String query = SqlQueries.getCouplesIdBySupplierIdFromCoupleSupplierTable(supplierId);
		List<String> couplesIdConnectedToSupplier = new ArrayList<>();
		ResultSet rs = db.getDataFromDB(query);
		try {
			while (rs != null && rs.next()) {
				couplesIdConnectedToSupplier.add(rs.getString("CoupleID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return couplesIdConnectedToSupplier;
	}
}
