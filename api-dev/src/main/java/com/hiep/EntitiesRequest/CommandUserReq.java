package com.hiep.EntitiesRequest;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * CommandUser generated by hbm2java
 */
@Data
public class CommandUserReq implements java.io.Serializable {

	private int commandUserId;

	private Integer userId;

	private Integer newsId;

	private String command;

	public CommandUserReq() {
	}

	public CommandUserReq(int commandUserId) {
		this.commandUserId = commandUserId;
	}

	public CommandUserReq(int commandUserId, Integer userId, Integer newsId, String command) {
		this.commandUserId = commandUserId;
		this.userId = userId;
		this.newsId = newsId;
		this.command = command;
	}

	
}
