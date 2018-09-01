package com.services;

import com.entities.User;
import com.utilities.SqlQueries;
import com.utilities.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	//	List<User> usersList = EmployeeList.getCouplesList();

	//	public List<User> getAllEmployees() {
	//		return usersList;
	//	}

	public static List<User> getAllUsers() {
		List<User> usersList = new ArrayList<User>();
		WedAppServer db = new WedAppServer();

		String id;
		String firstName;
		String lastName;
		String email;
		String password;
		String type;

		try {
			ResultSet rs = db.getDataFromDB(SqlQueries.GET_ALL_USERS);
			while (rs.next()) {
				User user=getUserFromResultSet(rs);
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return usersList;
	}

	public static User getUserFromResultSet(ResultSet rs){
		String id;
		String firstName;
		String lastName;
		String email;
		String password;
		String type;
		UserType utype;

		try {
			id = rs.getString("ID");
			firstName = rs.getString("FirstName");
			lastName = rs.getString("LastName");
			email = rs.getString("Email");
			password = rs.getString("Password");
			type = rs.getString("Type");
			utype=UserType.valueOf(type);

			User user = new User(id, firstName, lastName, email, password, utype);

			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public static User getUserByID(String id){
		WedAppServer db = new WedAppServer();
		try {
			ResultSet rs = db.getDataFromDB(SqlQueries.getUserByIDString(id));
			rs.next();
			User user=UserService.getUserFromResultSet(rs);
			db.closeConnection();

			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User getUserByEmail(String email){
		WedAppServer db = new WedAppServer();
		try {
			ResultSet rs = db.getDataFromDB(SqlQueries.getUserByEmailString(email));
			rs.next();
			User user=UserService.getUserFromResultSet(rs);
			db.closeConnection();

			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void pushAllUsersToDB(List<User> users) {
		WedAppServer db = new WedAppServer();
		String query;
		for (User user : users) {
			try {
				if(db.checkIfIDExistInTable("Users",user.getId())==1) {
                    query=SqlQueries.updateUserInTable(user);
                    db.insertToDB(query);
				}
				else {
				    query=SqlQueries.insertIntoUserTable(user);
					db.insertToDB(query);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		db.closeConnection();
	}
}
