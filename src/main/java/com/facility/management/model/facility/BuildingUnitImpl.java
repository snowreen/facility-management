package com.facility.management.model.facility;

public class BuildingUnitImpl implements BuildingUnit {
	
	private Integer unitId;
	private Building building;
	private Facility facility;
	private Integer levelNum;
	private Integer numOfRooms;

	public BuildingUnitImpl() {
	}

	/*public BuildingUnitImpl(BuildingImpl building, Facility facility, Integer levelNum,
			Integer numOfRooms) {
		this.building = building;
		this.facility = facility;
		this.levelNum = levelNum;
		this.numOfRooms = numOfRooms;
	}*/

	/* (non-Javadoc)
	 * @see com.facility.management.model.BuildingUnit#getUnitId()
	 */
	@Override
	public Integer getUnitId() {
		return this.unitId;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.BuildingUnit#setUnitId(java.lang.Integer)
	 */
	@Override
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.BuildingUnit#getBuilding()
	 */
	@Override
	public Building getBuilding() {
		return this.building;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.BuildingUnit#setBuilding(com.facility.management.model.Building)
	 */
	@Override
	public void setBuilding(Building building) {
		this.building = building;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.BuildingUnit#getFacility()
	 */
	@Override
	public Facility getFacility() {
		return this.facility;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.BuildingUnit#setFacility(com.facility.management.model.FacilityImpl)
	 */
	@Override
	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.BuildingUnit#getLevelNum()
	 */
	@Override
	public Integer getLevelNum() {
		return this.levelNum;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.BuildingUnit#setLevelNum(java.lang.Integer)
	 */
	@Override
	public void setLevelNum(Integer levelNum) {
		this.levelNum = levelNum;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.BuildingUnit#getNumOfRooms()
	 */
	@Override
	public Integer getNumOfRooms() {
		return this.numOfRooms;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.BuildingUnit#setNumOfRooms(java.lang.Integer)
	 */
	@Override
	public void setNumOfRooms(Integer numOfRooms) {
		this.numOfRooms = numOfRooms;
	}

}
