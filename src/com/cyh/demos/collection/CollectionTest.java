package com.cyh.demos.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {

	public static void main(String[] args) {
		Collection collection = new ArrayList();
		
		collection.add("孙悟空");
		
		collection.add(6);
		
		collection.add("java从入门到放弃");
		
		System.out.println("collection集合的元素个数为:" + collection.size());
		
		//删除特定的元素
		collection.remove(6);
		System.out.println("collection集合的元素个数为:" + collection.size());
		
		//判断collection是不是包含某一个元素
		System.out.println("collection集合是否包含\"孙悟空\"字符串:" 
		+ collection.contains("孙悟空"));
		
		collection.add("java学习");
		System.out.println("collection集合的元素为:" + collection);
		
		Collection books = new HashSet();
		books.add("java从入门到放弃");
		books.add("java深入浅出");
		System.out.println("collection集合是不是包含books集合" 
		+ collection.containsAll(books));
		//从collection集合里面减去books集合里的元素
		collection.removeAll(books);
		System.out.println("collection集合里的元素:" + collection);
		
		collection.clear();
		System.out.println("collection集合里的元素:" + collection);
		
		books.retainAll(collection);
		System.out.println("books集合的元素:" + books);
	}

}
