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
    DataBaseService dataBaseService = new DataBaseService();

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
    public static Couple getCoupleWithNameFromResultSet(ResultSet rs){
       Couple couple= getCoupleFromResultSet(rs);

        try {
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            couple.setFirstName(firstName);
            couple.setLastName(lastName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return couple;
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

            return new Couple(id,schedulingRange,date,daysToMarry,preferredMonths,areas,styles,numOfInvites,pricing, false);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void pushAllCouplesToDB(Couple couple) {
        WedAppServer db = new WedAppServer();
        String query;
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
            Couple couple = getCoupleFromResultSet(rs);
            db.closeConnection();

            return couple;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public List<Supplier> getSuppliersLinkedByCoupleId(String coupleId){
        return dataBaseService.getSuppliersLinkedByCoupleId(coupleId);
    }

    public static List<Couple> getCouplesListFromResultSet(ResultSet rs) throws SQLException {
        List<Couple> coupleList=new ArrayList<>();

        while (rs!=null && rs.next())
        {
            Couple couple=getCoupleWithNameFromResultSet(rs);
            coupleList.add(couple);
        }

        return coupleList;
    }

    public void insertWeddingDetails(String id, String weddingDate, String weddingPlace, String weddingDetails, int usedPerfectMatch) {
        String query = SqlQueries.insertCoupleWeddingDetailsToCoupleWeddingTable(id, weddingDate, weddingPlace, weddingDetails, usedPerfectMatch);
        dataBaseService.executeQuery(query);
    }
}
