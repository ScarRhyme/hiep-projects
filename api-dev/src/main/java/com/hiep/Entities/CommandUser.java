package com.hiep.Entities;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

/**
 * CommandUser generated by hbm2java
 */
public class CommandUser implements java.io.Serializable {

	private int commandUserId;
	private Integer userId;
	private Integer newsId;
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