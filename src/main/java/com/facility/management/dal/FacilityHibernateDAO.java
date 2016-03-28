package com.facility.management.dal;

import org.hibernate.Session;

import com.facility.management.model.facility.Building;
import com.facility.management.model.facility.BuildingImpl;
import com.facility.management.model.facility.BuildingUnit;
import com.facility.management.model.facility.Facility;
import com.facility.management.model.facility.FacilityImpl;

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
	
}
