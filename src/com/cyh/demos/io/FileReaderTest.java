package com.cyh.demos.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("aaa.java");
		char[] chs = new char[32];
		
		int hasRead = 0;
		while((hasRead = fr.read(chs)) > 0){
			System.out.print(new String(chs, 0, hasRead));
		}
		fr.close();
	}

}
