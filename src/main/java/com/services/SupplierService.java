package com.services;

import com.entities.CoupleSupplierLinks;

public class SupplierService {
	CoupleSupplierLinks coupleSupplierLinks;

	public SupplierService(){
		coupleSupplierLinks = new CoupleSupplierLinks();
	}
	public void connectWithCouple(String supplierId, String coupleId){
		coupleSupplierLinks.linkCoupleAndSupplier(coupleId, supplierId);
	}
}
