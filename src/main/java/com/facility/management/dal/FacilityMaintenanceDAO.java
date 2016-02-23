package com.facility.management.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.facility.management.model.maintenance.Maintenance;
import com.facility.management.model.maintenance.MaintenanceCost;
import com.facility.management.model.maintenance.MaintenanceRequest;
import com.facility.management.util.DateUtil;

public class FacilityMaintenanceDAO {

    public boolean createMaintenanceReq(MaintenanceRequest maintenanceRequest) {
        Connection con = DBHelper.getConnection();
        PreparedStatement mainReqSt = null;

        try {
            //Insert the Maintenance Req object

            String maintenanceReqInsertQuery = "INSERT INTO maintenance_request (main_req_id, request_date, facility_id, name_of_requester, detail, email, subject) VALUES (?, ?, ?, ?, ?, ?, ?);";
            mainReqSt = con.prepareStatement(maintenanceReqInsertQuery);
            mainReqSt.setInt(1, maintenanceRequest.getMaintenanceReqId());
            mainReqSt.setString(2, DateUtil.getStringDateTime(maintenanceRequest.getRequestDate()));
            mainReqSt.setInt(3, maintenanceRequest.getFacilityId());
            mainReqSt.setString(4, maintenanceRequest.getRequesterName());
            mainReqSt.setString(5, maintenanceRequest.getRequestDetail());
            mainReqSt.setString(6, maintenanceRequest.getRequesterEmail());
            mainReqSt.setString(7, maintenanceRequest.getRequestSubject());

            int mainReqInsertResult = mainReqSt.executeUpdate();
            System.out.println("FacilityMaintenanceDAO: *************** Query " + maintenanceReqInsertQuery);

            if (mainReqInsertResult > 0) {
                System.out.println("Maintenance Req Inserted Successfully");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {

            try {
                if (mainReqSt != null) {
                    mainReqSt.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FacilityMaintenanceDAO: Threw a SQLException saving the Maintenance Req object.");
                System.err.println(ex.getMessage());
            }
        }

        return false;
    }

    public boolean createMaintenanceSchedule(Maintenance maintenance) {
        Connection con = DBHelper.getConnection();
        PreparedStatement mainSt = null;

        try {
            //Insert the Maintenance object

            String maintenanceInsertQuery = "INSERT INTO maintenance (maintenance_id, start_date_time, end_date_time, main_req_id, worker_name, worker_phone) VALUES (?, ?, ?, ?, ?, ?);";
            mainSt = con.prepareStatement(maintenanceInsertQuery);
            mainSt.setInt(1, maintenance.getMaintenanceId());
            mainSt.setString(2, DateUtil.getStringDateTime(maintenance.getStartDateTime()));
            mainSt.setString(3, DateUtil.getStringDateTime(maintenance.getEndDateTime()));
            mainSt.setInt(4, maintenance.getMaintenanceReqId());
            mainSt.setString(5, maintenance.getWorkerName());
            mainSt.setString(6, maintenance.getWorkerPhoneNum());

            int mainInsertResult = mainSt.executeUpdate();
            System.out.println("FacilityMaintenanceDAO: *************** Query " + maintenanceInsertQuery);

            if (mainInsertResult > 0) {
                System.out.println("Maintenance Scheduled Successfully");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {

            try {
                if (mainSt != null) {
                    mainSt.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FacilityMaintenanceDAO: Threw a SQLException saving the Maintenance object.");
                System.err.println(ex.getMessage());
            }
        }

        return false;
    }

    public boolean createMaintenanceCost(MaintenanceCost maintenanceCost) {
        Connection con = DBHelper.getConnection();
        PreparedStatement mainCostSt = null;

        try {
            //Insert the Maintenance Cost object

            String maintenanceCostInsertQuery = "INSERT INTO maintenance_cost (maintenance_id, material_cost, labor_cost, total_cost, is_paid) VALUES (?, ?, ?, ?, ?);";
            mainCostSt = con.prepareStatement(maintenanceCostInsertQuery);
            mainCostSt.setInt(1, maintenanceCost.getMaintenanceId());
            mainCostSt.setDouble(2, maintenanceCost.getMaterialCost());
            mainCostSt.setDouble(3, maintenanceCost.getLaborCost());
            mainCostSt.setDouble(4, maintenanceCost.getTotalCost());
            mainCostSt.setBoolean(5, maintenanceCost.isPaid());

            int mainCostInsertResult = mainCostSt.executeUpdate();
            System.out.println("FacilityMaintenanceDAO: *************** Query " + maintenanceCostInsertQuery);

            if (mainCostInsertResult > 0) {
                System.out.println("Maintenance Cost inserted Successfully");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {

            try {
                if (mainCostSt != null) {
                    mainCostSt.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FacilityMaintenanceDAO: Threw a SQLException saving the Maintenance Cost object.");
                System.err.println(ex.getMessage());
            }
        }

        return false;
    }
    
    
    public List<MaintenanceRequest> getListOfFacilityMaintenanceReq() {
        Connection con = DBHelper.getConnection();
        Statement st = null;

        try {
            //Get facility type
            st = con.createStatement();
            String selectListOfMaintenanceReqTypeQuery = "SELECT main_req_id, facility_id, name_of_requester, detail, email, subject, request_date  FROM maintenance_request";

            ResultSet facilityMainReqRS = st.executeQuery(selectListOfMaintenanceReqTypeQuery);
            System.out.println("FacilityMaintenanceDAO: *************** Query " + selectListOfMaintenanceReqTypeQuery);

            List<MaintenanceRequest> facilityMainReqList = new ArrayList<MaintenanceRequest>();

            while (facilityMainReqRS.next()) {
                MaintenanceRequest maintenceRequest = new MaintenanceRequest();
                maintenceRequest.setMaintenanceReqId(facilityMainReqRS.getInt("main_req_id"));
                maintenceRequest.setRequestDate(facilityMainReqRS.getTimestamp("request_date"));
                maintenceRequest.setFacilityId(facilityMainReqRS.getInt("facility_id"));
                maintenceRequest.setRequesterName(facilityMainReqRS.getString("name_of_requester"));
                maintenceRequest.setRequestDetail(facilityMainReqRS.getString("detail"));
                maintenceRequest.setRequesterEmail(facilityMainReqRS.getString("email"));
                maintenceRequest.setRequestSubject(facilityMainReqRS.getString("subject"));
                facilityMainReqList.add(maintenceRequest);
            }
            return facilityMainReqList;
        } catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facilityMaintenance object.");
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
                System.err.println("FacilityMaintenanceDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }
        return null;

    }
    
    public List<Maintenance> getListOfMaintenance() {
        Connection con = DBHelper.getConnection();
        Statement st = null;

        try {
            //Get facility type
            st = con.createStatement();
            String selectListOfMaintenanceTypeQuery = "SELECT maintenance_id, worker_name, worker_phone, start_date_time, end_date_time, main_req_id FROM maintenance";

            ResultSet facilityMainListRS = st.executeQuery(selectListOfMaintenanceTypeQuery);
            System.out.println("FacilityMaintenanceDAO: *************** Query " + selectListOfMaintenanceTypeQuery);

            List<Maintenance> facilityMaintenanceList = new ArrayList<Maintenance>();

            while (facilityMainListRS.next()) {
            	Maintenance maintenance = new Maintenance();
            	maintenance.setMaintenanceId(facilityMainListRS.getInt("maintenance_id"));
            	maintenance.setWorkerName(facilityMainListRS.getString("worker_name"));
            	maintenance.setWorkerPhoneNum(facilityMainListRS.getString("worker_phone"));
            	maintenance.setStartDateTime(facilityMainListRS.getTimestamp("start_date_time"));
            	maintenance.setEndDateTime(facilityMainListRS.getTimestamp("end_date_time"));
            	maintenance.setMaintenanceReqId(facilityMainListRS.getInt("main_req_id"));
                facilityMaintenanceList.add(maintenance);
            }
            return facilityMaintenanceList;
        } catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facilityMaintenance object.");
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
                System.err.println("FacilityMaintenanceDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }
        return null;

    }
    
    public double getProblemRateForFacility(int facilityId) {
        Connection con = DBHelper.getConnection();
        Statement st = null;

        try {
            //Get facility type
            st = con.createStatement();
            String selectProblemRateQuery = "select sum(req_per_year.cnt)/count(yr) as prblm_rate from (select year(request_date) as "
            		+ "yr, count(1) as cnt from maintenance_request where facility_id = '" + facilityId +"' group by yr) as req_per_year";
            ResultSet problemRateRS = st.executeQuery(selectProblemRateQuery);
            System.out.println("FacilityMaintenanceDAO: *************** Query " + selectProblemRateQuery);
            
            double prblmRate = 0;
            
            if (problemRateRS.next()) {
            	prblmRate = problemRateRS.getDouble("prblm_rate");
            }
            
            return prblmRate;
        } catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the problem rate.");
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
                System.err.println("FacilityMaintenanceDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }
        return 0;

    }
    
    public Long getDownTimeForFacility(int facilityId) {
        Connection con = DBHelper.getConnection();
        Statement st = null;

        try {
            //Get facility type
            st = con.createStatement();
            String selectDownTimeQuery = "SELECT SUM(TIMESTAMPDIFF(MINUTE, m.start_date_time, m.end_date_time)) as down_time from"
            		+ " maintenance m, maintenance_request mreq where"
            		+ " m.main_req_id = mreq.main_req_id and mreq.facility_id = '" + facilityId + "'";
            ResultSet downTimeRS = st.executeQuery(selectDownTimeQuery);
            System.out.println("FacilityMaintenanceDAO: *************** Query " + selectDownTimeQuery);
            
            long downTime = 0;
            
            if (downTimeRS.next()) {
            	downTime = downTimeRS.getLong("down_time");
            }
            
            return downTime;
        } catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the down time.");
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
                System.err.println("FacilityMaintenanceDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }
        return 0L;

    }
    
    public List<String> getListOfFacilityProblems(int facilityId) {
        Connection con = DBHelper.getConnection();
        Statement st = null;

        try {
            //Get facility type
            st = con.createStatement();
            String selectListOfProblemsQuery = "SELECT detail FROM maintenance_request where facility_id = '" + facilityId + "'";

            ResultSet facilityProblemRS = st.executeQuery(selectListOfProblemsQuery);
            System.out.println("FacilityMaintenanceDAO: *************** Query " + selectListOfProblemsQuery);

            List<String> problemList = new ArrayList<String>();

            while (facilityProblemRS.next()) {
            	problemList.add(facilityProblemRS.getString("detail"));
            }
            return problemList;
        } catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving problem details");
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
                System.err.println("FacilityMaintenanceDAO: Threw a SQLException");
                System.err.println(ex.getMessage());
            }
        }
        return null;

    }

}
