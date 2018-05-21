package com.services;

import com.entities.Couple;
import com.utilities.SchedulingRange;

import javax.xml.crypto.Data;

/**
 * Created by natalieeitan on 09/04/2018.
 */
public class CoupleService {
    DatabaseService dbService = new DatabaseService();

    public void updateSchedulingRange(String id, SchedulingRange schedulingRange)
    {
        Couple couple = dbService.findCoupleById(id);
        couple.setSchedulingRange(schedulingRange);
        dbService.updateCouple(couple);
    }
}
