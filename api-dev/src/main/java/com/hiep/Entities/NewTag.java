package com.hiep.Entities;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * NewTag generated by hbm2java
 */
@Data
@Entity
@Table(name = "NewTag", schema = "dbo", catalog = "hiep")
public class NewTag implements java.io.Serializable  {
	@Id
	@Column(name = "NewId")
	private int newTagID;
	@Basic
	@Column(name = "NewId")
	private int newId;
	@Basic
	@Column(name = "TagId")
	private int tagId;

	public NewTag() {
	}

	public NewTag(int newTagID) {
		this.newTagID = newTagID;
	}

	public NewTag(int newTagID,int newId, int tagId) {
		this.newId = newId;
		this.tagId = tagId;
		this.newTagID= newTagID;
	}

	public int getNewId() {
		return this.newId;
	}

	public void setNewId(int newId) {
		this.newId = newId;
	}

	public int getTagId() {
		return this.tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

}
