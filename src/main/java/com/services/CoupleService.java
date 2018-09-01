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
    DataBaseServiceImpl dataBaseService = new DataBaseServiceImpl();

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
            Couple couple=CoupleService.getCoupleFromResultSet(rs);
            db.closeConnection();

            return couple;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public List<Supplier> getSuppliersLinkedByCoupleId(String coupleId) throws SQLException {
        return dataBaseService.getSuppliersLinkedByCoupleId(coupleId);
    }
}
