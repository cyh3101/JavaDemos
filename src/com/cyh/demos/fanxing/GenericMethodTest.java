package com.cyh.demos.fanxing;

import java.util.ArrayList;
import java.util.Collection;

public class GenericMethodTest {

	public static <T> void fromArrayToCollection(T[] a, Collection<T> c){
		for (T t : c) {
			c.add(t);
		}
		
	}
	
	public static void main(String[] args) {
		Object[] oa = new Object[100];
		Collection<Object> co = new ArrayList<>();
		fromArrayToCollection(oa, co);
		
		String[] sa = new String[100];
		Collection<String> cs = new ArrayList<>();
		fromArrayToCollection(sa, cs);
		
		fromArrayToCollection(sa, co);
		
		Number[] na = new Number[100];
		//不是子类型，编译出错
		//fromArrayToCollection(na, cs);
		

	}

}
