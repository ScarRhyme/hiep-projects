package com.hiep.EntitiesRequest;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Menu generated by hbm2java
 */

@Data
public class MenuReq  {

	private int menuId;

	private String texts;

	private String link;

	private Integer displayOrder;

	private String target;

	private Boolean statuss;

	private Integer menuTypeId;

	private Integer menuParrenId;

	public MenuReq() {
	}

	public MenuReq(int menuId) {
		this.menuId = menuId;
	}

	public MenuReq(int menuId, String texts, String link, Integer displayOrder, String target, Boolean statuss,
			Integer menuTypeId, Integer menuParrenId) {
		this.menuId = menuId;
		this.texts = texts;
		this.link = link;
		this.displayOrder = displayOrder;
		this.target = target;
		this.statuss = statuss;
		this.menuTypeId = menuTypeId;
		this.menuParrenId = menuParrenId;
	}

}
