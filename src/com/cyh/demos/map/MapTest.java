package com.cyh.demos.map;

import java.util.HashMap;
import java.util.Iterator;

import com.sun.javafx.collections.MappingChange.Map;

public class MapTest {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("java讲义", 33);
		map.put("ajax讲义", 44);
		map.put("android讲义", 66);
		System.out.println(map.put("ajax讲义", 55));
		System.out.println(map);
		
		System.out.println("是否包含\"java讲义\"key:" + map.containsKey("java讲义"));
		System.out.println("是否包含\"66\"value:" + map.containsValue(66));
		for(Object key:map.keySet()){
			System.out.println(key + "---->" + map.get(key));
		}
		map.remove("android讲义");
		
		System.out.println(map);
		
	}

}
