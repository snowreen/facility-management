package com.facility.management.client;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.facility.management.dal.FacilityHibernateDAO;
import com.facility.management.model.facility.Building;
import com.facility.management.model.facility.BuildingUnit;
import com.facility.management.model.facility.Facility;
import com.facility.management.model.facility.FacilityAddress;
import com.facility.management.model.facility.FacilityAddressImpl;
import com.facility.management.model.facility.FacilityImpl;
import com.facility.management.model.facility.FacilityType;
import com.facility.management.service.FacilityService;

public class FacilityClient {

    /*private static FacilityService facilityService = new FacilityServiceImpl();
    private static FacilityUsageService facilityUsageService = new FacilityUsageServiceImpl();
    private static FacilityMaintenanceService facilityMaintenanceService = new FacilityMaintenanceServiceImpl();*/
	
	private static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");
		System.out.println("***************** Application Context instantiated! ******************");
	}

    public static void main(String[] args) {
        // Create new facility
    	removeFacility(99);
    	removeFacility(101);
    	
        Facility facilityBuilding = createNewFacility(99, FacilityType.BUILDING.name());
        addFacilityDetail(facilityBuilding, 200, null);

        Facility facilityBuildingUnit = createNewFacility(101, FacilityType.UNIT.name());
        addFacilityDetail(facilityBuildingUnit, 200, 1);
        
        /*removeFacility(99);
    	removeFacility(101);*/

        //print facility information
        /*printFacilityInfo(99);
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
        removeFacility(101);*/


    }
    
    /*private static void printFacilityProblems(int facilityId) {
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
        MaintenanceCostImpl maintenanceCost = new MaintenanceCostImpl();
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
        MaintenanceImpl maintenance = new MaintenanceImpl();
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
        MaintenanceRequestImpl maintenanceRequest = new MaintenanceRequestImpl();
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
        List<InspectionImpl> inspectionList = facilityUsageService.listInspections(facilityId);
        System.out.println("Printing all inspections for facility id: " + facilityId);
        if (inspectionList != null && inspectionList.size() > 0) {
            for (InspectionImpl inspection : inspectionList) {
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
        LeaseInfoImpl leaseInfo = new LeaseInfoImpl();
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
        List<FacilityImpl> facilityList = facilityService.listFacilities();
        System.out.println("Printing all facilities in database : ");
        for (FacilityImpl facility : facilityList) {
            System.out.println(facility.toString());
        }
        System.out.println();
    }

    private static void printAllFacilityMaintenanceReq() {
        List<MaintenanceRequestImpl> maintenanceReqList = facilityMaintenanceService.listMaintRequests();
        System.out.println("Printing all maintenance request in database : ");
        for (MaintenanceRequestImpl maintenceReq : maintenanceReqList) {
            System.out.println(maintenceReq.toString());
        }
        System.out.println();
    }
    
    private static void printAllFacilityMaintenance() {
        List<MaintenanceImpl> maintenanceList = facilityMaintenanceService.listMaintenance();
        System.out.println("Printing all maintenance in database : ");
        for (MaintenanceImpl maintence : maintenanceList) {
            System.out.println(maintence.toString());
        }
        System.out.println();
    }
    
    private static void printFacilityInfo(int facilityId) {
        System.out.println(facilityService.getFacilityInformation(facilityId).toString());
        System.out.println();
    }*/

    private static Facility createNewFacility(int facilityId, String facilityType) {
        Facility facility = (Facility) context.getBean("facility");
        facility.setFacilityId(facilityId);
        facility.setFacilityName("abc");
        facility.setCapacity(1000);
        facility.setTotalArea(new BigDecimal(1200.23));
        facility.setFacilityType(facilityType);

        FacilityAddress facilityAddress = facility.getFacilityAddress();
        facilityAddress.setFacilityAddressId(123);
        facilityAddress.setCity("chicago");
        facilityAddress.setState("IL");
        facilityAddress.setZipcode("60502");
        
        FacilityService facilityService = (FacilityService) context.getBean("facilityService");
        facilityService.addNewFacility(facility);
        
        System.out.println();
        return facility;
    }
    
    private static void removeFacility(int facilityId) {
    	Facility facility = (Facility) context.getBean("facility");
        facility.setFacilityId(facilityId);
        FacilityAddress facilityAddress = facility.getFacilityAddress();
        facilityAddress.setFacilityAddressId(123);
        FacilityService facilityService = (FacilityService) context.getBean("facilityService");
        facilityService.removeFacility(facility);
    }

    private static void addFacilityDetail(Facility facility, int buildingId, Integer unitId) {
    	
    	FacilityService facilityService = (FacilityService) context.getBean("facilityService");
    	
        if (facility.getFacilityType().equals(FacilityType.BUILDING.name())) {
            Building building = (Building) context.getBean("building");
            building.setBuildingId(buildingId);
            building.setNumOfElevators(4);
            building.setNumOfEntrance(2);
            building.setNumOfFloors(15);
            building.getFacility().setFacilityId(facility.getFacilityId());
            facilityService.addFacilityDetail(building);
        } else if (facility.getFacilityType().equals(FacilityType.UNIT.name())) {
            BuildingUnit buildingUnit = (BuildingUnit) context.getBean("buildingUnit");
            buildingUnit.setUnitId(unitId);
            buildingUnit.setLevelNum(4);
            buildingUnit.setNumOfRooms(2);
            buildingUnit.getBuilding().setBuildingId(buildingId);
            buildingUnit.getFacility().setFacilityId(facility.getFacilityId());
            facilityService.addFacilityDetail(buildingUnit);
        }
        
        System.out.println();

    }
}
