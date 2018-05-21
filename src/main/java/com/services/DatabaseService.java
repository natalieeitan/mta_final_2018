package com.services;

import com.entities.Couple;
import com.entities.Supplier;
import com.entities.User;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.utilities.SchedulingRange;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class DatabaseService {
	private static final List<Supplier> suppliersList = new ArrayList();
	private static final List<Couple> couplesList = new ArrayList();

	public static List<Couple> getCouplesList()
	{
		return couplesList;
	}
	public static List<Supplier> getSuppliersList(){
		return suppliersList;
	}

	public String addUser(User user, boolean isCouple) {
		if(isCouple)
		{
			couplesList.add((Couple) user);
		}
		else
		{
			suppliersList.add((Supplier) user);
		}
		return user.getId();
	}


	public Couple findCoupleById(String id) {
		return couplesList.stream()
				.filter(x->x.getId()==id)
				.findAny()
				.orElse(null);
	}
}
