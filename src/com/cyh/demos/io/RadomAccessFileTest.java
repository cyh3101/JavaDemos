package com.cyh.demos.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class RadomAccessFileTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("output.txt", "r");
		
		System.out.println(raf.getFilePointer());
		
		raf.seek(30);
		
		byte[] bys = new byte[32];
		int hasRead = 0;
		while((hasRead = raf.read(bys)) > 0){
			System.out.println(new String(bys, 0, hasRead));
		}

	}

}
