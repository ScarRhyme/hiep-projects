package com.hiep.EntitiesRequest;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ProductLocation generated by hbm2java
 */
@Data
public class ProductLocation  {
	
	private int locationProductId;
	
	private int loctionId;
	
	private int produdctId;

	public ProductLocation() {
	}

	public ProductLocation(int locationProductId, int loctionId, int produdctId) {
		this.locationProductId = locationProductId;
		this.loctionId = loctionId;
		this.produdctId = produdctId;
	}



}