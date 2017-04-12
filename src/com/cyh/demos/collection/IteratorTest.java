package com.cyh.demos.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("java从入门到放弃");
		books.add("java深入浅出");
		books.add("java高级编程");
		
		Iterator it = books.iterator();
		
		while (it.hasNext()) {
			String	book = (String) it.next();
			System.out.println(book);
			if(book.equals("java深入浅出")){
				it.remove();
			}
			book = "testestet";
		}
		System.out.println(books);

	}

}
