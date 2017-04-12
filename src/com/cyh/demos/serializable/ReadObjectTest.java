package com.cyh.demos.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ReadObjectTest {

	public static void main(String[] args) 
			throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("serializable.txt"));
		User user = (User)ois.readObject();
		
		System.out.println("username:" + user.getUserName() + "---"
			+ "age:" + user.getAge());
	}

}
