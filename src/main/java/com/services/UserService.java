package com.services;

import com.entities.User;
import com.utilities.SqlQueries;
import com.utilities.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

	public static User getUserFromResultSet(ResultSet rs) {
		String id;
		String firstName;
		String lastName;
		String email;
		String password;
		String type;
		UserType userType;

		try {
			id = rs.getString("ID");
			firstName = rs.getString("FirstName");
			lastName = rs.getString("LastName");
			email = rs.getString("Email");
			password = rs.getString("Password");
			type = rs.getString("Type");
			userType = UserType.valueOf(type);

			return new User(id, firstName, lastName, email, password, userType);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static User getUserByEmail(String email) {
		WedAppServer db = new WedAppServer();
		try {
			ResultSet rs = db.getDataFromDB(SqlQueries.getUserByEmailString(email));
			rs.next();
			User user = getUserFromResultSet(rs);
			db.closeConnection();

			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User getUserByID(String id){
		WedAppServer db = new WedAppServer();
		try {
			ResultSet rs = db.getDataFromDB(SqlQueries.getUserByID(id));
			rs.next();
			User user = getUserFromResultSet(rs);
			db.closeConnection();

			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
