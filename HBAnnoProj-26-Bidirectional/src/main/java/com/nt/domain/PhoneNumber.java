package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// Generated Apr 11, 2019 11:32:01 AM by Hibernate Tools 5.2.12.Final

/**
 * PhoneNumber generated by hbm2java
 */
@Entity
@Table(name="PhoneNumber")
public class PhoneNumber implements java.io.Serializable {

	@Column(name="phone")
	private long phone;
	@Column(name="usertable")
	private UserTable userTable;
	private String numberType;

	public PhoneNumber() {
	}

	public PhoneNumber(long phone) {
		this.phone = phone;
	}

	public PhoneNumber(long phone, UserTable userTable, String numberType) {
		this.phone = phone;
		this.userTable = userTable;
		this.numberType = numberType;
	}

	public long getPhone() {
		return this.phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public UserTable getUserTable() {
		return this.userTable;
	}

	public void setUserTable(UserTable userTable) {
		this.userTable = userTable;
	}

	public String getNumberType() {
		return this.numberType;
	}

	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}

	@Override
	public String toString() {
		return "PhoneNumber [phone=" + phone + ", numberType=" + numberType + "]";
	}

}
