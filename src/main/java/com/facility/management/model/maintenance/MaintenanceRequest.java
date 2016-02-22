package com.facility.management.model.maintenance;

import java.util.Date;

public class MaintenanceRequest {

    private int maintenanceReqId;
    private int facilityId;
    private String requesterName;
    private String requesterEmail;
    private String requestSubject;
    private String requestDetail;
    private Date scheduledDateTime;

    public int getMaintenanceReqId() {
        return maintenanceReqId;
    }

    public void setMaintenanceReqId(int maintenanceReqId) {
        this.maintenanceReqId = maintenanceReqId;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getRequesterEmail() {
        return requesterEmail;
    }

    public void setRequesterEmail(String requesterEmail) {
        this.requesterEmail = requesterEmail;
    }

    public String getRequestSubject() {
        return requestSubject;
    }

    public void setRequestSubject(String requestSubject) {
        this.requestSubject = requestSubject;
    }

    public String getRequestDetail() {
        return requestDetail;
    }

    public void setRequestDetail(String requestDetail) {
        this.requestDetail = requestDetail;
    }

    public Date getScheduledDateTime() {
        return scheduledDateTime;
    }

    public void setScheduledDateTime(Date scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

	@Override
	public String toString() {
		return "MaintenanceRequest [maintenanceReqId=" + maintenanceReqId
				+ ", facilityId=" + facilityId + ", requesterName="
				+ requesterName + ", requesterEmail=" + requesterEmail
				+ ", requestSubject=" + requestSubject + ", requestDetail="
				+ requestDetail + ", scheduledDateTime=" + scheduledDateTime
				+ "]";
	}
}
