package com.services;

public class ContactUsService {
	private DataBaseService dataBaseService;

	public ContactUsService() {
		dataBaseService = new DataBaseService();
	}

	public void insertContactUsDetails(String fullName, String phone, String email, String details, boolean isSupplier) {
		dataBaseService.insertContactUsDetails(fullName, phone, email, details, isSupplier);
	}
}
