package com.nt.entity;

import java.util.List;

import lombok.Data;

@Data
public class User {
	private int userId;
	private String username;
	private List<PhoneNumber>  phones;
	
	public User() {
		System.out.println("User:0-param constructor");
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + "]";
	}
	
	

}
