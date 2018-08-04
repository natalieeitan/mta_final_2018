package com.entities;
import com.utilities.*;

import java.time.DayOfWeek;
import java.util.Date;

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


    public Couple(User user) {
        super(user.firstName, user.lastName, user.email, user.password);
        this.setId(super.generateDb());
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

    public Season getSeasonToMarry(){ return this.seasonToMarry; }
    public DayOfWeek getDayOfWeek(){ return this.daysToMarry; }

    public PriceRange getPricing() {
        return pricing;
    }

    public int getNumOfInvites() {
        return numOfInvites;
    }

    public void setNumOfInvites(int numOfInvites) {
        this.numOfInvites = numOfInvites;
    }
}
