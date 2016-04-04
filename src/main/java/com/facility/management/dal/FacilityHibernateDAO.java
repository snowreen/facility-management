package com.facility.management.dal;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.facility.management.model.facility.Building;
import com.facility.management.model.facility.BuildingImpl;
import com.facility.management.model.facility.BuildingUnit;
import com.facility.management.model.facility.Facility;
import com.facility.management.model.facility.FacilityDetail;
import com.facility.management.model.facility.FacilityImpl;
import com.facility.management.model.facility.FacilityType;

public class FacilityHibernateDAO {
	
	public void addFacility(Facility facility) {
		System.out.println("*************** Adding facility information in DB with ID ...  " + facility.getFacilityId());
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(facility);
		session.getTransaction().commit();
	}
	
	public void deleteFacility(Facility facility) {
		System.out.println("*************** Deleting facility information in DB with ID ...  " + facility.getFacilityId());
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(facility);
		session.getTransaction().commit();
	}
	
	public void addBuildingDetails(Building building) {
		System.out.println("*************** Adding Building detail information in DB with ID ...  " + building.getBuildingId());
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Facility facility = (Facility) session.load(FacilityImpl.class, building.getFacility().getFacilityId());
		building.setFacility(facility);
		session.save(building);
		session.getTransaction().commit();
	}
	
	public void addBuildingUnitDetails(BuildingUnit buildingUnit) {
		System.out.println("*************** Adding Building Unit detail information in DB with ID ...  " + buildingUnit.getUnitId());
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Facility facility = (Facility) session.load(FacilityImpl.class, buildingUnit.getFacility().getFacilityId());
		buildingUnit.setFacility(facility);
		Building building = (Building) session.load(BuildingImpl.class, buildingUnit.getBuilding().getBuildingId());
		buildingUnit.setBuilding(building);
		session.save(buildingUnit);
		session.getTransaction().commit();
	}
	
	public FacilityDetail getFacilityInfo(int facilityId) {
		FacilityDetail facilityDetail = null;
		System.out.println("*************** Retrieving Facility Type for ID ...  " + facilityId);
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query facilityTypeQuery = session.createQuery("select fc.facilityType from FacilityImpl fc where fc.facilityId = :id");		
		facilityTypeQuery.setInteger("id", facilityId);
		String facilityType = (String) facilityTypeQuery.uniqueResult();
		System.out.println("Facility type is --- " + facilityType);
		if (facilityType.equals(FacilityType.BUILDING.name())) {
			Query buildingQuery = session.createQuery("select b from BuildingImpl b join b.facility bf join bf.facilityAddress where bf.facilityId = :id");		
			buildingQuery.setInteger("id", facilityId);
			List<Building> buildingResult = (List<Building>) buildingQuery.list();
			facilityDetail = buildingResult.get(0);
		} else if (facilityType.equals(FacilityType.UNIT.name())) {
			Query buildingUnitQuery = session.createQuery("select u from BuildingUnitImpl u join u.facility uf join uf.facilityAddress where uf.facilityId = :id");		
			buildingUnitQuery.setInteger("id", facilityId);
			List<BuildingUnit> buildingUnitResult = (List<BuildingUnit>) buildingUnitQuery.list();
			facilityDetail = buildingUnitResult.get(0);
		}
		session.getTransaction().commit();
		return facilityDetail;
    }
	
	public List<Facility> getListOfFacilities() {
		System.out.println("*************** Retrieving All Facilities available in Database ...  ");
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query facilityQuery = session.createQuery("from FacilityImpl f");
		List<Facility> facilities = (List<Facility>) facilityQuery.list();
		return facilities;
	}
	
	public Integer getAvailableCapacity(int facilityId) {
		Session session = HibernateMYSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query facilityCapacityQuery = session.createQuery("select fc.capacity from FacilityImpl fc where fc.facilityId = :id");
		facilityCapacityQuery.setInteger("id", facilityId);
		Integer capacity = (Integer) facilityCapacityQuery.uniqueResult();
		return capacity;
	}
}
