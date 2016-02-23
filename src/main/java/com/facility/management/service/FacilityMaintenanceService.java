package com.facility.management.service;

import com.facility.management.model.maintenance.Maintenance;
import com.facility.management.model.maintenance.MaintenanceCost;
import com.facility.management.model.maintenance.MaintenanceRequest;

import java.util.List;

public interface FacilityMaintenanceService {

    public Boolean makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest);
    public Boolean scheduleMaintenance(Maintenance maintenance);
    public Double calcMaintenanceCostForFacility(MaintenanceCost maintenanceCost);
    public Double calcProblemRateForFacility(int facilityId);               	//per year
    public Long calcDownTimeForFacility(int facilityId);                    	//in minutes
    public List<MaintenanceRequest> listMaintRequests();
    public List<Maintenance> listMaintenance();
    public List<String> listFacilityProblems(int facilityId);

}
