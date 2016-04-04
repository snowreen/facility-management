package com.facility.management.service;

import java.util.List;

import com.facility.management.model.maintenance.Maintenance;
import com.facility.management.model.maintenance.MaintenanceCost;
import com.facility.management.model.maintenance.MaintenanceRequest;

public interface FacilityMaintenanceService {

    public Boolean makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest);
    public Boolean scheduleMaintenance(Maintenance maintenance);
    public MaintenanceCost retrieveMaintenanceCostForFacility(int maintenanceId);
    public Double calcProblemRateForFacility(int facilityId);               	//per year
    public Long calcDownTimeForFacility(int facilityId);                    	//in minutes
    public List<MaintenanceRequest> listMaintRequests();
    public List<Maintenance> listMaintenance();
    public List<String> listFacilityProblems(int facilityId);

}
