package com.facility.management.model.maintenance;

import java.math.BigDecimal;

public class MaintenanceCostImpl implements MaintenanceCost {
	
	private Integer maintenanceId;
	private Maintenance maintenance;
	private BigDecimal materialCost;
	private BigDecimal laborCost;
	private BigDecimal totalCost;
	private String isPaid;

	public MaintenanceCostImpl() {
	}

	public MaintenanceCostImpl(Maintenance maintenance) {
		this.maintenance = maintenance;
	}

	public MaintenanceCostImpl(Maintenance maintenance, BigDecimal materialCost,
			BigDecimal laborCost, BigDecimal totalCost, String isPaid) {
		this.maintenance = maintenance;
		this.materialCost = materialCost;
		this.laborCost = laborCost;
		this.totalCost = totalCost;
		this.isPaid = isPaid;
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
	public Maintenance getMaintenance() {
		return this.maintenance;
	}
	
	@Override
	public void setMaintenance(Maintenance maintenance) {
		this.maintenance = maintenance;
	}
	
	@Override
	public BigDecimal getMaterialCost() {
		return this.materialCost;
	}
	
	@Override
	public void setMaterialCost(BigDecimal materialCost) {
		this.materialCost = materialCost;
	}
	
	@Override
	public BigDecimal getLaborCost() {
		return this.laborCost;
	}
	
	@Override
	public void setLaborCost(BigDecimal laborCost) {
		this.laborCost = laborCost;
	}
	
	@Override
	public BigDecimal getTotalCost() {
		return this.totalCost;
	}
	
	@Override
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	
	@Override
	public String getIsPaid() {
		return this.isPaid;
	}
	
	@Override
	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	@Override
	public String toString() {
		return "MaintenanceCostImpl [maintenanceId=" + maintenanceId
				+ ", materialCost="
				+ materialCost + ", laborCost=" + laborCost + ", totalCost="
				+ totalCost + ", isPaid=" + isPaid + "]";
	}

}
