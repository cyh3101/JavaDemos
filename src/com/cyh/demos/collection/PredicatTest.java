package com.cyh.demos.collection;

import java.util.Collection;
import java.util.HashSet;

public class PredicatTest {

	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("java从入门到放弃");
		books.add("java2深入浅出");
		books.add("java高级编程");
		
		books.removeIf(ele->((String)ele).length() <10);
		System.out.println(books);

	}

}
