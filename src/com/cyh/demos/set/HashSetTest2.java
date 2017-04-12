package com.cyh.demos.set;

import java.util.HashSet;
import java.util.Iterator;

import com.sun.org.apache.bcel.internal.generic.NEW;

class R{
	int count;
	public R(int count){
		this.count = count;
	}
	public int hashCode(){
		return this.count;
	}
	public String toString(){
		return "[count:"+ this.count+ "]";
	}
	public boolean equals(Object object){
		if(this == object){
			return true;
		}
		if(object != null && object.getClass() == R.class){
			R r = (R)object;
			return this.count == r.count;
		}
		return false;
	}
}
public class HashSetTest2 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add(new R(5));
		set.add(new R(9));
		set.add(new R(10));
		set.add(new R(-5));
		//打印出来
		System.out.println(set);
		Iterator it = set.iterator();
		R first = (R)it.next();
		first.count = 5;
		System.out.println(set);
		set.remove(new R(5));
		System.out.println(set);
		//是否包含为5的元素
		System.out.println("是否包含值为5的元素:" + set.contains(new R(5)));
		
		System.out.println("是否包含值为5的元素:" + set.contains(new R(-5)));

	}

}
