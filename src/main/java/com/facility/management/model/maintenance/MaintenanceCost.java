package com.facility.management.model.maintenance;

import java.math.BigDecimal;

public interface MaintenanceCost {

	Integer getMaintenanceId();

	void setMaintenanceId(Integer maintenanceId);

	Maintenance getMaintenance();

	void setMaintenance(Maintenance maintenance);

	BigDecimal getMaterialCost();

	void setMaterialCost(BigDecimal materialCost);

	BigDecimal getLaborCost();

	void setLaborCost(BigDecimal laborCost);

	BigDecimal getTotalCost();

	void setTotalCost(BigDecimal totalCost);

	String getIsPaid();

	void setIsPaid(String isPaid);

}