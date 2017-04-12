package com.cyh.demos.map;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		LinkedHashMap linkedHashMap = new LinkedHashMap();
		linkedHashMap.put("java讲义", 66);
		linkedHashMap.put("ios讲义", 44);
		linkedHashMap.put("ajax讲义", 89);
		linkedHashMap.put("android讲义", 78);
		System.out.println(linkedHashMap);
		linkedHashMap.forEach((key,value)->System.out.println(key + "--->" + value));;
	}

}
