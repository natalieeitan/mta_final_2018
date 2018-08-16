//package com.services;
//
//import com.entities.Couple;
//import com.entities.Supplier;
//import com.entities.User;
//import com.exceptions.EmailAlreadyExistException;
//import com.utilities.Season;
//
//import java.time.DayOfWeek;
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class ListsServiceImpl implements ManagementService {
//	private static final List<Supplier> suppliersList = new ArrayList();
//	private static final List<Couple> couplesList = new ArrayList();
//	private static final List<User> usersList = new ArrayList<>();
//
//	public ListsServiceImpl() {
////		Couple c = new Couple(new User("aa", "bb", "adi@gmail.com", "1234"));
////		c.setDaysToMarry(DayOfWeek.THURSDAY);
////		c.setNumOfInvites(200);
////		Couple c1 = new Couple(new User("cc", "dd", "adi@gmail.com", "1234"));
////		c1.setDaysToMarry(DayOfWeek.WEDNESDAY);
////		c.setNumOfInvites(300);
////		Couple c2 = new Couple(new User("ddd", "ff", "adi@gmail.com", "1234"));
////		c2.setDaysToMarry(DayOfWeek.THURSDAY);
////		couplesList.add(c);
////		couplesList.add(c1);
////		couplesList.add(c2);
////		Supplier s = new Supplier(new User("ff","dd","as","123"));
////		s.setMaxCapacity(400);
////
////		suppliersList.add(s);
//	}
//
//	//statistics
//	@Override
//	public int getCouplesNumberBySeason(Season season) {
//		return getCouples().stream()
//				.filter(x -> x.getSeasonToMarry().equals(season))
//				.collect(Collectors.toList())
//				.size();
//	}
//
//	@Override
//	public int getCouplesNumberByDayOfWeek(DayOfWeek dayOfWeek) {
//		return getCouples().stream()
//				.filter(x -> x.getDayOfWeek().equals(dayOfWeek))
//				.collect(Collectors.toList())
//				.size();
//	}
//
//	@Override
//	public Couple getCoupleById(String id) {
//		return getCouples().stream()
//				.filter(x -> Objects.equals(x.getId(), id))
//				.findAny()
//				.orElse(null);
//	}
//
//	@Override
//	public Supplier getSupplierById(String id) {
//		return getSuppliers().stream()
//				.filter(x -> Objects.equals(x.getId(), id))
//				.findAny()
//				.orElse(null);
//	}
//
//	@Override
//	public void updateSupplier(String id, String venueName, String phone, String maxCapacity, String isGarden, String area,
//			String minPricePerPerson, String style) {
//		Supplier supplier = getSupplierById(id);
//		int index = suppliersList.indexOf(supplier);
//		supplier.setVenueName(venueName);
//		supplier.setPhone(phone);
//		//todo - fix this , not getting correct enum - getting exception
//		// supplier.setArea(Area.valueOf(area));
//		// supplier.setStyle(Style.valueOf(style));
//		supplier.setGarden(Boolean.parseBoolean(isGarden));
//		supplier.setMaxCapacity(Integer.parseInt(maxCapacity));
//		suppliersList.set(index, supplier);
//	}
//
//	@Override
//	public Optional<User> getUserByPasswordAndEmail(String password, String email) {
//		return getUsers().stream()
//				.filter(x -> (email.equals(x.getEmail()) && password.equals(x.getPassword())))
//				.findFirst();
//	}
//
//	@Override
//	public List<Couple> getCouples() {
//		return couplesList;
//	}
//
//	@Override
//	public List<Supplier> getSuppliers() {
//		return suppliersList;
//	}
//
//	@Override
//	public List<User> getUsers() {
//		return usersList;
//	}
//
//	@Override
//	public boolean isEmailAlreadyExist(String email) {
//		User searchByEmail =  Optional.ofNullable(getUsers())
//				.orElseGet(Collections::emptyList)
//				.stream()
//				.filter(x -> x.getEmail().equals(email))
//				.findAny()
//				.orElse(null);
//
//		if (searchByEmail != null)
//			return true;
//
//		return false;
//	}
//
//	@Override
//	public String addUser(User user, boolean isSupplier) throws EmailAlreadyExistException {
////		if (isEmailAlreadyExist(user.getEmail())) {
////			throw new EmailAlreadyExistException("this email already exist on our system");
////		}
////		if (isSupplier) {
////			Supplier newSupplier = new Supplier(user);
////			user.setId(newSupplier.getId());
////			usersList.add(user);
////			suppliersList.add(newSupplier);
////			return newSupplier.getId();
////		} else {
////			Couple newCouple = new Couple(user);
////			user.setId(newCouple.getId());
////			usersList.add(user);
////			couplesList.add(new Couple(user));
////			return newCouple.getId();
//		return " ";
////		}
//	}
//}
