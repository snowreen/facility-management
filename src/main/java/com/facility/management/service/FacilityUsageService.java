package com.facility.management.service;

import com.facility.management.model.usage.Inspection;
import com.facility.management.model.usage.LeaseInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FacilityUsageService {

    public Boolean isInUseDuringInterval(int facilityId, Date beginDate, Date endDate);
    public Boolean assignFacilityToUse(LeaseInfo leaseInfo);
    public Boolean vacateFacility(int facilityId, Date vacateDate);
    public List<Inspection> listInspections(int facilityId);
    public Map<Integer, Integer> listActualUsage();           //usage in days for each facility
    public Map<Integer, Double> calcUsageRate();              //usage percentage (days used per year in percent)

}
