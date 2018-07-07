package com.entities;
import com.utilities.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by natalieeitan on 09/04/2018.
 * just for test
 */
public class Couple extends User {
    private SchedulingRange schedulingRange;
    private DayOfWeek daysToMarry;

    private Date date; //specific Date
    private Season seasonToMarry; //season to marry
    private Area area; //areas to marry
    private Style styles;

    private int numOfInvites;
    private PriceRange pricing;

    private ArrayList<Integer> suppliersId;

//	public Couple(String firstName, String lastName, String email, String password) {
//		super(firstName, lastName, email, password);
//        suppliersId = new ArrayList<>();
//	}

    public Couple(User user) {
        super(user.firstName, user.lastName, user.email, user.password);
    }

    public void addSupplierIdToList(int id)
    {
        suppliersId.add(id);
    }


    public void setSchedulingRange(SchedulingRange schedulingRange) {
        this.schedulingRange = schedulingRange;
    }

    public void setDaysToMarry(DayOfWeek daysToMarry) {
        this.daysToMarry = daysToMarry;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSeasonToMarry(Season seasonToMarry) {
        this.seasonToMarry = seasonToMarry;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setStyles(Style styles) {
        this.styles = styles;
    }

    public void setPricing(PriceRange pricing) {
        this.pricing = pricing;
    }
}
