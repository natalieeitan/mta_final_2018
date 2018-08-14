package com.services;

import com.entities.User;
import com.utilities.SqlQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserService {
//	List<User> usersList = EmployeeList.getCouplesList();

//	public List<User> getAllEmployees() {
//		return usersList;
//	}
	public List<User> getAllUsers()
	{
		List<User> usersList= new ArrayList<User>();
	    WedAppServer db = new WedAppServer();

	    String id;
	    String firstName;
	    String lastName;
	    String email;
	    String password;

        try {
            ResultSet rs=db.getDataFromDB("SELECT * FROM WedAppServer.dbo.Users");
            while (rs.next())
            {
                id=rs.getString("ID");
                firstName=rs.getString("FirstName");
                lastName=rs.getString("LastName");
                email=rs.getString("Email");
                password=rs.getString("Password");

                User user=new User(id,firstName,lastName,email,password);

                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.closeConnection();
        return usersList;
    }

    public void pushAllUsersToDB(List<User> users){
	    WedAppServer db=new WedAppServer();
        for (User user: users)
        {
            try {
                db.insertToDB(SqlQueries.UPDATE_USER_FIRST_NAME + user.getFirstName()
                        + SqlQueries.WHERE_ID + user.getId());
                db.insertToDB(SqlQueries.UPDATE_USER_LAST_NAME + user.getLastName()
                        + SqlQueries.WHERE_ID + user.getId());
                db.insertToDB(SqlQueries.UPDATE_USER_EMAIL + user.getEmail()
                        + SqlQueries.WHERE_ID + user.getId());
                db.insertToDB(SqlQueries.UPDATE_USER_PASSWORD + user.getPassword()
                        + SqlQueries.WHERE_ID + user.getId());
                db.insertToDB(SqlQueries.UPDATE_USER_EMAIL_VERIFIED + user.getEmailVerified()
                        + SqlQueries.WHERE_ID + user.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        db.closeConnection();
	}
}
