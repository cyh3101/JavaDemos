package com.cyh.demos.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyinTest {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(isr);
		
		String line = null;
		while((line = bfr.readLine()) != null){
			if(line.equals("exit")){
				System.exit(1);
			}
			System.out.println("输入的内容为:" + line);
		}

	}

}
