package com.hiep.Entities;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

/**
 * Location generated by hbm2java
 */
public class Location implements java.io.Serializable {

	private Long locationId;
	private String locationName;

	public Location() {
	}

	public Location(String locationName) {
		this.locationName = locationName;
	}

	public Long getLocationId() {
		return this.locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}