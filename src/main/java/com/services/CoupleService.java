package com.services;

import com.entities.Couple;
import com.utilities.SqlQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoupleService {
    DataBaseServiceImpl dbService = new DataBaseServiceImpl();

    public List<Couple> getAllCouples() throws SQLException {
        List<Couple> couplesList = new ArrayList<Couple>();
        WedAppServer db = new WedAppServer();

        String id;
        String venueName;
        String phone;
        int maxCapacity;
        boolean isGarden;
        int area;
        int minPrice;
        int style;

        try {
            ResultSet rs = db.getDataFromDB(SqlQueries.GET_ALL_SUPPLIERS);
            while (rs.next()) {
                id = rs.getString("ID");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.closeConnection();
        return couplesList;
    }



}
