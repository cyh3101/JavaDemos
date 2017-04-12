package com.cyh.demos.collection;

import java.util.stream.IntStream;

public class IntStreamTest {

	public static void main(String[] args) {
		IntStream is = IntStream.builder()
				.add(23)
				.add(54)
				.add(34)
				.build();
//		System.out.println("is中最大的值为:" + is.max().getAsInt());
//		System.out.println("is中最小的值为:" + is.min().getAsInt());		
//		System.out.println("is中最大的值为:" + is.sum());
//		System.out.println("is中最大的值为:" + is.count());
//		System.out.println("is中最大的值为:" + is.average());
//		System.out.println("is中所有元素是不是大于10" 
//				+ is.allMatch(ele->ele > 20));
//		System.out.println("is中是否有元素大于20" 
//				+ is.anyMatch(ele->ele > 20));
		IntStream newis = is.map(ele->ele + 2);
		newis.forEach(System.out::println);
	}

}
