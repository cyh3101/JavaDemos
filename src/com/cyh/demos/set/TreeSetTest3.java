package com.cyh.demos.set;

import java.util.TreeSet;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

import sun.management.resources.agent;

class E implements Comparable{

	public int count;
	public E(int count){
		this.count = count;
	}
	public String toString(){
		return "[E:" + this.count + "]";
	}

	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		if(obj != null && obj.getClass() == this.getClass()){
			E r = (E)obj;
			return r.count == this.count;
		}
		return false;
	}
	@Override
	public int compareTo(Object o) {
		E r = (E)o;
		return this.count > r.count?1: this.count < r.count?-1:0;
		
	}
	
}
public class TreeSetTest3 {
	public static void main(String[] args){
		TreeSet treeSet = new TreeSet();
		treeSet.add(new E(8));
		treeSet.add(new E(18));
		treeSet.add(new E(-8));
		treeSet.add(new E(5));
		
		System.out.println(treeSet);
		
		E first = (E)treeSet.first();
		first.count = 6;
		
		E last = (E)treeSet.last();
		
		last.count = 8;
		
		System.out.println(treeSet);
		System.out.println(treeSet.remove(new E(5)));
		System.out.println(treeSet);
	}
}
