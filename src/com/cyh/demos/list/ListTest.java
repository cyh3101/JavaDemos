package com.cyh.demos.list;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class ListTest {

	public static void main(String[] args) {
		ArrayList books = new ArrayList();
		books.add(new String("java学习"));
		books.add(new String("java深入浅出"));
		books.add(new String("java从入门到提高"));
		books.add(new String("javaee学习轨迹"));
		System.out.println(books);
		
		books.add(1,new String("疯狂ajax学习"));
		System.out.println(books);
		
		books.set(2, new String("javajava"));
		System.out.println(books);
		
		System.out.println(books.subList(1, 3));
		

	}

}
