package com.cyh.demos.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IteratorListTest {

	public static void main(String[] args) {
		String[] books = {
				"疯狂java学习",
				"轻量级java学习"
		};
		List bookList = new ArrayList();
		
		for(int i = 0;i < books.length;i++){
			bookList.add(books[i]);
		}
		
		ListIterator iterator = bookList.listIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
			iterator.add("============分隔符================");
		}
		
		System.out.println("===========下面开始反转输出================");
		while (iterator.hasPrevious()) {
			System.out.println(iterator.previous());
			
		}
	}

}
