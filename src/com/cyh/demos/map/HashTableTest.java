package com.cyh.demos.map;

import java.util.Hashtable;

import com.sun.org.apache.bcel.internal.generic.NEW;

class C{
	int count;
	public C(int count){
		this.count = count;
	}
	public String toString(){
		return "[count:" + this.count + "]";
	}
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj != null && this.getClass() == obj.getClass()){
			C c = (C)obj;
			return c.count == this.count;
		}
		return false;
	}
	public int hashCode(){
		return this.count;
	}
	
}
class D{
	public boolean equals(Object obj){
		return true;
	}
}
public class HashTableTest {

	public static void main(String[] args) {
		Hashtable hashtable = new Hashtable();
		
		hashtable.put(new C(66), 66);
		hashtable.put(new C(166), 166);
		hashtable.put(new C(616), new D());
		System.out.println(hashtable);

		System.out.println(hashtable.containsValue("aaaa"));
		
		System.out.println(hashtable.containsKey(new C(66)));
		hashtable.remove(new C(66));
		System.out.println(hashtable);
	}

}
