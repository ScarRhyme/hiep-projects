package com.hiep.EntitiesRequest;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * MenuType generated by hbm2java
 */

@Data
public class MenuTypeReq implements java.io.Serializable {

	private Integer menuTypeId;

	private String menuName;

	public MenuTypeReq() {
	}

	public MenuTypeReq(String menuName) {
		this.menuName = menuName;
	}

}
