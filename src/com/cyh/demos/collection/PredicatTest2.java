package com.cyh.demos.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Predicate;

import javax.swing.text.html.HTMLEditorKit.ParserCallback;

public class PredicatTest2 {
	public static void main(String args[]){
		Collection books = new HashSet();
		books.add("java从入门到放弃");
		books.add("java2深入浅出");
		books.add("java高级编程");
		
		System.out.println(preCall(books, ele->((String)ele).length() >10  ));
		System.out.println(preCall(books, ele->((String)ele).contains("java")));
		System.out.println(preCall(books, ele->((String)ele).contains("入")));
		
	}
	
	public static int preCall(Collection c,Predicate p){
		int total = 0 ;
		for (Object object : c) {
			if(p.test(object)){
				total ++ ;
			}
		}
		
		return total;
	}
}
