package com.nt.test;
// Generated Apr 10, 2019 3:25:32 PM by Hibernate Tools 5.4.2.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Person generated by hbm2java
 */
public class Person implements java.io.Serializable {

	private long no;
	private String name;
	private Set phnos = new HashSet(0);

	public Person() {
	}

	public Person(long no) {
		this.no = no;
	}

	public Person(long no, String name, Set phnos) {
		this.no = no;
		this.name = name;
		this.phnos = phnos;
	}

	public long getNo() {
		return this.no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getPhnos() {
		return this.phnos;
	}

	public void setPhnos(Set phnos) {
		this.phnos = phnos;
	}

}