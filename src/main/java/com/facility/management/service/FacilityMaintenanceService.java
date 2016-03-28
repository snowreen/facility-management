package com.facility.management.service;

import com.facility.management.model.maintenance.MaintenanceImpl;
import com.facility.management.model.maintenance.MaintenanceCostImpl;
import com.facility.management.model.maintenance.MaintenanceRequestImpl;

import java.util.List;

public interface FacilityMaintenanceService {

    public Boolean makeFacilityMaintRequest(MaintenanceRequestImpl maintenanceRequest);
    public Boolean scheduleMaintenance(MaintenanceImpl maintenance);
    public Double calcMaintenanceCostForFacility(MaintenanceCostImpl maintenanceCost);
    public Double calcProblemRateForFacility(int facilityId);               	//per year
    public Long calcDownTimeForFacility(int facilityId);                    	//in minutes
    public List<MaintenanceRequestImpl> listMaintRequests();
    public List<MaintenanceImpl> listMaintenance();
    public List<String> listFacilityProblems(int facilityId);

}
