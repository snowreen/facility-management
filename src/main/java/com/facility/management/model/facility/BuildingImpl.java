package com.facility.management.model.facility;

public class BuildingImpl implements Building {
	
	private Integer buildingId;
	private Facility facility;
	private Integer numOfElevators;
	private Integer numOfFloors;
	private Integer numOfEntrance;

	public BuildingImpl() {
	}

	/*public BuildingImpl(Facility facility, Integer numOfElevators,
			Integer numOfFloors, Integer numOfEntrance) {
		this.facility = facility;
		this.numOfElevators = numOfElevators;
		this.numOfFloors = numOfFloors;
		this.numOfEntrance = numOfEntrance;
	}*/

	/* (non-Javadoc)
	 * @see com.facility.management.model.Building#getBuildingId()
	 */
	@Override
	public Integer getBuildingId() {
		return this.buildingId;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Building#setBuildingId(java.lang.Integer)
	 */
	@Override
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Building#getFacility()
	 */
	@Override
	public Facility getFacility() {
		return this.facility;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Building#setFacility(com.facility.management.model.FacilityImpl)
	 */
	@Override
	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Building#getNumOfElevators()
	 */
	@Override
	public Integer getNumOfElevators() {
		return this.numOfElevators;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Building#setNumOfElevators(java.lang.Integer)
	 */
	@Override
	public void setNumOfElevators(Integer numOfElevators) {
		this.numOfElevators = numOfElevators;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Building#getNumOfFloors()
	 */
	@Override
	public Integer getNumOfFloors() {
		return this.numOfFloors;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Building#setNumOfFloors(java.lang.Integer)
	 */
	@Override
	public void setNumOfFloors(Integer numOfFloors) {
		this.numOfFloors = numOfFloors;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Building#getNumOfEntrance()
	 */
	@Override
	public Integer getNumOfEntrance() {
		return this.numOfEntrance;
	}

	/* (non-Javadoc)
	 * @see com.facility.management.model.Building#setNumOfEntrance(java.lang.Integer)
	 */
	@Override
	public void setNumOfEntrance(Integer numOfEntrance) {
		this.numOfEntrance = numOfEntrance;
	}

}
