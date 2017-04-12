package com.cyh.demos.list;

import java.util.ArrayList;

public class ListTest3 {

	public static void main(String[] args) {
		ArrayList books = new ArrayList();
		books.add(new String("java学习"));
		books.add(new String("javaee学习轨迹"));
		books.add(new String("java从入门到提高"));
		books.add(new String("java深入浅出"));
		System.out.println(books);
		
		books.sort((obj1,obj2)->((String)obj1).length() - ((String)obj2).length());
		System.out.println(books);
		
		books.replaceAll(ele->((String)ele).length());
		System.out.println(books);
	}

}
