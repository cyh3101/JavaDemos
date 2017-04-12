package com.cyh.demos.list;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEW;

class A{
	public boolean equals(Object object){
		return true;
	}
}

public class ListTest2 {

	public static void main(String[] args) {
		ArrayList books = new ArrayList();
		books.add(new String("java学习"));
		books.add(new String("java深入浅出"));
		books.add(new String("java从入门到提高"));
		books.add(new String("javaee学习轨迹"));
		System.out.println(books);
		
		books.remove(new A());
		System.out.println(books);
		
		books.remove(new A());
		System.out.println(books);

	}

}
