package com.hiep.Entities;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

/**
 * Permission generated by hbm2java
 */
public class Permission implements java.io.Serializable {

	private int permissionId;
	private String permissionname;

	public Permission() {
	}

	public Permission(int permissionId) {
		this.permissionId = permissionId;
	}

	public Permission(int permissionId, String permissionname) {
		this.permissionId = permissionId;
		this.permissionname = permissionname;
	}

	public int getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionname() {
		return this.permissionname;
	}

	public void setPermissionname(String permissionname) {
		this.permissionname = permissionname;
	}

}