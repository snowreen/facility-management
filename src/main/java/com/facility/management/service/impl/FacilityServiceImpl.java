package com.facility.management.service.impl;

import com.facility.management.dal.FacilityDAO;
import com.facility.management.model.facility.Facility;
import com.facility.management.service.FacilityService;

import java.util.List;

public class FacilityServiceImpl implements FacilityService {

    private FacilityDAO facilityDAO = new FacilityDAO();

    @Override
    public List<Facility> listFacilities() {
        return null;
    }

    @Override
    public Facility getFacilityInformation(int facilityId) {
        return facilityDAO.getFacilityInfo(facilityId);
    }

    @Override
    public Long requestAvailableCapacity(int facilityId) {
        return null;
    }

    @Override
    public Boolean addNewFacility(Facility facility) {
        return facilityDAO.createFacility(facility);
    }

    @Override
    public void addFacilityDetail(Facility facility) {

    }

    @Override
    public Boolean removeFacility(int facilityId) {
        return null;
    }

}
