package com.facility.management.client;

import com.facility.management.model.facility.*;
import com.facility.management.model.maintenance.Maintenance;
import com.facility.management.model.maintenance.MaintenanceCost;
import com.facility.management.model.maintenance.MaintenanceRequest;
import com.facility.management.model.usage.Inspection;
import com.facility.management.model.usage.LeaseInfo;
import com.facility.management.service.FacilityMaintenanceService;
import com.facility.management.service.FacilityService;
import com.facility.management.service.FacilityUsageService;
import com.facility.management.service.impl.FacilityMaintenanceServiceImpl;
import com.facility.management.service.impl.FacilityServiceImpl;
import com.facility.management.service.impl.FacilityUsageServiceImpl;
import com.facility.management.util.DateUtil;

import java.util.List;
import java.util.Map;

public class FacilityClient {

    private static FacilityService facilityService = new FacilityServiceImpl();
    private static FacilityUsageService facilityUsageService = new FacilityUsageServiceImpl();
    private static FacilityMaintenanceService facilityMaintenanceService = new FacilityMaintenanceServiceImpl();

    public static void main(String[] args) {

        // Create new facility
        createNewFacility(99, FacilityType.BUILDING.name());
        addFacilityDetail(99, FacilityType.BUILDING.name(), 200, null);

        createNewFacility(101, FacilityType.UNIT.name());
        addFacilityDetail(101, FacilityType.UNIT.name(), 200, 2);

        //print facility information
        printFacilityInfo(99);
        printFacilityInfo(101);

        //print all facilities
        printAllFacilities();

        //print available capacity
        printAvailableCapacity(99);
        printAvailableCapacity(101);

        //Assign Facility to Use
        createNewLease(201, 99);
        createNewLease(202, 101);

        //Check if Facility is used during interval
        checkFacilityUsage(99, "2016-02-01", "2016-02-28");
        checkFacilityUsage(101, "2016-03-15", "2016-08-28");

        //Vacate facility
        vacateFacility(99, "2016-06-20");
        vacateFacility(101, "2016-06-30");

        //Check again if Facility is used during interval
        checkFacilityUsage(99, "2016-02-01", "2016-02-28");
        checkFacilityUsage(101, "2016-03-15", "2016-08-28");

        //print Inspections for facility
        printInspections(111);
        printInspections(112);

        //print usage by facility
        printActualUsageByFacility();

        //print usage rate by facility
        printUsageRateByFacility();


        //create maintenance request
        createMaintenanceRequest(55, 99, 2016);
        createMaintenanceRequest(56, 101, 2016);
        createMaintenanceRequest(57, 99, 2016);
        createMaintenanceRequest(58, 101, 2015);
        createMaintenanceRequest(59, 99, 2015);

        //schedule maintenance
        scheduleMaintenance(1, 58);
        scheduleMaintenance(2, 59);
        scheduleMaintenance(3, 55);
        scheduleMaintenance(4, 56);
        scheduleMaintenance(5, 57);

        //printMaintenanceCost
        printMaintenanceCost(1);
        printMaintenanceCost(2);
        
        //print all Maintenance Request
        printAllFacilityMaintenanceReq();
        
        //print all Maintenance
        printAllFacilityMaintenance();
        
        //print problem rate 
        printProblemRateForFacility(99);
        printProblemRateForFacility(101);
        
        //print total down time for facility
        printDownTimeForFacility(99);
        printDownTimeForFacility(101);
        
        //print problems for facility
        printFacilityProblems(99);
        printFacilityProblems(101);

        //remove facility
        removeFacility(99);
        removeFacility(101);


    }
    
    private static void printFacilityProblems(int facilityId) {
        List<String> problemList = facilityMaintenanceService.listFacilityProblems(facilityId);
        System.out.println("Printing problems for facility id : " + facilityId + " ----- ");
        for (String problem : problemList) {
            System.out.println(problem);
        }
        System.out.println();
    }

    private static void printDownTimeForFacility(int facilityId) {
    	long downTime = facilityMaintenanceService.calcDownTimeForFacility(facilityId);
    	System.out.println("Total Down time for Facility id : " + facilityId + " is ---- " + downTime + " minutes");
    	System.out.println();
	}

	private static void printProblemRateForFacility(int facilityId) {
    	double prblmRate = facilityMaintenanceService.calcProblemRateForFacility(facilityId);
    	System.out.println("Problem rate(per year) for Facility id : " + facilityId + " is ---- " + prblmRate);
    	System.out.println();
	}

	private static void printMaintenanceCost(int maintenanceId) {
        MaintenanceCost maintenanceCost = new MaintenanceCost();
        maintenanceCost.setMaintenanceId(maintenanceId);
        maintenanceCost.setMaterialCost(100);
        maintenanceCost.setLaborCost(25);
        maintenanceCost.setTotalCost(maintenanceCost.getMaterialCost() + maintenanceCost.getLaborCost());
        maintenanceCost.setPaid(true);
        System.out.println("Maintenance id: " + maintenanceId +
                " total cost is " + facilityMaintenanceService.calcMaintenanceCostForFacility(maintenanceCost));
        System.out.println();
    }

    private static void scheduleMaintenance(int maintenanceId, int mainReqId) {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceId(maintenanceId);
        maintenance.setMaintenanceReqId(mainReqId);
        maintenance.setWorkerName("Alex");
        maintenance.setWorkerPhoneNum("630-800-0969");
        maintenance.setStartDateTime(DateUtil.createDateTime(2015, 3, 21, 13, 00));
        maintenance.setEndDateTime(DateUtil.createDateTime(2015, 3, 21, 14, 00));
        facilityMaintenanceService.scheduleMaintenance(maintenance);
        System.out.println();
    }

    private static void createMaintenanceRequest(int mainReqId, int facilityId, int year) {
        MaintenanceRequest maintenanceRequest = new MaintenanceRequest();
        maintenanceRequest.setMaintenanceReqId(mainReqId);
        maintenanceRequest.setFacilityId(facilityId);
        maintenanceRequest.setRequestDetail("water leaking from shower faucet");
        maintenanceRequest.setRequesterName("Syeda");
        maintenanceRequest.setRequesterEmail("snowreen@luc.edu");
        maintenanceRequest.setRequestSubject("Shower broken");
        maintenanceRequest.setRequestDate(DateUtil.createDateTime(year, 3, 21, 12, 55));
        facilityMaintenanceService.makeFacilityMaintRequest(maintenanceRequest);
        System.out.println();
    }

    private static void printUsageRateByFacility() {
        Map<Integer, Double> usageRateMap = facilityUsageService.calcUsageRate();
        System.out.println("Usage Rate of facilities (days used every year in percentage): ");
        for (Map.Entry<Integer, Double> entry : usageRateMap.entrySet()) {
            System.out.println("Facility id : " + entry.getKey() + " ---- " + "Usage Rate (in percentage) : " + entry.getValue() +"%");
        }
        System.out.println();
    }

    private static void printActualUsageByFacility() {
        Map<Integer, Integer> actualUsageMap = facilityUsageService.listActualUsage();
        System.out.println("Actual Usage of facilities given below : ");
        for (Map.Entry<Integer, Integer> entry : actualUsageMap.entrySet()) {
            System.out.println("Facility id : " + entry.getKey() + " ---- " + "Usage (in days) : " + entry.getValue());
        }
        System.out.println();
    }

    private static void printInspections(int facilityId) {
        List<Inspection> inspectionList = facilityUsageService.listInspections(facilityId);
        System.out.println("Printing all inspections for facility id: " + facilityId);
        if (inspectionList != null && inspectionList.size() > 0) {
            for (Inspection inspection : inspectionList) {
                System.out.println(inspection.toString());
            }
        } else {
            System.out.println("No Inspections Found !!!");
        }
        System.out.println();

    }

    private static void vacateFacility(int facilityId, String vacateDate) {
        boolean isFacilityVacated = facilityUsageService.vacateFacility(facilityId, DateUtil.getParsedDate(vacateDate));
        if (isFacilityVacated) {
            System.out.println("Facility id : " + facilityId + " " +
                    "is vacated on " + vacateDate);
        } else {
            System.out.println("Facility id : " + facilityId + " " +
                    "cannot be vacated !!!!");
        }
        System.out.println();
    }

    private static void checkFacilityUsage(int facilityId, String beginDate, String endDate) {
        boolean isFacilityInUse = facilityUsageService.isInUseDuringInterval(facilityId,
                DateUtil.getParsedDate(beginDate), DateUtil.getParsedDate(endDate));
        if (isFacilityInUse) {
            System.out.println("Facility id : " + facilityId + " " +
                    "is already booked on your selected " + beginDate + " to " + endDate);
        } else {
            System.out.println("Facility id : " + facilityId + " " +
                    "is VACANT from " + beginDate + " to " + endDate);
        }
        System.out.println();
    }

    private static void createNewLease(int leaseId, int facilityId) {
        LeaseInfo leaseInfo = new LeaseInfo();
        leaseInfo.setFacilityId(facilityId);
        leaseInfo.setCustomerId(1);
        leaseInfo.setLeaseId(leaseId);
        leaseInfo.setSecurityDeposit(500);
        leaseInfo.setStartDate(DateUtil.getParsedDate("2016-03-01"));
        leaseInfo.setEndDate(DateUtil.getParsedDate("2016-06-30"));
        facilityUsageService.assignFacilityToUse(leaseInfo);
        System.out.println();
    }

    private static void removeFacility(int facilityId) {
        facilityService.removeFacility(facilityId);
    }

    private static void printAvailableCapacity(int facilityId) {
        System.out.println("Available Capacity for facility id: " +
                facilityId + " is --------- " + facilityService.requestAvailableCapacity(facilityId));
        System.out.println();
    }

    private static void printAllFacilities() {
        List<Facility> facilityList = facilityService.listFacilities();
        System.out.println("Printing all facilities in database : ");
        for (Facility facility : facilityList) {
            System.out.println(facility.toString());
        }
        System.out.println();
    }

    private static void printAllFacilityMaintenanceReq() {
        List<MaintenanceRequest> maintenanceReqList = facilityMaintenanceService.listMaintRequests();
        System.out.println("Printing all maintenance request in database : ");
        for (MaintenanceRequest maintenceReq : maintenanceReqList) {
            System.out.println(maintenceReq.toString());
        }
        System.out.println();
    }
    
    private static void printAllFacilityMaintenance() {
        List<Maintenance> maintenanceList = facilityMaintenanceService.listMaintenance();
        System.out.println("Printing all maintenance in database : ");
        for (Maintenance maintence : maintenanceList) {
            System.out.println(maintence.toString());
        }
        System.out.println();
    }
    
    private static void printFacilityInfo(int facilityId) {
        System.out.println(facilityService.getFacilityInformation(facilityId).toString());
        System.out.println();
    }

    private static void createNewFacility(int facilityId, String facilityType) {
        Facility facility = new Facility();
        facility.setFacilityId(facilityId);
        facility.setFacilityName("abc");
        facility.setCapacity(1000);
        facility.setTotalArea(1200.23);
        facility.setFacilityType(facilityType);

        FacilityAddress facilityAddress = new FacilityAddress();
        facilityAddress.setAddressId(123);
        facilityAddress.setCity("chicago");
        facilityAddress.setState("IL");
        facilityAddress.setZipCode("60502");
        facility.setFacilityAddress(facilityAddress);
        facilityService.addNewFacility(facility);
        System.out.println();
    }

    private static void addFacilityDetail(int facilityId, String facilityType, Integer buildingId, Integer unitId) {

        if (facilityType.equals(FacilityType.BUILDING.name())) {
            Building building = new Building();
            building.setFacilityId(facilityId);
            building.setBuildingId(buildingId);
            building.setNoOfElevators(4);
            building.setNoOfEntrance(2);
            building.setNumOfFloors(15);
            building.setFacilityType(facilityType);
            facilityService.addFacilityDetail(building);
        } else if (facilityType.equals(FacilityType.UNIT.name())) {
            BuildingUnit buildingUnit = new BuildingUnit();
            buildingUnit.setFacilityId(facilityId);
            buildingUnit.setBuildingId(buildingId);
            buildingUnit.setUnitId(unitId);
            buildingUnit.setLevelNum(4);
            buildingUnit.setNumOfRooms(2);
            buildingUnit.setFacilityType(facilityType);
            facilityService.addFacilityDetail(buildingUnit);
        }
        System.out.println();

    }
}
