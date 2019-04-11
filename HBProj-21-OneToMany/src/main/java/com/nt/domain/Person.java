package com.nt.domain;

import java.util.HashSet;
import java.util.Set;

public class Person {

	private int no;
	private String name;
	private Set<Phno> set=new HashSet();
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [no=" + no + ", name=" + name + "]";
	}
	public Set<Phno> getSet() {
		return set;
	}
	public void setSet(Set<Phno> set) {
		this.set = set;
	}
	
}
