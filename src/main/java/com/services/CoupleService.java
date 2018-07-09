package com.services;

import com.entities.Couple;
import com.utilities.SchedulingRange;


/**
 * Created by natalieeitan on 09/04/2018.
 */
public class CoupleService {
    ListsServiceImpl dbService = new ListsServiceImpl();

    public void updateSchedulingRange(String id, SchedulingRange schedulingRange)
    {
        Couple couple = dbService.findCoupleById(id);
        couple.setSchedulingRange(schedulingRange);
        //todo ?
    }
}
