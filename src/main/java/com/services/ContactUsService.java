package com.services;

public class ContactUsService {
	DataBaseServiceImpl dataBaseService = new DataBaseServiceImpl();

	public void insertContactUsDetails(String fullName, String phone, String email, String details, boolean isSupplier) {
		dataBaseService.insertContactUsDetails(fullName, phone, email, details, isSupplier);
	}
}
