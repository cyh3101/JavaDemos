package com.cyh.demos.map;

import java.util.TreeMap;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

class R implements Comparable{
	int count;
	public R(int count){
		this.count = count;
	}
	public String toString(){
		return "[count:" + this.count + "]";
	}
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj != null && this.getClass() == obj.getClass()){
			R r = (R)obj;
			return this.count == r.count;
		}
		return false;
	}
	@Override
	public int compareTo(Object o) {
		R r = (R)o;
		return this.count > r.count ? 1 : this.count < r.count ? -1 : 0;
	}
	
}
public class TreeMapTest {

	public static void main(String[] args) {
		TreeMap treeMap = new TreeMap();
		treeMap.put(new R(-10), 66);
		treeMap.put(new R(10), 23);
		treeMap.put(new R(-2), 43);
		treeMap.put(new R(20), 77);
		System.out.println(treeMap);
		
		System.out.println(treeMap.firstEntry());
		System.out.println(treeMap.lastKey());
		
		System.out.println(treeMap.lowerKey(new R(11)));
		System.out.println(treeMap.higherEntry(new R(9)));
		System.out.println(treeMap.subMap(new R(-2), new R(21)));

	}

}
