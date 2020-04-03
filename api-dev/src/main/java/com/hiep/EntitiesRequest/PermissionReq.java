package com.hiep.EntitiesRequest;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Permission generated by hbm2java
 */
@Data
public class PermissionReq implements java.io.Serializable {
	
	private int permissionId;

	private String permissionname;

	public PermissionReq() {
	}

	public PermissionReq(int permissionId) {
		this.permissionId = permissionId;
	}

	public PermissionReq(int permissionId, String permissionname) {
		this.permissionId = permissionId;
		this.permissionname = permissionname;
	}


}
