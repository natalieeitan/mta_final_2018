package com.services;

import com.entities.User;
import com.utilities.SqlQueries;
import com.utilities.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

	public static List<User> getAllUsers() {
		List<User> usersList = new ArrayList<User>();
		WedAppServer db = new WedAppServer();

		try {
			ResultSet rs = db.getDataFromDB(SqlQueries.GET_ALL_USERS);
			while (rs.next()) {
				User user = getUserFromResultSet(rs);
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return usersList;
	}

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
			User user = UserService.getUserFromResultSet(rs);
			db.closeConnection();

			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
