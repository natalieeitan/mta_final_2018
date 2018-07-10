package com.services;

import com.entities.Couple;
import com.entities.Supplier;
import com.entities.User;
import com.exceptions.EmailAlreadyExistException;
import com.utilities.Season;

import java.time.DayOfWeek;
import java.util.List;


public class DataBaseServiceImpl implements ManagementService {
	@Override
	public List<Couple> getCouples() {
		return null;
	}

	@Override
	public List<Supplier> getSuppliers() {
		return null;
	}

	@Override
	public boolean isEmailAlreadyExist(String email) {
		return false;
	}

	@Override
	public String addUser(User user, boolean isCouple) throws EmailAlreadyExistException {
		return null;
	}

	@Override
	public int getCouplesNumberBySeason(Season season) {
		return 0;
	}

	@Override
	public int getCouplesNumberByDayOfWeek(DayOfWeek dayOfWeek) {
		return 0;
	}

	@Override
	public Couple findCoupleById(String id) {
		return null;
	}
}
