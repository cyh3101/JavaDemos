package com.cyh.demos.redis;

import java.io.Serializable;

public class User implements Serializable{
	private String userName;
	private int age;
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
	public User(String userName, int age) {
		super();
		this.userName = userName;
		this.age = age;
	}
}
