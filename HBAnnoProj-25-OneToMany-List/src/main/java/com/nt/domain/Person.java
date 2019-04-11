package com.nt.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "Person")
public class Person {
	@Id
	@GenericGenerator(name="no",strategy="increment")
	@GeneratedValue(generator="no")
	private int no;
	private String name;
	@OneToMany(targetEntity = Phno.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "no", referencedColumnName = "no")
	@OrderColumn(name = "list_no")//@IndexColumn(name="list_no")
	private List<Phno> list = new ArrayList();

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
