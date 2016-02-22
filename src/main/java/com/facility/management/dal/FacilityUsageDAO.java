package com.facility.management.dal;

import com.facility.management.model.usage.Inspection;
import com.facility.management.model.usage.LeaseInfo;
import com.facility.management.model.usage.LeaseStatus;
import com.facility.management.util.DateUtil;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class FacilityUsageDAO {

    public boolean assignFacilityToUse(LeaseInfo leaseInfo) {
        Connection con = DBHelper.getConnection();
        PreparedStatement facilityUsageStatement = null;

        try {
            //Insert the Facility Usage object

            String facilityUsageInsertQuery = "INSERT INTO lease_info (lease_id, start_date, end_date, security_deposite, customer_id, facility_id) VALUES (?, ?, ?, ?, ?, ?);";
            facilityUsageStatement = con.prepareStatement(facilityUsageInsertQuery);
            facilityUsageStatement.setInt(1, leaseInfo.getLeaseId());
            facilityUsageStatement.setDate(2, DateUtil.convertToSqlDate(leaseInfo.getStartDate()));
            facilityUsageStatement.setDate(3, DateUtil.convertToSqlDate(leaseInfo.getEndDate()));
            facilityUsageStatement.setDouble(4, leaseInfo.getSecurityDeposit());
            facilityUsageStatement.setInt(5, leaseInfo.getCustomerId());
            facilityUsageStatement.setInt(6, leaseInfo.getFacilityId());

            int facilityUsageInsertResult = facilityUsageStatement.executeUpdate();
            System.out.println("FacilityUsageDAO: *************** Query " + facilityUsageInsertQuery);

            if (facilityUsageInsertResult > 0) {
                System.out.println("Facility Lease Info Inserted Successfully");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {

            try {
                if (facilityUsageStatement != null) {
                    facilityUsageStatement.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FacilityDAO: Threw a SQLException saving the Lease object.");
                System.err.println(ex.getMessage());
            }
        }

        return false;
    }

    public boolean isInUseDuringInterval(int facilityId, Date beginDate, Date endDate) {
        Connection con = DBHelper.getConnection();
        Statement st = null;

        String intervalBeginDate = DateUtil.getStringDate(beginDate);
        String intervalEndDate = DateUtil.getStringDate(endDate);

        try {
            //Get count of facility if in use during interval type
            st = con.createStatement();
            String selectActiveLease = "SELECT count(1) as active_lease FROM lease_info where facility_id = '" + facilityId + "'" +
                    " and end_date >= '" + intervalBeginDate + "' and start_date <= '" + intervalEndDate + "'" +
                    " and status = '" + LeaseStatus.ACTIVE.name() + "'";

            ResultSet leaseRS = st.executeQuery(selectActiveLease);
            System.out.println("FacilityUsageDAO: *************** Query " + selectActiveLease);

            Integer numActiveLease = null;

            while (leaseRS.next()) {
                numActiveLease = leaseRS.getInt("active_lease");
            }
            //close to manage resources
            leaseRS.close();
            if (numActiveLease > 0) {
                return true;
            }
            return false;
        } catch (SQLException se) {
            System.err.println("FacilityUsageDAO: Threw a SQLException retrieving active lease.");
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
                System.err.println("FacilityUsageDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }

        return false;
    }

    public boolean vacateFacility(int facilityId, Date vacateDate) {
        Connection con = DBHelper.getConnection();
        PreparedStatement facilityVacateStatement = null;

        try {
            //Insert the Facility Usage object

            String facilityVacateQuery = "UPDATE lease_info SET status = ?, termination_date = ?" +
                    " where facility_id = ?";
            facilityVacateStatement = con.prepareStatement(facilityVacateQuery);
            facilityVacateStatement.setString(1, LeaseStatus.TERMINATED.name());
            facilityVacateStatement.setDate(2, DateUtil.convertToSqlDate(vacateDate));
            facilityVacateStatement.setInt(3, facilityId);
            int facilityVacateUpdateResult = facilityVacateStatement.executeUpdate();
            System.out.println("FacilityUsageDAO: *************** Query " + facilityVacateQuery);

            if (facilityVacateUpdateResult > 0) {
                System.out.println("Facility Vacated Successfully !!!");
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("FacilityUsageDAO: Threw a SQLException updating the Lease object.");
            ex.printStackTrace();
            return false;
        } finally {

            try {
                if (facilityVacateStatement != null) {
                    facilityVacateStatement.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FacilityUsageDAO: Threw a SQLException updating the Lease object.");
                System.err.println(ex.getMessage());
            }
        }

        return false;
    }

    public List<Inspection> getListOfInspections(int facilityId) {
        Connection con = DBHelper.getConnection();
        Statement st = null;

        try {
            //Get Inspections
            st = con.createStatement();
            String selectListOfInspectionsQuery = "SELECT inspection_id, inspection_date," +
                    " inspection_result FROM inspection where facility_id = '" + facilityId + "'";

            ResultSet inspectionRS = st.executeQuery(selectListOfInspectionsQuery);
            System.out.println("FacilityUsageDAO: *************** Query " + selectListOfInspectionsQuery);

            List<Inspection> inspectionList = new ArrayList<Inspection>();

            while (inspectionRS.next()) {
                Inspection inspection = new Inspection();
                inspection.setInspectionId(inspectionRS.getInt("inspection_id"));
                inspection.setInspectionDate(DateUtil.convertToUtilDate(inspectionRS.getDate("inspection_date")));
                inspection.setInspectionResult(inspectionRS.getString("inspection_result"));
                inspection.setFacilityId(facilityId);
                inspectionList.add(inspection);
            }
            return inspectionList;
        } catch (SQLException se) {
            System.err.println("FacilityUsageDAO: Threw a SQLException retrieving the Inspection object.");
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
                System.err.println("FacilityUsageDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }
        return null;

    }


    public Map<Integer, Integer> getListOfActualUsage() {
        Connection con = DBHelper.getConnection();
        Statement st = null;

        try {
            //Get actual usages by facility id
            st = con.createStatement();
            String selectListOfActualUsageQuery = "SELECT facility_id," +
                    " SUM(DATEDIFF(termination_date, start_date)) as days_used" +
                    " FROM lease_info GROUP BY facility_id";

            ResultSet usageRS = st.executeQuery(selectListOfActualUsageQuery);
            System.out.println("FacilityUsageDAO: *************** Query " + selectListOfActualUsageQuery +"\n");

            Map<Integer, Integer> actualUsageByFacility = new HashMap<Integer, Integer>();

            while (usageRS.next()) {
                actualUsageByFacility.put(usageRS.getInt("facility_id"), usageRS.getInt("days_used"));
            }
            return actualUsageByFacility;
        } catch (SQLException se) {
            System.err.println("FacilityUsageDAO: Threw a SQLException retrieving actual usage.");
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
                System.err.println("FacilityUsageDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }
        return null;

    }

    public Map<Integer, Double> getUsageRate() {
        Connection con = DBHelper.getConnection();
        Statement st = null;

        try {
            //Get usage rates by facility id
            st = con.createStatement();
            String selectUsageRateQuery = "SELECT facility_id, (days_used*100/365) as usage_rate" +
                    " from (SELECT facility_id, SUM(DATEDIFF(termination_date, start_date)) as days_used" +
                    " FROM lease_info GROUP BY facility_id) as total_usage group by facility_id";

            ResultSet usageRateRS = st.executeQuery(selectUsageRateQuery);
            System.out.println("FacilityUsageDAO: *************** Query " + selectUsageRateQuery +"\n");

            Map<Integer, Double> usageRateByFacility = new HashMap<Integer, Double>();

            while (usageRateRS.next()) {
                usageRateByFacility.put(usageRateRS.getInt("facility_id"), usageRateRS.getDouble("usage_rate"));
            }
            return usageRateByFacility;
        } catch (SQLException se) {
            System.err.println("FacilityUsageDAO: Threw a SQLException retrieving usage rate");
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
                System.err.println("FacilityUsageDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }
        return null;

    }

}
