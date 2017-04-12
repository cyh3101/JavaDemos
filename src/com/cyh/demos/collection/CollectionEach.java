package com.cyh.demos.collection;

import java.util.Collection;
import java.util.HashSet;

public class CollectionEach {

	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("java从入门到放弃");
		books.add("java深入浅出");
		books.add("java高级编程");
		
		books.forEach(obj->System.out.println("迭代集合元素:" + obj));

	}

}
