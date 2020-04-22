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
 * NewCategory generated by hbm2java
 */

@Data
@Entity
@Table(name = "Category", schema = "dbo", catalog = "hiep")
public class Category implements java.io.Serializable  {
	@Id
	@Column(name = "MenuTypeId")
	private int newCategoryId;
	
	@Basic
	@Column(name = "name")
	private String name;
	
	@Basic
	@Column(name = "meataTittle")
	private String meataTittle;
	
	@Basic
	@Column(name = "parrentId")
	private Integer parrentId;
	
	@Basic
	@Column(name = "displayOrder")
	private Integer displayOrder;
	
	@Basic
	@Column(name = "seoTittle")
	private String seoTittle;
	
	@Basic
	@Column(name = "createdDate")
	private Date createdDate;
	
	@Basic
	@Column(name = "createBy")
	private String createBy;
	
	@Basic
	@Column(name = "modifiedDate")
	private Date modifiedDate;
	
	@Basic
	@Column(name = "metaKeywords")
	private String metaKeywords;
	
	@Basic
	@Column(name = "metaDescription")
	private String metaDescription;
	
	@Basic
	@Column(name = "statuss")
	private Boolean statuss;
	
	@Basic
	@Column(name = "showOnHome")
	private Boolean showOnHome;

	public Category() {
	}

	public Category(int newCategoryId) {
		this.newCategoryId = newCategoryId;
	}

	public Category(int newCategoryId, String name, String meataTittle, Integer parrentId, Integer displayOrder,
			String seoTittle, Date createdDate, String createBy, Date modifiedDate, String metaKeywords,
			String metaDescription, Boolean statuss, Boolean showOnHome) {
		this.newCategoryId = newCategoryId;
		this.name = name;
		this.meataTittle = meataTittle;
		this.parrentId = parrentId;
		this.displayOrder = displayOrder;
		this.seoTittle = seoTittle;
		this.createdDate = createdDate;
		this.createBy = createBy;
		this.modifiedDate = modifiedDate;
		this.metaKeywords = metaKeywords;
		this.metaDescription = metaDescription;
		this.statuss = statuss;
		this.showOnHome = showOnHome;
	}

	public int getNewCategoryId() {
		return this.newCategoryId;
	}

	public void setNewCategoryId(int newCategoryId) {
		this.newCategoryId = newCategoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeataTittle() {
		return this.meataTittle;
	}

	public void setMeataTittle(String meataTittle) {
		this.meataTittle = meataTittle;
	}

	public Integer getParrentId() {
		return this.parrentId;
	}

	public void setParrentId(Integer parrentId) {
		this.parrentId = parrentId;
	}

	public Integer getDisplayOrder() {
		return this.displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getSeoTittle() {
		return this.seoTittle;
	}

	public void setSeoTittle(String seoTittle) {
		this.seoTittle = seoTittle;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getMetaKeywords() {
		return this.metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getMetaDescription() {
		return this.metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public Boolean getStatuss() {
		return this.statuss;
	}

	public void setStatuss(Boolean statuss) {
		this.statuss = statuss;
	}

	public Boolean getShowOnHome() {
		return this.showOnHome;
	}

	public void setShowOnHome(Boolean showOnHome) {
		this.showOnHome = showOnHome;
	}

}
