package com.services;

import com.entities.Couple;

import java.sql.SQLException;
import java.util.List;

public class SupplierService {
	//CoupleSupplierLinks coupleSupplierLinks;
	DataBaseServiceImpl dataBaseService;

	public SupplierService() {
		dataBaseService = new DataBaseServiceImpl();
	}

	public List<Couple> getCouplesOptionalConnection(String supplierId) throws SQLException {
		//dataBaseService.getCouplesOptionalConnections(supplierId)
		//		Supplier loggedSupplier = managementService.getSupplierById(supplierId);
//		//return couples that want amount of invites that <= from supplier max capacity && not already connected with him
//		return managementService.getCouples().stream()
//				.filter(couple -> couple.getNumOfInvites() <= loggedSupplier.getMaxCapacity()
//						&& (coupleSupplierLinks.getCoupleSupplierLinksBySupplierId(supplierId) == null || !coupleSupplierLinks.getCoupleSupplierLinksBySupplierId(supplierId).contains(couple.getId())))
//				.collect(Collectors.toList());
		return null;
	}

	public void connectWithCouple(String supplierId, String coupleId) {
		dataBaseService.connectCoupleAndSupplier(coupleId, supplierId);
	}
}
