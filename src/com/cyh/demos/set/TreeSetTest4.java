package com.cyh.demos.set;

import java.util.TreeSet;

import com.sun.org.apache.bcel.internal.generic.NEW;

class M{
	public int age;
	public M(int age){
		this.age = age;
	}
	public String toString(){
		return "[M:" + this.age + "]";
	}
}

public class TreeSetTest4 {

	public static void main(String[] args) {
		TreeSet treeSet = new TreeSet((obj1,obj2)->{
			M m1 = (M)obj1;
			M m2 = (M)obj2;
			return m1.age > m2.age ? 1 : m1.age < m2.age ? -1 :0;
		});
		treeSet.add(new M(3));
		treeSet.add(new M(6));
		treeSet.add(new M(8));
		treeSet.add(new M(10));
		
		System.out.println(treeSet);
	}

}
