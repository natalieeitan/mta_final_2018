package com.services;

import com.entities.Couple;
import com.entities.Supplier;
import com.entities.User;
import com.exceptions.EmailAlreadyExistException;
import com.utilities.Season;
import com.utilities.SqlQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

public class DataBaseServiceImpl implements ManagementService {

	private WedAppServer wedAppServer;

	public DataBaseServiceImpl() {
		this.wedAppServer = new WedAppServer();
	}

	@Override
	public List<Couple> getCouples() throws SQLException {
		return CoupleService.getAllCouples();
	}

	@Override
	public List<Supplier> getSuppliers() throws SQLException{
		return SupplierService.getAllSuppliers();
	}

	@Override
	public List<User> getUsers() {
		return null;
	}

	@Override
	public boolean isEmailAlreadyExist(String email) {
		int result=wedAppServer.checkIfEmailExistInUsersTable(email);

		if(result==1)
			return true;

		return false;
	}

	@Override
	public String addUser(User user, boolean isSupplier) throws EmailAlreadyExistException {
		return null;
	}

	@Override
	public int getCouplesNumberBySeason(Season season) {
		return 0;
	}

	@Override
	public int getCouplesNumberByDayOfWeek(DayOfWeek dayOfWeek) {
		return 0;
	}

	@Override
	public Supplier getSupplierById(String id){return null;}

	@Override
	public Couple getCoupleById(String id) { return null; }

	@Override
	public void updateSupplier(String id, String venueName, String phone, String maxCapacity, String area,
			String minPricePerPerson, String style) {

	}

	@Override
	public Optional<User> getUserByPasswordAndEmail(String password, String email) {
		return null;
	}

	public void insertUserToDb(User user) {
		wedAppServer.executeQuery(SqlQueries.insertIntoUserTable(user));
	}

	public void executeQuery(String query){
		wedAppServer.executeQuery(query);
	}


	public void connectCoupleAndSupplier(String coupleId, String supplierId) {
		wedAppServer.executeQuery(SqlQueries.insertIntoCoupleSupplierTable(supplierId, coupleId));
	}

	public User getUserByEmailAndPassword(String email, String password){
		return wedAppServer.getUserByEmailAndPassword(email,password);
	}

	public List<Supplier> getSuppliersLinkedByCoupleId(String coupleId)  {
		ResultSet resultSet = wedAppServer.getDataFromDB(SqlQueries.getSuppliersIdByCoupleIdFromCoupleSupplierTable(coupleId));
		return SupplierService.getSuppliersListSuppliersIds(resultSet);
	}
}
