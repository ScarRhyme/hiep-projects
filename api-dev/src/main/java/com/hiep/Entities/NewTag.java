package com.hiep.Entities;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

/**
 * NewTag generated by hbm2java
 */
public class NewTag implements java.io.Serializable {

	private int newId;
	private String tagId;

	public NewTag() {
	}

	public NewTag(int newId) {
		this.newId = newId;
	}

	public NewTag(int newId, String tagId) {
		this.newId = newId;
		this.tagId = tagId;
	}

	public int getNewId() {
		return this.newId;
	}

	public void setNewId(int newId) {
		this.newId = newId;
	}

	public String getTagId() {
		return this.tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

}