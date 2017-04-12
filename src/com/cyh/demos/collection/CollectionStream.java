package com.cyh.demos.collection;

import java.util.Collection;
import java.util.HashSet;

public class CollectionStream {

	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("java从入门到放弃");
		books.add("java2深入浅出");
		books.add("java高级编程");
		
		//统计书名包括“java”的数量
		System.out.println(books.stream().
				filter(ele->((String)ele).contains("java"))
				.count());
		//统计书名包括“高级”的数量
		System.out.println(books.stream().
				filter(ele->((String)ele).contains("高级"))
				.count());
		//筛选出书名长度大于10的book
		System.out.println(books.stream().
				filter(ele->((String)ele).length() > 10)
				.count());
		books.stream().mapToInt(ele->((String)ele).length())
		.forEach(System.out::println);
	}

}
