package com.facility.management.dal;

import com.facility.management.model.facility.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacilityDAO {

    public boolean createFacility(Facility facility) {
        Connection con = DBHelper.getConnection();
        PreparedStatement facilityStatement = null;
        PreparedStatement facilityAddressStatement = null;

        try {
            //Insert the Facility address object

            FacilityAddress facilityAddress = facility.getFacilityAddress();
            Statement st = con.createStatement();
            String findExistingAddress = "select * from facility_address where facility_address_id = '" + facilityAddress.getAddressId() + "'";
            ResultSet existingAddress = st.executeQuery(findExistingAddress);
            if (!existingAddress.next()) {
                String facilityAddressInsertQuery = "INSERT INTO facility_address(facility_address_id, street_address, city, state, zipcode) VALUES(?, ?, ?, ?, ?)";
                facilityAddressStatement = con.prepareStatement(facilityAddressInsertQuery);
                facilityAddressStatement.setInt(1, facilityAddress.getAddressId());
                facilityAddressStatement.setString(2, facilityAddress.getStreetAddress());
                facilityAddressStatement.setString(3, facilityAddress.getCity());
                facilityAddressStatement.setString(4, facilityAddress.getState());
                facilityAddressStatement.setString(5, facilityAddress.getZipCode());
                facilityAddressStatement.executeUpdate();
            }


            //Insert the Facility object

            String facilityInsertQuery = "INSERT INTO facility(facility_name, capacity, total_area, facility_address_id, facility_type, facility_id) VALUES(?, ?, ?, ?, ?, ?)";
            facilityStatement = con.prepareStatement(facilityInsertQuery);
            facilityStatement.setString(1, facility.getFacilityName());
            facilityStatement.setLong(2, facility.getCapacity());
            facilityStatement.setDouble(3, facility.getTotalArea());
            facilityStatement.setInt(4, facilityAddress.getAddressId());
            facilityStatement.setString(5, facility.getFacilityType());
            facilityStatement.setInt(6, facility.getFacilityId());

            int facilityInsertResult = facilityStatement.executeUpdate();



            if (facilityInsertResult > 0) {
                System.out.println("Facility Inserted Successfully with facility id: " + facility.getFacilityId());
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {

            try {
                if (facilityStatement != null) {
                    facilityStatement.close();
                }
                if (facilityAddressStatement != null) {
                    facilityAddressStatement.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FacilityDAO: Threw a SQLException saving the Facility object.");
                System.err.println(ex.getMessage());
            }
        }

        return false;
    }


    public boolean addBuildingDetails(Building building) {
        Connection con = DBHelper.getConnection();
        PreparedStatement buildingStatement = null;

        try {
            //Insert the building object

            String buildingInsertQuery = "INSERT INTO building(building_id, facility_id, num_of_floors, num_of_elevators, num_of_entrance) VALUES(?, ?, ?, ?, ?)";
            buildingStatement = con.prepareStatement(buildingInsertQuery);
            buildingStatement.setInt(1, building.getBuildingId());
            buildingStatement.setInt(2, building.getFacilityId());
            buildingStatement.setInt(3, building.getNumOfFloors());
            buildingStatement.setInt(4, building.getNoOfElevators());
            buildingStatement.setInt(5, building.getNoOfEntrance());

            int buildingInsertResult = buildingStatement.executeUpdate();



            if (buildingInsertResult > 0) {
                System.out.println("Building info Inserted Successfully for facility id: " + building.getFacilityId());
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("FacilityDAO: Threw a SQLException saving the Building object.");
            ex.printStackTrace();
            return false;
        } finally {

            try {
                if (buildingStatement != null) {
                    buildingStatement.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FacilityDAO: Threw a SQLException saving the Building object.");
                System.err.println(ex.getMessage());
            }
        }

        return false;
    }

    public boolean addBuildingUnitDetails(BuildingUnit buildingUnit) {
        Connection con = DBHelper.getConnection();
        PreparedStatement buildingUnitStatement = null;

        try {
            //Insert the building unit object

            String buildingUnitInsertQuery = "INSERT INTO building_unit(building_id, facility_id, unit_id, num_of_rooms, level_num) VALUES(?, ?, ?, ?, ?)";
            buildingUnitStatement = con.prepareStatement(buildingUnitInsertQuery);
            buildingUnitStatement.setInt(1, buildingUnit.getBuildingId());
            buildingUnitStatement.setInt(2, buildingUnit.getFacilityId());
            buildingUnitStatement.setInt(3, buildingUnit.getUnitId());
            buildingUnitStatement.setInt(4, buildingUnit.getNumOfRooms());
            buildingUnitStatement.setInt(5, buildingUnit.getLevelNum());

            int buildingUnitInsertResult = buildingUnitStatement.executeUpdate();



            if (buildingUnitInsertResult > 0) {
                System.out.println("Unit info Inserted Successfully for facility id: " + buildingUnit.getFacilityId());
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("FacilityDAO: Threw a SQLException saving the Building Unit object.");
            ex.printStackTrace();
            return false;
        } finally {

            try {
                if (buildingUnitStatement != null) {
                    buildingUnitStatement.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FacilityDAO: Threw a SQLException saving the Building Unit object.");
                System.err.println(ex.getMessage());
            }
        }

        return false;
    }


    public Facility getFacilityInfo(int facilityId) {
        Connection con = DBHelper.getConnection();
        Statement st = null;

        try {
            //Get facility type
            st = con.createStatement();
            String selectFacilityTypeQuery = "SELECT facility_type FROM facility WHERE facility_id = '" + facilityId + "'";

            ResultSet facilityRS = st.executeQuery(selectFacilityTypeQuery);
            System.out.println("FacilityDAO: *************** Query " + selectFacilityTypeQuery);

            String facilityType = null;

            while (facilityRS.next()) {
                facilityType = facilityRS.getString("facility_type");
                System.out.println("Facility Type is " + facilityType);
            }
            //close to manage resources
            facilityRS.close();
            if (facilityType.equals(FacilityType.BUILDING.name())) {
                System.out.println("Returning Building information ***************");
                return getBuildingInfo(facilityId);
            }
            if (facilityType.equals(FacilityType.UNIT.name())) {
                System.out.println("Returning Building Unit information ***************");
                return getBuildingUnitInfo(facilityId);
            }
        } catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        } finally {

            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FacilityDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }

        return null;

    }

    private Building getBuildingInfo(int facilityId) {
        Connection con = DBHelper.getConnection();
        Statement st = null;
        try {
            //Get building
            st = con.createStatement();
            String selectBuildingQuery = "SELECT f.facility_name, f.capacity, f.facility_type," +
                    " b.building_id, b.num_of_floors, b.num_of_elevators, b.num_of_entrance" +
                    " FROM facility f, building b WHERE f.facility_id = b.facility_id AND f.facility_id = '" + facilityId + "'";

            ResultSet buildingRS = st.executeQuery(selectBuildingQuery);
            System.out.println("FacilityDAO: *************** Query " + selectBuildingQuery);

            Building building = new Building();
            if (buildingRS.next()) {
                building.setFacilityId(facilityId);
                building.setFacilityName(buildingRS.getString("facility_name"));
                building.setCapacity(buildingRS.getInt("capacity"));
                building.setFacilityType(buildingRS.getString("facility_type"));
                building.setBuildingId(buildingRS.getInt("building_id"));
                building.setNumOfFloors(buildingRS.getInt("num_of_floors"));
                building.setNoOfElevators(buildingRS.getInt("num_of_elevators"));
                building.setNoOfEntrance(buildingRS.getInt("num_of_entrance"));
            }
            //close to manage resources
            buildingRS.close();
            return building;
        } catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving the building object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        } finally {

            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FacilityDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }

        return null;
    }

    private BuildingUnit getBuildingUnitInfo(int facilityId) {
        Connection con = DBHelper.getConnection();
        Statement st = null;
        try {
            //Get building unit
            st = con.createStatement();
            String selectBuildingUnitQuery = "SELECT f.facility_name, f.capacity, f.facility_type," +
                    " bu.building_id, bu.unit_id, bu.num_of_rooms, bu.level_num" +
                    " FROM facility f, building_unit bu WHERE f.facility_id = bu.facility_id AND f.facility_id = '" + facilityId + "'";

            ResultSet buildingUnitRS = st.executeQuery(selectBuildingUnitQuery);
            System.out.println("FacilityDAO: *************** Query " + selectBuildingUnitQuery);

            BuildingUnit buildingUnit = new BuildingUnit();
            if (buildingUnitRS.next()) {
                buildingUnit.setFacilityId(facilityId);
                buildingUnit.setFacilityName(buildingUnitRS.getString("facility_name"));
                buildingUnit.setCapacity(buildingUnitRS.getInt("capacity"));
                buildingUnit.setFacilityType(buildingUnitRS.getString("facility_type"));
                buildingUnit.setBuildingId(buildingUnitRS.getInt("building_id"));
                buildingUnit.setUnitId(buildingUnitRS.getInt("unit_id"));
                buildingUnit.setLevelNum(buildingUnitRS.getInt("level_num"));
                buildingUnit.setNumOfRooms(buildingUnitRS.getInt("num_of_rooms"));
            }
            //close to manage resources
            buildingUnitRS.close();
            return buildingUnit;
        } catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving the building object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        } finally {

            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FacilityDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }

        return null;



    }

    public List<Facility> getListOfFacilities() {
        Connection con = DBHelper.getConnection();
        Statement st = null;

        try {
            //Get facility type
            st = con.createStatement();
            String selectListOfFacilityTypeQuery = "SELECT facility_name, facility_id, facility_type FROM facility";

            ResultSet facilityRS = st.executeQuery(selectListOfFacilityTypeQuery);
            System.out.println("FacilityDAO: *************** Query " + selectListOfFacilityTypeQuery);

            List<Facility> facilityList = new ArrayList<Facility>();

            while (facilityRS.next()) {
                Facility facility = new Facility();
                facility.setFacilityName(facilityRS.getString("facility_name"));
                facility.setFacilityId(facilityRS.getInt("facility_id"));
                facility.setFacilityType(facilityRS.getString("facility_type"));
                facilityList.add(facility);
            }
            return facilityList;
        } catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        } finally {

            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FacilityDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }
        return null;

    }

    public Long getAvailableCapacity(int facilityId) {
        Connection con = DBHelper.getConnection();
        Statement st = null;

        try {
            //Get facility type
            st = con.createStatement();
            String selectCapacityQuery = "SELECT capacity FROM facility WHERE facility_id = '" + facilityId + "'";

            ResultSet facilityRS = st.executeQuery(selectCapacityQuery);
            System.out.println("FacilityDAO: *************** Query " + selectCapacityQuery);

            Long capacity = null;

            while (facilityRS.next()) {
                capacity = facilityRS.getLong("capacity");
            }
            //close to manage resources
            facilityRS.close();
            return capacity;
        } catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving capacity.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        } finally {

            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FacilityDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }

        return null;
    }

    public boolean removeFacility(int facilityId) {
        Connection con = DBHelper.getConnection();
        Statement st = null;

        try {
            //Get facility type
            st = con.createStatement();
            String deleteFacilityQuery = "DELETE FROM facility WHERE facility_id = '" + facilityId + "'";

            int deletedRow = st.executeUpdate(deleteFacilityQuery);
            System.out.println("FacilityDAO: *************** Query " + deleteFacilityQuery);

            if (deletedRow > 0) {
                System.out.println("Facility id " + facilityId + " Successfully deleted!");
                return true;
            }
            System.out.println("Facility id " + facilityId + " CANNOT be deleted !!!");
            return false;
        } catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException deleting facility.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        } finally {

            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FacilityDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }

        return false;
    }
}

