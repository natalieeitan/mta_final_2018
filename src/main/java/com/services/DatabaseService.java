package com.services;

import com.entities.Couple;
import com.entities.User;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.utilities.SchedulingRange;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by natalieeitan on 15/04/2018.
 */
public class DatabaseService {
	private static final List<User> usersList = new ArrayList();

	public static List <User> getInstance(){
		return usersList;
	}

	public String addUser(User user) {
        usersList.add(user);
		return user.getId();
	}


	public Couple findCoupleById(int id) {
		return null;
	}

	public void updateCouple(Couple couple) {
		//db.findById()
		//db.update(couple);
	}
}
