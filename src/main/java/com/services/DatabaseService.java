package com.services;

import com.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by natalieeitan on 15/04/2018.
 */
public class DatabaseService {
	private static final List<User> usersList = new ArrayList();

	public static List <User> getInstance(){
		return usersList;
	}

	public long addUser(User user) {
		usersList.add(user);
		return user.getId();
	}
}
