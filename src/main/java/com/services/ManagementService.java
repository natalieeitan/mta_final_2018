package com.services;

import com.entities.Couple;
import com.entities.Supplier;
import com.entities.User;
import com.exceptions.EmailAlreadyExistException;
import com.utilities.Season;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

public interface ManagementService {
	List<Couple> getCouples();

	List<Supplier> getSuppliers();

	List<User> getUsers();

	boolean isEmailAlreadyExist(String email);

	String addUser(User user, boolean isSupplier) throws EmailAlreadyExistException;

	//statistics
	int getCouplesNumberBySeason(Season season);

	int getCouplesNumberByDayOfWeek(DayOfWeek dayOfWeek);

	Couple findCoupleById(String id);

	Supplier findSupplierById(String id);

	void updateSupplier(String id, String vanueName, String phone, String maxCapacity, String isGarden, String area, String minPricePerPerson, String style);

	Optional<User> getUserByPasswordAndEmail(String password, String email);
}
