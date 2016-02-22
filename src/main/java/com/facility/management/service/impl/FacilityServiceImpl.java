package com.facility.management.service.impl;

import com.facility.management.dal.FacilityDAO;
import com.facility.management.model.facility.Building;
import com.facility.management.model.facility.BuildingUnit;
import com.facility.management.model.facility.Facility;
import com.facility.management.model.facility.FacilityType;
import com.facility.management.service.FacilityService;

import java.util.List;

public class FacilityServiceImpl implements FacilityService {

    private FacilityDAO facilityDAO = new FacilityDAO();

    @Override
    public List<Facility> listFacilities() {
        return facilityDAO.getListOfFacilities();
    }

    @Override
    public Facility getFacilityInformation(int facilityId) {
        return facilityDAO.getFacilityInfo(facilityId);
    }

    @Override
    public Long requestAvailableCapacity(int facilityId) {
        return facilityDAO.getAvailableCapacity(facilityId);
    }

    @Override
    public Boolean addNewFacility(Facility facility) {
        return facilityDAO.createFacility(facility);
    }

    @Override
    public void addFacilityDetail(Facility facility) {
        if (facility.getFacilityType().equals(FacilityType.BUILDING.name())) {
            facilityDAO.addBuildingDetails((Building) facility);
        } else if (facility.getFacilityType().equals(FacilityType.UNIT.name())) {
            facilityDAO.addBuildingUnitDetails((BuildingUnit) facility);
        }
    }

    @Override
    public Boolean removeFacility(int facilityId) {
        return facilityDAO.removeFacility(facilityId);
    }

}
