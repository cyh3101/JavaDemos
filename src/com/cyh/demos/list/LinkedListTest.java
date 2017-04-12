package com.cyh.demos.list;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList books = new LinkedList();
		
		books.offer("疯狂java讲义");
		
		books.push("疯狂ajax讲义");
		
		books.offerFirst("javaee企业应用");
		
		//books.add("javajajvjaj");
		System.out.println(books);
		for(int i = 0;i < books.size();i++){
			System.out.println(books.get(i));
		}
		
		System.out.println(books.peekFirst());
		
		System.out.println(books.peekLast());
		
		System.out.println(books);
		
		System.out.println(books.pollLast());
		
		System.out.println(books);

	}

}
