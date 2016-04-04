package com.facility.management.dal;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.facility.management.model.facility.Facility;
import com.facility.management.model.facility.FacilityImpl;
import com.facility.management.model.usage.Inspection;
import com.facility.management.model.usage.LeaseInfo;
import com.facility.management.model.usage.LeaseStatus;
import com.facility.management.model.usage.Tenant;
import com.facility.management.model.usage.TenantImpl;

public class FacilityUsageHibernateDAO {
	
	public boolean assignFacilityToUse(LeaseInfo leaseInfo) {
		System.out.println("*************** Adding Lease detail information in DB with ID ...  " + leaseInfo.getLeaseId());
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Facility facility = (Facility) session.load(FacilityImpl.class, leaseInfo.getFacility().getFacilityId());
		leaseInfo.setFacility(facility);
		Tenant tenant = (Tenant) session.load(TenantImpl.class, leaseInfo.getTenant().getTenantId());
		leaseInfo.setTenant(tenant);
		session.save(leaseInfo);
		session.getTransaction().commit();
		return true;
	}
	
	public boolean isInUseDuringInterval(int facilityId, Date beginDate, Date endDate) {
		System.out.println("*************** Checking if facility is in use from " + beginDate + " to " + endDate);
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query leaseInfoQuery = session.createQuery("select count(*) FROM LeaseInfoImpl li join li.facility lif"
				+ " where lif.facilityId = :id and li.endDate >= :beginDate and li.startDate <= :endDate"
				+ " and li.status = :status");		
		leaseInfoQuery.setInteger("id", facilityId);
		leaseInfoQuery.setDate("beginDate", beginDate);
		leaseInfoQuery.setDate("endDate", endDate);
		leaseInfoQuery.setString("status", LeaseStatus.ACTIVE.name());
		
		Long leaseCount = (Long) leaseInfoQuery.uniqueResult();
		session.getTransaction().commit();
		if (leaseCount != null && leaseCount > 0) {
			return true;
		}
		return false;
	}
	
	public boolean vacateFacility(int facilityId, Date vacateDate) {
		System.out.println("*************** Vacating facility with id " + facilityId);
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query leaseIdSelectQuery = session.createQuery("select li.leaseId from LeaseInfoImpl li"
				+ " join li.facility lif where lif.facilityId = :facilityId");
		leaseIdSelectQuery.setInteger("facilityId", facilityId);
		Integer leaseId = (Integer) leaseIdSelectQuery.uniqueResult();
		Query leaseInfoUpdateQuery = session.createQuery("update LeaseInfoImpl l set l.status = :status,"
				+ " l.terminationDate = :vacateDate where l.leaseId = :leaseId");		
		leaseInfoUpdateQuery.setString("status", LeaseStatus.TERMINATED.name());
		leaseInfoUpdateQuery.setDate("vacateDate", vacateDate);
		leaseInfoUpdateQuery.setInteger("leaseId", leaseId);
		int updatedRow = leaseInfoUpdateQuery.executeUpdate();
		session.getTransaction().commit();
		if (updatedRow > 0) {
			return true;
		}
		return false;
		
	}
	
	public List<Inspection> getListOfInspections(int facilityId) {
		System.out.println("*************** Printing all inspections for facility id: " + facilityId);
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query inspectionsSelectQuery = session.createQuery("select i from InspectionImpl i"
				+ " join i.facility ifac where ifac.facilityId = :facilityId");
		inspectionsSelectQuery.setInteger("facilityId", facilityId);
		List<Inspection> inspectionResults = inspectionsSelectQuery.list();
		session.getTransaction().commit();
		return inspectionResults;
	}
	
	public Map<Integer, Long> getListOfActualUsage() {
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query leaseInfoSelectQuery = session.createQuery("select lif.facilityId," +
                " sum(datediff(li.terminationDate, li.startDate)) as daysUsed" +
                " FROM LeaseInfoImpl li join li.facility lif group by lif.facilityId");
		List<Object[]> usageResults = leaseInfoSelectQuery.list();
		session.getTransaction().commit();
		Map<Integer, Long> actualUsageByFacility = new HashMap<Integer, Long>();
		for (Object[] row : usageResults) {
		    Integer facilityId = (Integer) row[0];
		    Long sum = (Long) row[1];
		    actualUsageByFacility.put(facilityId, sum);
		}
		return actualUsageByFacility;
	}
	
	public Map<Integer, Double> getUsageRate() {
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query leaseInfoSelectQuery = session.createQuery("select lif.facilityId," +
                " sum(datediff(li.terminationDate, li.startDate)) as daysUsed" +
                " FROM LeaseInfoImpl li join li.facility lif group by lif.facilityId");
		List<Object[]> usageResults = leaseInfoSelectQuery.list();
		session.getTransaction().commit();
		Map<Integer, Double> usageRateByFacility = new HashMap<Integer, Double>();
		for (Object[] row : usageResults) {
		    Integer facilityId = (Integer) row[0];
		    Long daysUsed = (Long) row[1];
		    Double usageRate = (daysUsed.doubleValue()*100) / 365;
		    usageRateByFacility.put(facilityId, usageRate);
		}
		return usageRateByFacility;
		
	}

}
