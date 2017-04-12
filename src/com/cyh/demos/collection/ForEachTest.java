package com.cyh.demos.collection;

import java.util.Collection;
import java.util.HashSet;

public class ForEachTest {

	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("java从入门到放弃");
		books.add("java2深入浅出");
		books.add("java高级编程");
		
		for (Object object :books) {
			String book = (String)object;
			System.out.println(book);
			if(book.equals("java2深入浅出")){
				books.remove(book);
			}
		}
		System.out.println("books集合的数据:" + books);

	}

}
