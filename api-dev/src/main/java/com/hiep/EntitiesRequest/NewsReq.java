package com.hiep.EntitiesRequest;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * News generated by hbm2java
 */
@Data
public class NewsReq implements java.io.Serializable {
	
	private int newId;
	
	private String tittle;

	private String metaTittle;

	private String descriptions;
	
	private String newImage;
	
	private Integer newCategodyId;
	
	private String detail;
	
	private Date createdDate;

	private String createBy;

	private Date modifiedDate;
	
	private String metaKeywords;
	
	private String metaDescription;

	private Boolean statuss;
	
	private Date topHot;
	
	private Integer viewCount;

	private String tagId;

	public NewsReq() {
	}

	public NewsReq(int newId) {
		this.newId = newId;
	}

	public NewsReq(int newId, String tittle, String metaTittle, String descriptions, String newImage,
			Integer newCategodyId, String detail, Date createdDate, String createBy, Date modifiedDate,
			String metaKeywords, String metaDescription, Boolean statuss, Date topHot, Integer viewCount,
			String tagId) {
		this.newId = newId;
		this.tittle = tittle;
		this.metaTittle = metaTittle;
		this.descriptions = descriptions;
		this.newImage = newImage;
		this.newCategodyId = newCategodyId;
		this.detail = detail;
		this.createdDate = createdDate;
		this.createBy = createBy;
		this.modifiedDate = modifiedDate;
		this.metaKeywords = metaKeywords;
		this.metaDescription = metaDescription;
		this.statuss = statuss;
		this.topHot = topHot;
		this.viewCount = viewCount;
		this.tagId = tagId;
	}

	
}
