package com.services;

import com.entities.Couple;
import com.entities.Supplier;
import com.entities.User;
import com.exceptions.EmailAlreadyExistException;
import com.utilities.Season;

import java.time.DayOfWeek;
import java.util.List;

public interface ManagementService {
	List<Couple> getCouples();

	List<Supplier> getSuppliers();

	boolean isEmailAlreadyExist(String email);

	String addUser(User user, boolean isCouple) throws EmailAlreadyExistException;

	//statistics
	int getCouplesNumberBySeason(Season season);

	int getCouplesNumberByDayOfWeek(DayOfWeek dayOfWeek);

	Couple findCoupleById(String id);
}
