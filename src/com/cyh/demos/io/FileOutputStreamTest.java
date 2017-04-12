package com.cyh.demos.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) throws IOException {
		FileInputStream is = new FileInputStream("aaa.java");
		FileOutputStream os = new FileOutputStream("newaaa.java");
		byte[] bys = new byte[32];
		
		int hasRead = 0;
		while((hasRead = is.read(bys)) > 0){
			os.write(bys, 0, hasRead);
		}
		is.close();
		os.close();
	}

}
