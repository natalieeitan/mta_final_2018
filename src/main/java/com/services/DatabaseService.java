package com.services;

import com.entities.Couple;
import com.entities.Supplier;
import com.entities.User;
import com.exceptions.EmailAlreadyExistException;

import java.util.ArrayList;
import java.util.List;

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

	public String addUser(User user, boolean isCouple) throws EmailAlreadyExistException {
		if(isEmailAlreadyExist(user.getEmail()))
		{
			throw new EmailAlreadyExistException("this email already exist on our system");
		}
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

	public void updateCouple(Couple couple) {
	//todo
	}

	private boolean isEmailAlreadyExist(String email){
		Couple searchByEmailOnCouples = getCouplesList().stream()
				.filter(x->x.getEmail().equals(email))
				.findAny()
				.orElse(null);
		Supplier searchByEmailOnSupplier = getSuppliersList().stream()
				.filter(x->x.getEmail().equals(email))
				.findAny()
				.orElse(null);

		if (searchByEmailOnCouples!=null||searchByEmailOnSupplier!=null)
			return true;

		return false;
	}
}
