package com.nt.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Person {

	private int no;
	private String name;
	private List<Phno> list=new ArrayList();
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
	public List<Phno> getList() {
		return list;
	}
	public void setList(List<Phno> list) {
		this.list = list;
	}
	
}
