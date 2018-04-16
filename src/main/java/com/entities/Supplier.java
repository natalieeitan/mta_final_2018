package com.entities;

import com.utilities.Area;
import com.utilities.Cities;
import com.utilities.Style;

public class Supplier extends User {

    private String vanueName;
    private String phone;
    private String phone2;
    private int maxCapacity;
    private Boolean isGarden; //גן או אולם
    private Cities city;
    private Area area;
    private int minPricePerPerson;
    private Style style;

    public Supplier(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }
}
