package com.facility.management.service;

import com.facility.management.model.facility.Facility;
import com.facility.management.model.facility.FacilityDetail;
import com.facility.management.model.facility.FacilityImpl;

import java.util.List;

public interface FacilityService {

    /*public List<FacilityImpl> listFacilities();
    public FacilityImpl getFacilityInformation(int facilityId);
    public Long requestAvailableCapacity(int facilityId);*/
    public void addFacilityDetail(FacilityDetail facility);
    public void addNewFacility(Facility facility);
    public void removeFacility(Facility facility);
}
