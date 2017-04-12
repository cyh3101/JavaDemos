package com.cyh.demos.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.io.PushbackReader;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class PushbackTest {

	public static void main(String[] args) throws IOException {
		PushbackReader pr = new PushbackReader(new FileReader("aaa.java"), 64);
		char[] ch = new char[32];
		String lastString = "";
		int hasRead = 0;
		
		while((hasRead = pr.read(ch)) > 0){
			String content = new String(ch, 0, hasRead);
			int targetIndex = 0;
			if((targetIndex = (lastString + content).indexOf("class")) > 0){
				pr.unread((lastString + content).toCharArray());
				if(targetIndex > 32){
					ch = new char[targetIndex];
				}
				pr.read(ch, 0, targetIndex);
				
				System.out.println(new String(ch,0,targetIndex));
				System.exit(0);
			}
			else {
				System.out.println(lastString);
				lastString = content;
			}
		}
				
	}

}
