package com.facility.management.service.impl;

import com.facility.management.dal.FacilityHibernateDAO;
import com.facility.management.model.facility.Building;
import com.facility.management.model.facility.BuildingImpl;
import com.facility.management.model.facility.BuildingUnit;
import com.facility.management.model.facility.BuildingUnitImpl;
import com.facility.management.model.facility.Facility;
import com.facility.management.model.facility.FacilityDetail;
import com.facility.management.model.facility.FacilityImpl;
import com.facility.management.model.facility.FacilityType;
import com.facility.management.service.FacilityService;

import java.util.List;

public class FacilityServiceImpl implements FacilityService {

    private FacilityHibernateDAO facilityDAO;

    /*@Override
    public List<FacilityImpl> listFacilities() {
        return facilityDAO.getListOfFacilities();
    }

    @Override
    public FacilityImpl getFacilityInformation(int facilityId) {
        return facilityDAO.getFacilityInfo(facilityId);
    }

    @Override
    public Long requestAvailableCapacity(int facilityId) {
        return facilityDAO.getAvailableCapacity(facilityId);
    }*/

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
    public void removeFacility(Facility facility) {
        facilityDAO.deleteFacility(facility);
    }

}
