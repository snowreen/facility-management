package com.facility.management.dal;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.facility.management.model.facility.Facility;
import com.facility.management.model.facility.FacilityImpl;
import com.facility.management.model.maintenance.Maintenance;
import com.facility.management.model.maintenance.MaintenanceCost;
import com.facility.management.model.maintenance.MaintenanceRequest;
import com.facility.management.model.maintenance.MaintenanceRequestImpl;

public class FacilityMaintenanceHibernateDAO {
	
	public boolean createMaintenanceReq(MaintenanceRequest maintenanceRequest) {
		System.out.println("*************** Createing Maintenance Request in DB with maintenance request ID ...  " + maintenanceRequest.getMainReqId());
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Facility facility = (Facility) session.load(FacilityImpl.class, maintenanceRequest.getFacility().getFacilityId());
		maintenanceRequest.setFacility(facility);
		session.save(maintenanceRequest);
		session.getTransaction().commit();
		return true;
	}
	
	public boolean createMaintenanceSchedule(Maintenance maintenance) {
		System.out.println("*************** Scheduling Maintenance in DB for maintenance request ID ...  " + maintenance.getMaintenanceRequest().getMainReqId());
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		MaintenanceRequest maintenanceRequest = (MaintenanceRequest) session.load(MaintenanceRequestImpl.class, maintenance.getMaintenanceRequest().getMainReqId());
		maintenance.setMaintenanceRequest(maintenanceRequest);
		session.save(maintenance);
		session.getTransaction().commit();
		return true;
	}
	
	public MaintenanceCost getMaintenanceCost(int maintenanceId) {
		System.out.println("*************** Printing Maintenance Cost for maintenance id: " + maintenanceId);
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query maintenanceCostSelectQuery = session.createQuery("select mc from MaintenanceCostImpl mc"
				+ " join mc.maintenance mcm where mcm.maintenanceId = :maintenanceId");
		maintenanceCostSelectQuery.setInteger("maintenanceId", maintenanceId);
		List<MaintenanceCost> maintenanceCostResults = maintenanceCostSelectQuery.list();
		session.getTransaction().commit();
		return maintenanceCostResults.get(0);
	}
	
	public List<MaintenanceRequest> getListOfFacilityMaintenanceReq() {
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query maintenanceRequestSelectQuery = session.createQuery("from MaintenanceRequestImpl");
		List<MaintenanceRequest> maintenanceRequestResults = maintenanceRequestSelectQuery.list();
		session.getTransaction().commit();
		return maintenanceRequestResults;
	}
	
	public List<Maintenance> getListOfMaintenance() {
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query maintenanceSelectQuery = session.createQuery("from MaintenanceImpl");
		List<Maintenance> maintenanceResults = maintenanceSelectQuery.list();
		session.getTransaction().commit();
		return maintenanceResults;
	}
	
	public double getProblemRateForFacility(int facilityId) {
		System.out.println("*************** Calculating Facility Problem Rate for facility id: " + facilityId);
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query facilityProblemByYearSelectQuery = session.createQuery("select year(mr.requestDate), count(*)"
				+ " from MaintenanceRequestImpl mr join mr.facility mrf where mrf.facilityId = :facilityId group by year(mr.requestDate)");
		facilityProblemByYearSelectQuery.setInteger("facilityId", facilityId);
		List<Object[]> facilityProblemByYearResults = facilityProblemByYearSelectQuery.list();
		session.getTransaction().commit();
		Integer totalNumOfYear = 0;
		Long totalNumOfProblem = 0L;
		for (Object[] row : facilityProblemByYearResults) {
		    totalNumOfYear++;
		    Long problemCount = (Long) row[1];
		    totalNumOfProblem += problemCount;
		}
		double problemRate = totalNumOfProblem.doubleValue()/totalNumOfYear.doubleValue();
		return problemRate;
	}
	
	public Long getDownTimeForFacility(int facilityId) {
		System.out.println("*************** Calculating Down time for facility id: " + facilityId);
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query facilityDownTimeSelectQuery = session.createSQLQuery("SELECT SUM(TIMESTAMPDIFF(MINUTE, m.start_date_time, m.end_date_time)) as down_time from"
            		+ " maintenance m, maintenance_request mreq where"
            		+ " m.main_req_id = mreq.main_req_id and mreq.facility_id = :facilityId");
		facilityDownTimeSelectQuery.setInteger("facilityId", facilityId);
		BigDecimal facilityDownTimeResult = (BigDecimal) facilityDownTimeSelectQuery.uniqueResult();
		session.getTransaction().commit();
		return facilityDownTimeResult.longValue();
	}
	
	public List<String> getListOfFacilityProblems(int facilityId) {
		System.out.println("*************** Printing List of Problems for facility id: " + facilityId);
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query facilityProblemsSelectQuery = session.createQuery("select mr.detail from MaintenanceRequestImpl mr"
				+ " join mr.facility mrf where mrf.facilityId = :facilityId");
		facilityProblemsSelectQuery.setInteger("facilityId", facilityId);
		List<String> facilityProblemsResults = facilityProblemsSelectQuery.list();
		session.getTransaction().commit();
		return facilityProblemsResults;
	}
}
