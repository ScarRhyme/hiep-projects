package com.hiep.Entities;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "Customer", schema = "dbo", catalog = "hiep")
@Data
public class Customer implements java.io.Serializable  {
	@Id
	@Column(name = "CustomerId")
	private int customerId;
	@Basic
	@Column(name = "CustomerName")
	private String customerName;
	@Basic
	@Column(name = "Address")
	private String address;
	@Basic
	@Column(name = "Phonenumber")
	private Integer phonenumber;

	public Customer() {
	}

	public Customer(int customerId) {
		this.customerId = customerId;
	}

	public Customer(int customerId, String customerName, String address, Integer phonenumber) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.phonenumber = phonenumber;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(Integer phonenumber) {
		this.phonenumber = phonenumber;
	}

}
