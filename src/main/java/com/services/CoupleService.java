package com.services;

import com.entities.Couple;
import com.utilities.SqlQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CoupleService {
    DataBaseServiceImpl dbService = new DataBaseServiceImpl();

    public List<Couple> getAllCouples() throws SQLException {
        List<Couple> couplesList = new ArrayList<Couple>();
        WedAppServer db = new WedAppServer();

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
            ResultSet rs = db.getDataFromDB(SqlQueries.GET_ALL_COUPLES);
            while (rs.next()) {
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
                couplesList.add(couple);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.closeConnection();
        return couplesList;
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

}
