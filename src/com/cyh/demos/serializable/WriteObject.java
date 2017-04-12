package com.cyh.demos.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {

	public static void main(String[] args) throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("serializable.txt"));
		User user = new User("cyh", 28);
		oos.writeObject(user);
	}

}
