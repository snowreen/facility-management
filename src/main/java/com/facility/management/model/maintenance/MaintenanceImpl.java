package com.facility.management.model.maintenance;

import java.util.Date;


public class MaintenanceImpl implements Maintenance {
	
	private Integer maintenanceId;
	private MaintenanceRequest maintenanceRequest;
	private String workerName;
	private String workerPhone;
	private Date startDateTime;
	private Date endDateTime;
	private MaintenanceCost maintenanceCost;

	public MaintenanceImpl() {
	}

	public MaintenanceImpl(MaintenanceRequest maintenanceRequest, String workerName,
			String workerPhone, Date startDateTime, Date endDateTime,
			MaintenanceCost maintenanceCost) {
		this.maintenanceRequest = maintenanceRequest;
		this.workerName = workerName;
		this.workerPhone = workerPhone;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.maintenanceCost = maintenanceCost;
	}
	
	@Override
	public Integer getMaintenanceId() {
		return this.maintenanceId;
	}
	
	@Override
	public void setMaintenanceId(Integer maintenanceId) {
		this.maintenanceId = maintenanceId;
	}
	
	@Override
	public MaintenanceRequest getMaintenanceRequest() {
		return this.maintenanceRequest;
	}
	
	@Override
	public void setMaintenanceRequest(MaintenanceRequest maintenanceRequest) {
		this.maintenanceRequest = maintenanceRequest;
	}
	
	@Override
	public String getWorkerName() {
		return this.workerName;
	}
	
	@Override
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	
	@Override
	public String getWorkerPhone() {
		return this.workerPhone;
	}
	
	@Override
	public void setWorkerPhone(String workerPhone) {
		this.workerPhone = workerPhone;
	}
	
	@Override
	public Date getStartDateTime() {
		return this.startDateTime;
	}
	
	@Override
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	
	@Override
	public Date getEndDateTime() {
		return this.endDateTime;
	}
	
	@Override
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	@Override
	public MaintenanceCost getMaintenanceCost() {
		return this.maintenanceCost;
	}
	
	@Override
	public void setMaintenanceCost(MaintenanceCost maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}

	@Override
	public String toString() {
		return "MaintenanceImpl [maintenanceId=" + maintenanceId
				+ ", maintenanceRequestId=" + maintenanceRequest.getMainReqId() + ", workerName="
				+ workerName + ", workerPhone=" + workerPhone
				+ ", startDateTime=" + startDateTime + ", endDateTime="
				+ endDateTime + "]";
	}

}
