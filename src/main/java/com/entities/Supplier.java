package com.entities;

import com.utilities.Area;
import com.utilities.Style;

public class Supplier extends User {

    private String vanueName;
    private String phone;
    private int maxCapacity;
    private boolean isGarden;
//    private Cities city;
    private Area area;
    private int minPricePerPerson;
    private Style style;

    public Supplier(User user) {
        super(user.firstName, user.lastName, user.email, user.password);
        this.setId(super.generateDb());
    }

    public void setVanueName(String vanueName) {
        this.vanueName = vanueName;
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
}
