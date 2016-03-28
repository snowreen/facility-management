/*package com.facility.management.service.impl;

import com.facility.management.dal.FacilityUsageDAO;
import com.facility.management.model.usage.InspectionImpl;
import com.facility.management.model.usage.LeaseInfoImpl;
import com.facility.management.service.FacilityUsageService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class FacilityUsageServiceImpl implements FacilityUsageService {

    private FacilityUsageDAO facilityUsageDAO = new FacilityUsageDAO();

    @Override
    public Boolean isInUseDuringInterval(int facilityId, Date beginDate, Date endDate) {
        return facilityUsageDAO.isInUseDuringInterval(facilityId, beginDate, endDate);
    }

    @Override
    public Boolean assignFacilityToUse(LeaseInfoImpl leaseInfo) {
        return facilityUsageDAO.assignFacilityToUse(leaseInfo);
    }

    @Override
    public Boolean vacateFacility(int facilityId, Date vacateDate) {
        return facilityUsageDAO.vacateFacility(facilityId, vacateDate);
    }

    @Override
    public List<InspectionImpl> listInspections(int facilityId) {
        return facilityUsageDAO.getListOfInspections(facilityId);
    }

    @Override
    public Map<Integer, Integer> listActualUsage() {
        return facilityUsageDAO.getListOfActualUsage();
    }

    @Override
    public Map<Integer, Double> calcUsageRate() {
        return facilityUsageDAO.getUsageRate();
    }

}
*/