package com.services;

import com.entities.Couple;
import com.entities.CoupleSupplierLinks;
import com.entities.Supplier;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class SupplierService {
	CoupleSupplierLinks coupleSupplierLinks;
	ManagementService managementService;

	public SupplierService() {
		coupleSupplierLinks = new CoupleSupplierLinks();
		//todo- replace with DB impl
		managementService = new ListsServiceImpl();
	}

	public List<Couple> getCouplesOptionalConnection(String supplierId) throws SQLException {
		Supplier loggedSupplier = managementService.getSupplierById(supplierId);
		//return couples that want amount of invites that <= from supplier max capacity && not already connected with him
		return managementService.getCouples().stream()
				.filter(couple -> couple.getNumOfInvites() <= loggedSupplier.getMaxCapacity()
						&& !coupleSupplierLinks.getCoupleSupplierLinksBySupplierId(supplierId).contains(couple.getId()))
				.collect(Collectors.toList());
	}

	public void connectWithCouple(String supplierId, String coupleId) {
		coupleSupplierLinks.linkCoupleAndSupplier(coupleId, supplierId);
	}
}
