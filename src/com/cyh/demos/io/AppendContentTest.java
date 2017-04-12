package com.cyh.demos.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendContentTest {

	public static void main(String[] args) throws IOException{
		RandomAccessFile raf = new RandomAccessFile("output.txt", "rw");
		
		raf.seek(raf.length());
		raf.write("追加的内容!\r\n".getBytes());
		
		
		

	}

}
