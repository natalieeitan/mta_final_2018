package com.entities;
import com.utilities.*;

import java.time.DayOfWeek;
import java.util.Date;

/**
 * Created by natalieeitan on 09/04/2018.
 * just for test
 */
public class Couple {
    private String userId;
    private SchedulingRange schedulingRange;
    private DayOfWeek daysToMarry;

    private Date date; //specific Date
    private Season seasonToMarry; //season to marry
    private Area area; //areas to marry
    private Style styles;

    private int numOfInvites;
    private PriceRange pricing;

    public Couple(String userId, SchedulingRange schedulingRange, DayOfWeek daysToMarry, Date date, Season seasonToMarry,
            Area area, Style styles, int numOfInvites, PriceRange pricing) {
        this.userId = userId;
        this.schedulingRange = schedulingRange;
        this.daysToMarry = daysToMarry;
        this.date = date;
        this.seasonToMarry = seasonToMarry;
        this.area = area;
        this.styles = styles;
        this.numOfInvites = numOfInvites;
        this.pricing = pricing;
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
