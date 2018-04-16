package com.entities;
import com.utilities.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by natalieeitan on 09/04/2018.
 */
public class Couple extends User {
    private Iterable<SchedulingRange> schedulingRange;
    private Iterable<DayOfWeek> daysToMarry;

    private Date date; //specific Date
    private Season seasonToMarry; //season to marry
    private Iterable<Area> area; //areas to marry
    private Iterable<Style> styles;

    private int numOfInvites;
    private PriceRange pricing;

    private ArrayList<Integer> suppliersId;

	public Couple(String firstName, String lastName, String email, String password) {
		super(firstName, lastName, email, password);
        suppliersId = new ArrayList<>();
	}

    public void addSupplierIdToList(int id)
    {
        suppliersId.add(id);
    }
}
