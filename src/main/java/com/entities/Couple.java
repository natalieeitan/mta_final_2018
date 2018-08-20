package com.entities;
import com.utilities.*;

import java.time.DayOfWeek;
import java.util.Date;

/**
 * Created by natalieeitan on 09/04/2018.
 * just for test
 */
public class Couple {
    private String ID;
    private int schedulingRange;

    private Date date; //specific Date
    //private Season seasonToMarry; //season to marry
    private int daysToMarry; //preferred days to marry
    private int months;
    private int areas;  //areas to marry
    private int styles;  //preferred styles

    private int numOfInvites;
    private PriceRange pricing;

    public Couple(String userId, int schedulingRange,  Date date,int daysToMarry,
            int areas, int styles, int numOfInvites, PriceRange pricing) {
        this.ID = userId;
        this.schedulingRange = schedulingRange;
        this.daysToMarry = daysToMarry;
        this.date = date;
        //this.seasonToMarry = seasonToMarry;
        this.areas = areas;
        this.styles = styles;
        this.numOfInvites = numOfInvites;
        this.pricing = pricing;
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

    //public void setSeasonToMarry(Season seasonToMarry) {
    //    this.seasonToMarry = seasonToMarry;
    //}

    public void setArea(int areas) {
        this.areas = areas;
    }

    public void setStyles(int styles) {
        this.styles = styles;
    }

    public void setPricing(PriceRange pricing) {
        this.pricing = pricing;
    }

   // public Season getSeasonToMarry(){ return this.seasonToMarry; }
    public int getDayOfWeek(){ return this.daysToMarry; }

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
