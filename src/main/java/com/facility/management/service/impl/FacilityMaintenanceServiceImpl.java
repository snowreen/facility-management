package com.facility.management.service.impl;

import java.util.List;

import com.facility.management.dal.FacilityMaintenanceDAO;
import com.facility.management.model.maintenance.Maintenance;
import com.facility.management.model.maintenance.MaintenanceCost;
import com.facility.management.model.maintenance.MaintenanceRequest;
import com.facility.management.service.FacilityMaintenanceService;

public class FacilityMaintenanceServiceImpl implements FacilityMaintenanceService {

    private FacilityMaintenanceDAO facilityMaintenanceDAO = new FacilityMaintenanceDAO();

    @Override
    public Boolean makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest) {
        return facilityMaintenanceDAO.createMaintenanceReq(maintenanceRequest);
    }

    @Override
    public Boolean scheduleMaintenance(Maintenance maintenance) {
        return facilityMaintenanceDAO.createMaintenanceSchedule(maintenance);
    }

    @Override
    public Double calcMaintenanceCostForFacility(MaintenanceCost maintenanceCost) {
        boolean isMaintenanceCostInserted = facilityMaintenanceDAO.createMaintenanceCost(maintenanceCost);
        if (isMaintenanceCostInserted) {
            return maintenanceCost.getTotalCost();
        }
        System.out.println("Maintenance Cost calculation failed !!!");
        return null;
    }

    @Override
    public Double calcProblemRateForFacility(int facilityId) {
        return facilityMaintenanceDAO.getProblemRateForFacility(facilityId);
    }

    @Override
    public Long calcDownTimeForFacility(int facilityId) {
        return facilityMaintenanceDAO.getDownTimeForFacility(facilityId);
    }

    @Override
    public List<MaintenanceRequest> listMaintRequests() {
        return facilityMaintenanceDAO.getListOfFacilityMaintenanceReq();
    }

    @Override
    public List<Maintenance> listMaintenance() {
        return facilityMaintenanceDAO.getListOfMaintenance();
    }

    @Override
    public List<String> listFacilityProblems(int facilityId) {
        return facilityMaintenanceDAO.getListOfFacilityProblems(facilityId);
    }

}
