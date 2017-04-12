package com.cyh.demos.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class RedirectOutTest {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = new PrintStream(new FileOutputStream("output.txt"));
		System.setOut(ps);
		System.out.println("普通字符串");
		
		System.out.println(new RedirectOutTest());

	}

}
