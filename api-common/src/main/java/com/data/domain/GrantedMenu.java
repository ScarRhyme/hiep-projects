package com.data.domain;

import java.io.Serializable;
public class GrantedMenu implements Serializable{
	
	private static final long serialVersionUID = 6128016096756071380L;

	private Long sysMenuId;
	private String code;
	private String name;
	private String url;
	private Long sortOrder;
	private Long parentId;
	private Long resourceKey;

	public Long getSysMenuId() {
		return sysMenuId;
	}

	public void setSysMenuId(Long sysMenuId) {
		this.sysMenuId = sysMenuId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getResourceKey() {
		return resourceKey;
	}

	public void setResourceKey(Long resourceKey) {
		this.resourceKey = resourceKey;
	}

	@Override
	public String toString() {
		return "GrantedMenu [sysMenuId=" + sysMenuId + ", code=" + code + ", name=" + name + ", url=" + url
				+ ", sortOrder=" + sortOrder + ", parentId=" + parentId + ", resourceKey=" + resourceKey + "]";
	}
	
	
}
