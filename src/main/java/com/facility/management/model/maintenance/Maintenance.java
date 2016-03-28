package com.facility.management.model.maintenance;

import java.util.Date;

public interface Maintenance {

	Integer getMaintenanceId();

	void setMaintenanceId(Integer maintenanceId);

	MaintenanceRequest getMaintenanceRequest();

	void setMaintenanceRequest(MaintenanceRequest maintenanceRequest);

	String getWorkerName();

	void setWorkerName(String workerName);

	String getWorkerPhone();

	void setWorkerPhone(String workerPhone);

	Date getStartDateTime();

	void setStartDateTime(Date startDateTime);

	Date getEndDateTime();

	void setEndDateTime(Date endDateTime);

	MaintenanceCost getMaintenanceCost();

	void setMaintenanceCost(MaintenanceCost maintenanceCost);

}