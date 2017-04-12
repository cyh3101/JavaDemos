package com.cyh.demos.serializable;

import java.io.Serializable;

public class User implements Serializable{

	private String userName;
	private int age;
	public User(String userName, int age) {
		this.setUserName(userName);
		this.setAge(age);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
