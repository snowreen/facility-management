package com.facility.management.service.impl;

import java.util.List;

import com.facility.management.dal.FacilityMaintenanceHibernateDAO;
import com.facility.management.model.maintenance.Maintenance;
import com.facility.management.model.maintenance.MaintenanceCost;
import com.facility.management.model.maintenance.MaintenanceRequest;
import com.facility.management.service.FacilityMaintenanceService;

public class FacilityMaintenanceServiceImpl implements FacilityMaintenanceService {

    private FacilityMaintenanceHibernateDAO facilityMaintenanceDAO;

	public void setFacilityMaintenanceDAO(
			FacilityMaintenanceHibernateDAO facilityMaintenanceDAO) {
		this.facilityMaintenanceDAO = facilityMaintenanceDAO;
	}

	@Override
	public Boolean makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest) {
		return facilityMaintenanceDAO.createMaintenanceReq(maintenanceRequest);
	}

	@Override
	public Boolean scheduleMaintenance(Maintenance maintenance) {
		return facilityMaintenanceDAO.createMaintenanceSchedule(maintenance);
	}
	
	@Override
	public MaintenanceCost retrieveMaintenanceCostForFacility(int maintenanceId) {
		return facilityMaintenanceDAO.getMaintenanceCost(maintenanceId);
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
	public List<String> listFacilityProblems(int facilityId) {
		return facilityMaintenanceDAO.getListOfFacilityProblems(facilityId);
	}

	@Override
	public List<MaintenanceRequest> listMaintRequests() {
		return facilityMaintenanceDAO.getListOfFacilityMaintenanceReq();
	}

	@Override
	public List<Maintenance> listMaintenance() {
		return facilityMaintenanceDAO.getListOfMaintenance();
	}
}
