package com.facility.management.service.impl;

import com.facility.management.model.maintenance.Maintenance;
import com.facility.management.model.maintenance.MaintenanceRequest;
import com.facility.management.service.FacilityMaintenanceService;

import java.util.Date;
import java.util.List;

public class FacilityMaintenanceServiceImpl implements FacilityMaintenanceService {

    @Override
    public Boolean makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest) {
        return null;
    }

    @Override
    public Boolean scheduleMaintenance(int maintenanceReqId, Date scheduledDateTime) {
        return null;
    }

    @Override
    public Double calcMaintenanceCostForFacility(int facilityId) {
        return null;
    }

    @Override
    public Double calcProblemRateForFacility(int facilityId) {
        return null;
    }

    @Override
    public Long calcDownTimeForFacility(int facilityId) {
        return null;
    }

    @Override
    public List<MaintenanceRequest> listMaintRequests() {
        return null;
    }

    @Override
    public List<Maintenance> listMaintenance() {
        return null;
    }

    @Override
    public List<String> listFacilityProblems(int facilityId) {
        return null;
    }

}
