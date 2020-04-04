package com.hiep.Entities;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Location generated by hbm2java
 */
@Data
@Entity
@Table(name = "Location", schema = "dbo", catalog = "hiep")
public class Location implements java.io.Serializable  {
	@Id
	@Column(name = "AboutId")
	private Long locationId;
	
	@Basic
	@Column(name = "LocationName")
	private String locationName;
	@Basic
	@Column(name = "StartTime")
	private Date startTime;
	@Basic
	@Column(name = "EndTime")
	private Date endTime;
	@Basic
	@Column(name = "Description")
	private String description;

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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
