package com.cyh.demos.set;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		LinkedHashSet linkedHashSet = new LinkedHashSet();
		linkedHashSet.add("java开发");
		linkedHashSet.add("javaee开发");
		
		System.out.println(linkedHashSet);
		
		linkedHashSet.remove("java开发");
		linkedHashSet.add("java开发");
		
		System.out.println(linkedHashSet);

	}

}
