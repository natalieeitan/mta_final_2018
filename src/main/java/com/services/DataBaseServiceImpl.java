package com.services;

import com.entities.Couple;
import com.entities.Supplier;
import com.entities.User;
import com.exceptions.EmailAlreadyExistException;
import com.utilities.Season;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

import static com.utilities.SqlQueries.GET_ALL_COUPLES;

public class DataBaseServiceImpl implements ManagementService {

	private WedAppServer wedAppServer;

	public DataBaseServiceImpl(){
		this.wedAppServer = new WedAppServer();
	}
	@Override
	public List<Couple> getCouples() throws SQLException {
		ResultSet rs = this.wedAppServer.getDataFromDB(GET_ALL_COUPLES);
		//todo - convert to List<Couple>
		return null;
	}

	@Override
	public List<Supplier> getSuppliers() {
		return null;
	}

	@Override
	public List<User> getUsers() {
		return null;
	}

	@Override
	public boolean isEmailAlreadyExist(String email) {
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
	public Couple getCoupleById(String id) {
		return null;
	}

	@Override
	public Supplier getSupplierById(String id) {
		return null;
	}

	@Override
	public void updateSupplier(String id, String vanueName, String phone, String maxCapacity, String isGarden, String area,
			String minPricePerPerson, String style) {

	}

	@Override
	public Optional<User> getUserByPasswordAndEmail(String password, String email) {
		return null;
	}
}
