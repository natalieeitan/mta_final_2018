package com.services;

import com.entities.Couple;
import com.entities.Supplier;
import com.utilities.SqlQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CoupleService {
    DataBaseServiceImpl dbService = new DataBaseServiceImpl();

    public static List<Couple> getAllCouples() throws SQLException {
        List<Couple> couplesList = new ArrayList<Couple>();
        WedAppServer db = new WedAppServer();

        try {
            ResultSet rs = db.getDataFromDB(SqlQueries.GET_ALL_COUPLES);
            while (rs.next()) {
                Couple couple=getCoupleFromResultSet(rs);
                couplesList.add(couple);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.closeConnection();
        return couplesList;
    }

    public static Couple getCoupleFromResultSet(ResultSet rs) {
        String id;
        int schedulingRange;
        Date date;
        int daysToMarry;
        int preferredMonths;
        int areas;
        int styles;
        int numOfInvites;
        int pricing;

        try {
            id = rs.getString("ID");
            schedulingRange=rs.getInt("SchedulingRange");
            date=rs.getDate("SpecificDate");
            daysToMarry=rs.getInt("DaysToMarry");
            preferredMonths=rs.getInt("PreferredMonths");
            areas=rs.getInt("Areas");
            styles=rs.getInt("Styles");
            numOfInvites=rs.getInt("NumberOfInvites");
            pricing=rs.getInt("PriceRange");

            Couple couple=new Couple(id,schedulingRange,date,daysToMarry,preferredMonths,areas,styles,numOfInvites,pricing);

            return couple;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void pushAllCouplesToDB(List<Couple> couples) {
        WedAppServer db = new WedAppServer();
        String query;
        for (Couple couple : couples) {
            try {
                if(db.checkIfIDExistInTable("Couple",couple.getID())==1) {
                    query=SqlQueries.updateCoupleInTable(couple);
                    db.insertToDB(query);
                }
                else {
                    query=SqlQueries.insertIntoCoupleTable(couple);
                    db.insertToDB(query);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        db.closeConnection();
    }

    public static void insertEmptyCoupleToDB(String id) {
        WedAppServer db = new WedAppServer();
        try {
            db.insertToDB(SqlQueries.insertEmptyCoupleToTable(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Couple getCoupleByID(String id){
        WedAppServer db = new WedAppServer();
        try {
            ResultSet rs = db.getDataFromDB(SqlQueries.getCoupleByIDString(id));
            rs.next();
            Couple couple=CoupleService.getCoupleFromResultSet(rs);
            db.closeConnection();

            return couple;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //todo: to debug - delete supplier and couples from db
    public void insertAllFitSuppliersToDB(String coupleID){
        List<String> fitSuppliersIDs=findAllFittingSuppliersIDsToDB(coupleID);
        String query;

        WedAppServer db= new WedAppServer();
        StringBuilder sb=new StringBuilder();

        sb.append(SqlQueries.insertToCoupleSupplierTableBeginString());

        for(String supplierID: fitSuppliersIDs)
        {
            sb.append(SqlQueries.insertToCoupleSupplierTableValuesString(coupleID,supplierID));
        }

        //delete last comma
        sb.delete(sb.length()-2,sb.length());
        sb.append(";");

        query=sb.toString();

        try {
            //delete all existing from db?

            db.insertToDB(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<String> findAllFittingSuppliersIDsToDB(String coupleID){
        List<String> fitSuppliersIDs=new ArrayList<String>();

        Couple couple=CoupleService.getCoupleByID(coupleID);
        List<Supplier> allSuppliers=SupplierService.getAllSuppliers();

        for(Supplier supplier:allSuppliers)
        {
            if(checkIfSupplierFits(couple,supplier))
            {
                fitSuppliersIDs.add(supplier.getID());
            }
        }

        return fitSuppliersIDs;
    }

    public boolean checkIfSupplierFits(Couple couple, Supplier supplier) {
        boolean fits = true;

        //check pricing fit
        if (couple.getPricing() <= supplier.getMinPricePerPerson())
            fits=false;
        //check area fit
        if((couple.getArea()&supplier.getArea())==0)
            fits=false;
        //check style fit
        if((couple.getStyle()&supplier.getStyle())==0)
            fits=false;
        //check number of invites
        if(couple.getNumOfInvites()>supplier.getMaxCapacity())
            fits=false;

        ///////todo:date fit checks

        return fits;
    }
}
