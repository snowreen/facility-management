/*package com.facility.management.service.impl;

import java.util.List;

import com.facility.management.dal.FacilityMaintenanceDAO;
import com.facility.management.model.maintenance.MaintenanceImpl;
import com.facility.management.model.maintenance.MaintenanceCostImpl;
import com.facility.management.model.maintenance.MaintenanceRequestImpl;
import com.facility.management.service.FacilityMaintenanceService;

public class FacilityMaintenanceServiceImpl implements FacilityMaintenanceService {

    private FacilityMaintenanceDAO facilityMaintenanceDAO = new FacilityMaintenanceDAO();

    @Override
    public Boolean makeFacilityMaintRequest(MaintenanceRequestImpl maintenanceRequest) {
        return facilityMaintenanceDAO.createMaintenanceReq(maintenanceRequest);
    }

    @Override
    public Boolean scheduleMaintenance(MaintenanceImpl maintenance) {
        return facilityMaintenanceDAO.createMaintenanceSchedule(maintenance);
    }

    @Override
    public Double calcMaintenanceCostForFacility(MaintenanceCostImpl maintenanceCost) {
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
    public List<MaintenanceRequestImpl> listMaintRequests() {
        return facilityMaintenanceDAO.getListOfFacilityMaintenanceReq();
    }

    @Override
    public List<MaintenanceImpl> listMaintenance() {
        return facilityMaintenanceDAO.getListOfMaintenance();
    }

    @Override
    public List<String> listFacilityProblems(int facilityId) {
        return facilityMaintenanceDAO.getListOfFacilityProblems(facilityId);
    }

}
*/