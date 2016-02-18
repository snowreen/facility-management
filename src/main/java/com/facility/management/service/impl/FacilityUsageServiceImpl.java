package com.facility.management.service.impl;

import com.facility.management.model.usage.FacilityUseSchedule;
import com.facility.management.model.usage.Inspection;
import com.facility.management.service.FacilityUsageService;

import java.util.Date;
import java.util.List;

public class FacilityUsageServiceImpl implements FacilityUsageService {

    @Override
    public Boolean isInUseDuringInterval(int facilityId, Date beginDate, Date endDate) {
        return null;
    }

    @Override
    public Boolean assignFacilityToUse(FacilityUseSchedule facilityUseSchedule) {
        return null;
    }

    @Override
    public Boolean vacateFacility(int facilityId) {
        return null;
    }

    @Override
    public List<Inspection> listInspections() {
        return null;
    }

    @Override
    public Double listActualUsage(int facilityId) {
        return null;
    }

    @Override
    public Double calcUsageRate(int facilityId) {
        return null;
    }

}
