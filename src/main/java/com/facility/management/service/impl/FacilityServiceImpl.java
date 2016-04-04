package com.facility.management.service.impl;

import java.util.List;

import com.facility.management.dal.FacilityHibernateDAO;
import com.facility.management.model.facility.Building;
import com.facility.management.model.facility.BuildingUnit;
import com.facility.management.model.facility.Facility;
import com.facility.management.model.facility.FacilityDetail;
import com.facility.management.service.FacilityService;

public class FacilityServiceImpl implements FacilityService {

    private FacilityHibernateDAO facilityDAO;

    public void setFacilityDAO(FacilityHibernateDAO facilityDAO) {
		this.facilityDAO = facilityDAO;
	}


	@Override
    public void addNewFacility(Facility facility) {
        facilityDAO.addFacility(facility);
    }

    @Override
    public void addFacilityDetail(FacilityDetail facilityDetail) {
        if (facilityDetail instanceof Building) {
            facilityDAO.addBuildingDetails((Building) facilityDetail);
        } else if (facilityDetail instanceof BuildingUnit) {
            facilityDAO.addBuildingUnitDetails((BuildingUnit) facilityDetail);
        }
    }
    
    @Override
    public FacilityDetail getFacilityInformation(int facilityId) {
        return facilityDAO.getFacilityInfo(facilityId);
    }

    @Override
    public void removeFacility(Facility facility) {
        facilityDAO.deleteFacility(facility);
    }
    
    @Override
    public List<Facility> listFacilities() {
        return facilityDAO.getListOfFacilities();
    }
    
    @Override
    public Integer requestAvailableCapacity(int facilityId) {
        return facilityDAO.getAvailableCapacity(facilityId);
    }

}
