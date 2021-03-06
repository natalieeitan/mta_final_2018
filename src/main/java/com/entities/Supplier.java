package com.entities;

import com.utilities.Area;
import com.utilities.Style;

public class Supplier extends User {
	private String userId;
	private String venueName;
	private String phone;
	private int maxCapacity;
	private int area;
	private int minPricePerPerson;
	private int style;
	private String website;

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

	public Supplier(String id) {
		this.id = id;
	}

	public Supplier(String userId, String venueName, String phone, int maxCapacity, int area,
			int minPricePerPerson,
			int style, String website) {
		super();
		this.userId = userId;
		this.venueName = venueName;
		this.phone = phone;
		this.maxCapacity = maxCapacity;
		this.area = area;
		this.minPricePerPerson = minPricePerPerson;
		this.style = style;
		this.website = website;
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

	public String getAreaName(int area) {
		return Area.getAreaByInt(area).getName();
	}

	public int getStyle() {
		return style;
	}

	public String getStyleName(int style) {
		return Style.getStyleByInt(style).getName();
	}

	public String getVenueName() {
		return venueName;
	}

	public String getPhone() {
		return phone;
	}

	public String getName() {
		return super.getFirstName() + " " + super.getLastName();
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
}
