package com.entities;

public class Supplier extends User {
	private String userId;
	private String venueName;
	private String phone;
	private int maxCapacity;
	//    private Cities city;
	private int area;
	private int minPricePerPerson;
	private int style;
	//
	//	public Supplier(User user) {
	//		super(user.firstName, user.lastName, user.email, user.password);
	//		this.setId(super.generateDb());
	//	}

	public Supplier(User user, String userId, String venueName, String phone, int maxCapacity, int area,
			int minPricePerPerson,
			int style) {
		super(user);
		this.userId = userId;
		this.venueName = venueName;
		this.phone = phone;
		this.maxCapacity = maxCapacity;
		this.area = area;
		this.minPricePerPerson = minPricePerPerson;
		this.style = style;
	}

	public Supplier(String userId, String venueName, String phone, int maxCapacity, int area,
			int minPricePerPerson,
			int style) {
		super();
		this.userId = userId;
		this.venueName = venueName;
		this.phone = phone;
		this.maxCapacity = maxCapacity;
		this.area = area;
		this.minPricePerPerson = minPricePerPerson;
		this.style = style;
	}

	public String getID() {
		return userId;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	//    public void setCity(Cities city) {
	//        this.city = city;
	//    }

	public void setArea(int area) {
		this.area = area;
	}

	public void setMinPricePerPerson(int minPricePerPerson) {
		this.minPricePerPerson = minPricePerPerson;
	}

	public void setStyle(int style) {
		this.style = style;
	}

	public int getMinPricePerPerson() {
		return minPricePerPerson;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public int getArea() {
		return area;
	}

	public int getStyle() {
		return style;
	}

	public String getVenueName() {
		return venueName;
	}

	public String getPhone() {
		return phone;
	}
}
