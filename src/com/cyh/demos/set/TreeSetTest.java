package com.cyh.demos.set;

import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args){
		TreeSet treeSet = new TreeSet();
		
		treeSet.add(5);
		treeSet.add(8);
		treeSet.add(-9);
		System.out.println(treeSet);
		
		System.out.println(treeSet.first());
		
		System.out.println(treeSet.last());
		
		System.out.println(treeSet.headSet(5));
		System.out.println(treeSet.tailSet(5));
		
		System.out.println(treeSet.subSet(0, 7));
	} 
}
