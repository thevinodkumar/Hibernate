package com.nt.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Person")
public class Person {

	@Id
	@Column(name = "no")
	@GenericGenerator(name="no",strategy="increment")
	@GeneratedValue(generator="no")
	private int no;
	@Column(name = "name")
	private String name;
	@OneToMany(targetEntity = Phno.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY ,orphanRemoval = true)
	@JoinColumn(name = "no",referencedColumnName="no")
	private Set<Phno> set = new HashSet();

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
