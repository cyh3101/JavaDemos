package com.cyh.demos.io;

import java.io.FileInputStream;
import java.io.IOException;


public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("aaa.java");
		byte[] by = new byte[1024];
		
		int hasRead = 0;
		while((hasRead = fis.read(by)) > 0){
			System.out.print(new String(by, 0, hasRead));
		}
		fis.close();
	}

}
