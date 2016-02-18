package com.facility.management.dal;

import com.facility.management.model.facility.Facility;
import com.facility.management.model.facility.FacilityAddress;

import java.sql.*;

public class FacilityDAO {

    public boolean createFacility(Facility facility) {
        Connection con = DBHelper.getConnection();
        PreparedStatement facilityStatement = null;
        PreparedStatement facilityAddressStatement = null;

        try {
            //Insert the Facility address object

            FacilityAddress facilityAddress = facility.getFacilityAddress();
            Statement st = con.createStatement();
            int facilityAddressInsertResult = 0;
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
                facilityAddressInsertResult = facilityAddressStatement.executeUpdate();
            }


            //Insert the Facility object

            String facilityInsertQuery = "INSERT INTO facility(facility_name, capacity, total_area, facility_address_id, facility_type, status, facility_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
            facilityStatement = con.prepareStatement(facilityInsertQuery);
            facilityStatement.setString(1, facility.getFacilityName());
            facilityStatement.setLong(2, facility.getCapacity());
            facilityStatement.setDouble(3, facility.getTotalArea());
            facilityStatement.setInt(4, facilityAddress.getAddressId());
            facilityStatement.setString(5, facility.getFacilityType());
            facilityStatement.setString(6, facility.getStatus());
            facilityStatement.setInt(7, facility.getFacilityId());

            int facilityInsertResult = facilityStatement.executeUpdate();



            if (facilityInsertResult > 0 && facilityAddressInsertResult > 0) {
                System.out.println("Facility Inserted Successfully");
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




    public Facility getFacilityInfo(int facilityId) {

        try {
            //Get facility
            Statement st = DBHelper.getConnection().createStatement();
            String selectFacilityQuery = "SELECT facility_name, capacity FROM facility WHERE facility_id = '" + facilityId + "'";

            ResultSet facilityRS = st.executeQuery(selectFacilityQuery);
            System.out.println("FacilityDAO: *************** Query " + selectFacilityQuery);

            //Get Facility
            Facility facility = new Facility();
            while (facilityRS.next()) {
                facility.setFacilityName(facilityRS.getString("facility_name"));
                facility.setCapacity(facilityRS.getInt("capacity"));
            }
            //close to manage resources
            facilityRS.close();
        } catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }

        return null;

    }
}

