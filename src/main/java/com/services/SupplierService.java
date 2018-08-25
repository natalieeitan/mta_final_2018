package com.services;

import com.entities.Couple;
import com.entities.Supplier;
import com.utilities.SqlQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierService {
	//CoupleSupplierLinks coupleSupplierLinks;
	DataBaseServiceImpl dataBaseService;

	public SupplierService() {
		dataBaseService = new DataBaseServiceImpl();
	}

	public List<Couple> getCouplesOptionalConnection(String supplierId) throws SQLException {
		//dataBaseService.getCouplesOptionalConnections(supplierId)
		//		Supplier loggedSupplier = managementService.getSupplierById(supplierId);
//		//return couples that want amount of invites that <= from supplier max capacity && not already connected with him
//		return managementService.getCouples().stream()
//				.filter(couple -> couple.getNumOfInvites() <= loggedSupplier.getMaxCapacity()
//						&& (coupleSupplierLinks.getCoupleSupplierLinksBySupplierId(supplierId) == null || !coupleSupplierLinks.getCoupleSupplierLinksBySupplierId(supplierId).contains(couple.getId())))
//				.collect(Collectors.toList());
		return null;
	}

	public void insertSupplierToDb(Supplier supplier) {
		dataBaseService.executeQuery(SqlQueries.insertIntoSupplierTable(supplier));
	}

	public void connectWithCouple(String supplierId, String coupleId) {
		dataBaseService.connectCoupleAndSupplier(coupleId, supplierId);
	}

	public List<Supplier> getAllSuppliers() {
		List<Supplier> suppliersList = new ArrayList<Supplier>();
		WedAppServer db = new WedAppServer();

		String id;
		String venueName;
		String phone;
		int maxCapacity;
		int area;
		int minPrice;
		int style;

		try {
			ResultSet rs = db.getDataFromDB(SqlQueries.GET_ALL_SUPPLIERS);
			while (rs.next()) {
				id = rs.getString("ID");
				venueName = rs.getString("VenueName");
				phone = rs.getString("PhoneNumber");
				maxCapacity = rs.getInt("MaxCapacity");
				area = rs.getInt("Area");
				minPrice = rs.getInt("MinPricePerPerson");
				style = rs.getInt("Style");

				Supplier supplier = new Supplier(id, venueName, phone, maxCapacity, area, minPrice, style);

				suppliersList.add(supplier);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return suppliersList;
	}

	public void pushAllSuppliersToDB(List<Supplier> suppliers) {
		WedAppServer db = new WedAppServer();
		String query;

		for (Supplier supplier : suppliers) {
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

	public static Supplier getSupplierByID(String id){
	    SupplierService db=new SupplierService();
	    List<Supplier> suppliers = db.getAllSuppliers();

	    for(Supplier supplier: suppliers)
        {
            if(id.equals(supplier.getID()))
                return supplier;
        }

        return null;
    }


}
