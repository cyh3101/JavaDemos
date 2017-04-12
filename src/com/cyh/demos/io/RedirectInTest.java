package com.cyh.demos.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RedirectInTest {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("output.txt");
		
		System.setIn(fis);
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		
		while(sc.hasNext()){
			System.out.println(sc.next());
		}

	}

}
