package com.services;

import com.entities.Couple;
import com.entities.Supplier;
import com.utilities.Area;
import com.utilities.PriceRange;
import com.utilities.SqlQueries;
import com.utilities.Style;

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

//	public void insertSupplierToDb(Supplier supplier) {
//		dataBaseService.executeQuery(SqlQueries.insertIntoSupplierTable(supplier));
//	}

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

	public static List<Supplier> getSuppliersListSuppliersIds(ResultSet rs){
		List<Supplier> suppliersList = new ArrayList<Supplier>();
		try {
			while (rs!=null && rs.next()) {
				Supplier supplier = getSupplierFromSupplierId(rs);
				suppliersList.add(supplier);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return suppliersList;
	}

	private static Supplier getSupplierFromSupplierId(ResultSet rs) throws SQLException {
		String supplierId = rs.getString("SupplierID");
		return getSupplierByID(supplierId);
	}

	public static Supplier getSupplierFromResultSet(ResultSet rs) {
		String id;
		String venueName;
		String phone;
		int maxCapacity;
		int area;
		int minPrice;
		int style;

		try {
			id = rs.getString("ID");
			venueName = rs.getString("VenueName");
			phone = rs.getString("PhoneNumber");
			maxCapacity = rs.getInt("MaxCapacity");
			area = rs.getInt("Area");
			minPrice = rs.getInt("MinPricePerPerson");
			style = rs.getInt("Style");

			Supplier supplier = new Supplier(id, venueName, phone, maxCapacity, area, minPrice, style);

			return supplier;

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
			Supplier supplier = SupplierService.getSupplierFromResultSet(rs);
			db.closeConnection();

			return supplier;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Couple> getAllFitCouplesToSupplier(String supplierID){

	    List<Couple> fitCoupleList=new ArrayList<>();

	    try {
            List<Couple> allCoupleList=CoupleService.getAllCouples();

            for(Couple couple: allCoupleList)
            {
                if(checkIfCoupleFitsToSupplier(couple.getID(),supplierID))
                {
                    fitCoupleList.add(couple);
                }
            }

            return fitCoupleList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //the function checks if area, style, price range, and number of invites fit
	public boolean checkIfCoupleFitsToSupplier(String coupleID, String supplierID){

	    Supplier supplier=getSupplierByID(supplierID);
		Couple couple=CoupleService.getCoupleByID(coupleID);
        PriceRange pr=PriceRange.convertBitsToPriceRange(couple.getPricing());

        return checkIfCoupleAreaFitsToSupplier(couple.getArea(),supplier.getArea())
                & checkIfCoupleStyleFitsToSupplier(couple.getStyle(),supplier.getStyle())
                & pr.checkIfPriceExceedsFromRange(supplier.getMinPricePerPerson())
                & checkIfCoupleNumOfInvitesFitsToSupplier(couple.getNumOfInvites(),supplier.getMaxCapacity());

	}

	public boolean checkIfCoupleStyleFitsToSupplier(int coupleStyle, int supplierStyle){

	    int fits= coupleStyle&supplierStyle;

        if(fits==0)
            return false;

        return true;
    }

    public boolean checkIfCoupleAreaFitsToSupplier(int coupleArea, int supplierArea){

	    int fits= coupleArea&supplierArea;

        if(fits==0)
            return false;

        return true;
    }

    public boolean checkIfCoupleNumOfInvitesFitsToSupplier(int numOfInvites, int maxCapacity){

	    if(numOfInvites>maxCapacity)
	        return false;

	    return true;
    }

}
