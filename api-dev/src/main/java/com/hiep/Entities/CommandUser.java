package com.hiep.Entities;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * CommandUser generated by hbm2java
 */
@Entity
@Table(name = "CommandUser", schema = "dbo", catalog = "hiep")
@Data
public class CommandUser implements java.io.Serializable  {
	
	@Id
	@Column(name = "CommandUserId")
	private int commandUserId;
	
	@Id
	@Column(name = "UserId")
	private Integer userId;
	
	@Id
	@Column(name = "NewsId")
	private Integer newsId;
	
	@Id
	@Column(name = "Command")
	private String command;

	public CommandUser() {
	}

	public CommandUser(int commandUserId) {
		this.commandUserId = commandUserId;
	}

	public CommandUser(int commandUserId, Integer userId, Integer newsId, String command) {
		this.commandUserId = commandUserId;
		this.userId = userId;
		this.newsId = newsId;
		this.command = command;
	}

	public int getCommandUserId() {
		return this.commandUserId;
	}

	public void setCommandUserId(int commandUserId) {
		this.commandUserId = commandUserId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getCommand() {
		return this.command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

}
