package com.facility.management;

import com.facility.management.model.facility.Facility;
import com.facility.management.model.facility.FacilityAddress;
import com.facility.management.model.facility.FacilityStatus;
import com.facility.management.model.facility.FacilityType;
import com.facility.management.service.FacilityService;
import com.facility.management.service.impl.FacilityServiceImpl;

public class Test {

    public static void main(String[] args) {

        // Create new facility
        Facility facility = new Facility();
        facility.setFacilityId(11);
        facility.setFacilityName("abc");
        facility.setCapacity(1000);
        facility.setTotalArea(1200.23);
        facility.setFacilityType(FacilityType.BUILDING.name());
        facility.setStatus(FacilityStatus.VACCANT.name());
        FacilityAddress facilityAddress = new FacilityAddress();
        facilityAddress.setAddressId(123);
        facilityAddress.setCity("chicago");
        facilityAddress.setState("IL");
        facilityAddress.setZipCode("60502");


        facility.setFacilityAddress(facilityAddress);

        FacilityService facilityService = new FacilityServiceImpl();

        facilityService.addNewFacility(facility);

    }
}
