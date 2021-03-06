package com.hiep.Entities;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Users generated by hbm2java
 */
@Data
@Entity
@Table(name = "ActionActive", schema = "dbo", catalog = "hiep")
public class Users implements java.io.Serializable {
	@Id
	@Column(name = "UserId")
	private String userId;
	@Basic
	@Column(name = "Password")
	private String password;
	@Basic
	@Column(name = "RoleId")
	private Integer roleId;

	public Users() {
	}

	public Users(String userId) {
		this.userId = userId;
	}

	public Users(String userId, String password, Integer roleId) {
		this.userId = userId;
		this.password = password;
		this.roleId = roleId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
