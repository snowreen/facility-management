package com.facility.management.model.maintenance;

import java.util.Date;

public class Maintenance {

    private int maintenanceId;
    private int maintenanceReqId;
    private String workerName;
    private String workerPhoneNum;
    private Date startDateTime;
    private Date endDateTime;

    public int getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public int getMaintenanceReqId() {
        return maintenanceReqId;
    }

    public void setMaintenanceReqId(int maintenanceReqId) {
        this.maintenanceReqId = maintenanceReqId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerPhoneNum() {
        return workerPhoneNum;
    }

    public void setWorkerPhoneNum(String workerPhoneNum) {
        this.workerPhoneNum = workerPhoneNum;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }
}
