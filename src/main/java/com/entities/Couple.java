package com.entities;

import com.utilities.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Couple extends User {
	private String ID;
	private int schedulingRange;

	private Date date; //specific Date
	private int daysToMarry; //preferred days to marry
	private int preferredMonths;
	private int areas;  //areas to marry
	private int styles;  //preferred styles

	private int numOfInvites;
	private int pricing;

	private boolean coupleMarried;

	public Couple(User user, String userId, int schedulingRange, Date date, int daysToMarry,
			int preferredMonths, int areas, int styles, int numOfInvites, int pricing, boolean coupleMarried) {
		super(user);
		this.ID = userId;
		this.schedulingRange = schedulingRange;
		this.daysToMarry = daysToMarry;
		this.date = date;
		//this.seasonToMarry = seasonToMarry;
		this.preferredMonths = preferredMonths;
		this.areas = areas;
		this.styles = styles;
		this.numOfInvites = numOfInvites;
		this.pricing = pricing;
		this.coupleMarried = coupleMarried;
	}

	public Couple(String id) {
		this.ID = id;
	}

	public Couple(String userId, int schedulingRange, Date date, int daysToMarry,
			int preferredMonths, int areas, int styles, int numOfInvites, int pricing, boolean coupleMarried) {
		super();
		this.ID = userId;
		this.schedulingRange = schedulingRange;
		this.daysToMarry = daysToMarry;
		this.date = date;
		this.preferredMonths = preferredMonths;
		this.areas = areas;
		this.styles = styles;
		this.numOfInvites = numOfInvites;
		this.pricing = pricing;
		this.coupleMarried = coupleMarried;
	}

	public void setSchedulingRange(int schedulingRange) {
		this.schedulingRange = schedulingRange;
	}

	public void setDaysToMarry(int daysToMarry) {
		this.daysToMarry = daysToMarry;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setArea(int areas) {
		this.areas = areas;
	}

	public void setStyles(int styles) {
		this.styles = styles;
	}

	public void setPreferredMonths(int months) {
		this.preferredMonths = months;
	}

	public void setPricing(int pricing) {
		this.pricing = pricing;
	}

	public String getID() {
		return this.ID;
	}

	public String getName() {
		return super.getFirstName() +" ו"+ super.getLastName();
	}

	public int getDayOfWeek() {
		return this.daysToMarry;
	}

	public int getSchedulingRange() {
		return this.schedulingRange;
	}

	public Date getDate() {
		return this.date;
	}

	public String getDateString(Date date) {
		if(date==null){
			return "";
		}
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(date);
	}

	public int getPreferredMonths() {
		return this.preferredMonths;
	}

	public int getArea() {
		return this.areas;
	}

	public int getPricing() {
		return pricing;
	}

	public int getStyle() {
		return this.styles;
	}

	public String getStylesList(int style) {
		return Style.convertBitsToStyleList(style);
	}

	public String getAreasList(int areas) {
		return Area.convertBitsAreasList(areas);
	}

	public String getDaysList(int days) {
		return Day.convertBitsDaysList(days);
	}

	public String getMonthsList(int months) {
		return Month.convertBitsMonthsList(months);
	}

	public int getNumOfInvites() {
		return numOfInvites;
	}

	public void setNumOfInvites(int numOfInvites) {
		this.numOfInvites = numOfInvites;
	}

	public String getPriceRangeName(int priceRange) {
		return PriceRange.getPrinceRangeByInt(priceRange).getName();
	}

	public void setCoupleMarried(boolean coupleMarried) {
		this.coupleMarried = coupleMarried;
	}

	public boolean isCoupleMarried() {
		return coupleMarried;
	}
}
