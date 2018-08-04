package com.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoupleSupplierLinks {
	//this map is to represent links between couple and supplier
	// key: string: will be userId of Couple
	// value: list of string: userId of supplier
	private Map<String, List<String>> map = new HashMap<>();

	public void linkCoupleAndSupplier(String coupleUserId, String supplierUserId){
		map.computeIfAbsent(coupleUserId, k -> new ArrayList<>()).add(supplierUserId);
	}

	public List<String> getCoupleSupplierLinksBySupplierId(String supplierId){
		return map.get(supplierId);
	}


}
