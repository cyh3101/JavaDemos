package com.cyh.demos.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorEach {

	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("java从入门到放弃");
		books.add("java2深入浅出");
		books.add("java高级编程");
		
		Iterator it = books.iterator();
		it.forEachRemaining(obj1->System.out.println("books集合元素:" + obj1));

	}

}
