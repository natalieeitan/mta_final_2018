package com.entities;

import com.utilities.Area;
import com.utilities.Style;

public class Supplier {
	private String userId;
	private String venueName;
	private String phone;
	private int maxCapacity;
	private boolean isGarden;
	//    private Cities city;
	private Area area;
	private int minPricePerPerson;
	private Style style;
//
//	public Supplier(User user) {
//		super(user.firstName, user.lastName, user.email, user.password);
//		this.setId(super.generateDb());
//	}

	public Supplier(String userId, String venueName, String phone, int maxCapacity, boolean isGarden, Area area, int minPricePerPerson,
			Style style) {
		this.userId = userId;
		this.venueName = venueName;
		this.phone = phone;
		this.maxCapacity = maxCapacity;
		this.isGarden = isGarden;
		this.area = area;
		this.minPricePerPerson = minPricePerPerson;
		this.style = style;
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

	public void setGarden(boolean garden) {
		isGarden = garden;
	}

	//    public void setCity(Cities city) {
	//        this.city = city;
	//    }

	public void setArea(Area area) {
		this.area = area;
	}

	public void setMinPricePerPerson(int minPricePerPerson) {
		this.minPricePerPerson = minPricePerPerson;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public int getMinPricePerPerson() {
		return minPricePerPerson;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public boolean isGarden() {
		return isGarden;
	}

	public Area getArea() {
		return area;
	}

	public Style getStyle() {
		return style;
	}

	public String getVenueName() {
		return venueName;
	}

	public String getPhone() {
		return phone;
	}

	public boolean getIsGarden() {
		return isGarden;
	}
}
