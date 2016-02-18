package com.facility.management.service;

import com.facility.management.model.usage.FacilityUseSchedule;
import com.facility.management.model.usage.Inspection;

import java.util.Date;
import java.util.List;

public interface FacilityUsageService {

    public Boolean isInUseDuringInterval(int facilityId, Date beginDate, Date endDate);
    public Boolean assignFacilityToUse(FacilityUseSchedule facilityUseSchedule);
    public Boolean vacateFacility(int facilityId);
    public List<Inspection> listInspections();
    public Double listActualUsage(int facilityId);      //in hours
    public Double calcUsageRate(int facilityId);        //in hours

}
