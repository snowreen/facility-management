package com.facility.management.dal;

import com.facility.management.model.maintenance.Maintenance;
import com.facility.management.model.maintenance.MaintenanceCost;
import com.facility.management.model.maintenance.MaintenanceRequest;
import com.facility.management.util.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FacilityMaintenanceDAO {

    public boolean createMaintenanceReq(MaintenanceRequest maintenanceRequest) {
        Connection con = DBHelper.getConnection();
        PreparedStatement mainReqSt = null;

        try {
            //Insert the Maintenance Req object

            String maintenanceReqInsertQuery = "INSERT INTO maintenance_request (main_req_id, scheduled_date_time, facility_id, name_of_requester, detail, email, subject) VALUES (?, ?, ?, ?, ?, ?, ?);";
            mainReqSt = con.prepareStatement(maintenanceReqInsertQuery);
            mainReqSt.setInt(1, maintenanceRequest.getMaintenanceReqId());
            mainReqSt.setString(2, DateUtil.getStringDateTime(maintenanceRequest.getScheduledDateTime()));
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

}
