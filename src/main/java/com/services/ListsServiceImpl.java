package com.services;

import com.entities.Couple;
import com.entities.Supplier;
import com.entities.User;
import com.exceptions.EmailAlreadyExistException;
import com.utilities.Season;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListsServiceImpl implements ManagementService {
	private static final List<Supplier> suppliersList = new ArrayList();
	private static final List<Couple> couplesList = new ArrayList();

	//statistics
	@Override
	public long getCouplesNumberBySeason(Season season) {
		return getCouples().stream()
				.filter(x -> x.getSeasonToMarry().equals(season))
				.count();
	}

	@Override
	public long getCouplesNumberByDayOfWeek(DayOfWeek dayOfWeek) {
		return getCouples().stream()
				.filter(x -> x.getDayOfWeek().equals(dayOfWeek))
				.count();
	}

	@Override
	public Couple findCoupleById(String id) {
		return getCouples().stream()
				.filter(x -> Objects.equals(x.getId(), id))
				.findAny()
				.orElse(null);
	}

	@Override
	public List<Couple> getCouples() {
		return couplesList;
	}

	@Override
	public List<Supplier> getSuppliers() {
		return suppliersList;
	}

	@Override
	public boolean isEmailAlreadyExist(String email) {
		Couple searchByEmailOnCouples = getCouples().stream()
				.filter(x -> x.getEmail().equals(email))
				.findAny()
				.orElse(null);
		Supplier searchByEmailOnSupplier = getSuppliers().stream()
				.filter(x -> x.getEmail().equals(email))
				.findAny()
				.orElse(null);

		if (searchByEmailOnCouples != null || searchByEmailOnSupplier != null)
			return true;

		return false;
	}

	@Override
	public String addUser(User user, boolean isCouple) throws EmailAlreadyExistException {
		if (isEmailAlreadyExist(user.getEmail())) {
			throw new EmailAlreadyExistException("this email already exist on our system");
		}
		if (isCouple) {
			couplesList.add(new Couple(user));
		} else {
			suppliersList.add(new Supplier(user));
		}
		return user.getId();
	}
}
