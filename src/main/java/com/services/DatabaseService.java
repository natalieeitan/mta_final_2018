package com.services;

import com.entities.Couple;
import com.entities.Supplier;
import com.entities.User;
import com.exceptions.EmailAlreadyExistException;
import com.utilities.SchedulingRange;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DatabaseService {
    private static final List<Supplier> suppliersList = new ArrayList();
    private static final List<Couple> couplesList = new ArrayList();

    public static List<Couple> getCouplesList() {
        return couplesList;
    }

    public static List<Supplier> getSuppliersList() {
        return suppliersList;
    }

    public String addUser(User user, boolean isCouple) throws EmailAlreadyExistException {
		if(isEmailAlreadyExist(user.getEmail()))
		{
			throw new EmailAlreadyExistException("this email already exist on our system");
		}
		if (isCouple) {
            couplesList.add(new Couple(user));
        } else {
            suppliersList.add(new Supplier(user));
        }
        return user.getId();
    }


    public Couple findCoupleById(String id) {
        return couplesList.stream()
                .filter(x -> x.getId() == id)
                .findAny()
                .orElse(null);
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
    public void updateCouple(Couple couple) {
        //todo
    }

    public void updateSupplier() {
    }
}
