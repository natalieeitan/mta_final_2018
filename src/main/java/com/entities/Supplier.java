package com.entities;

import com.utilities.Area;
import com.utilities.Cities;
import com.utilities.Style;

// test
public class Supplier extends User {

    private String vanueName;
    private String phone;
    private String phone2;
    private int maxCapacity;
    private Boolean isGarden;
    private Cities city;
    private Area area;
    private int minPricePerPerson;
    private Style style;

    public Supplier(User user) {
        super(user.firstName, user.lastName, user.email, user.password);
    }
}
