package com.cyh.demos.map;

import java.util.HashMap;

public class MapTest2 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("java讲义", 33);
		map.put("ajax讲义", 44);
		map.put("android讲义", 66);
		System.out.println(map);
		
		map.merge("ajax讲义", 10, (oldVal,param)->(Integer)oldVal + (Integer)param);
		System.out.println(map);
		
		map.computeIfAbsent("java", key->((String)key).length());
		System.out.println(map);
		
		map.computeIfPresent("java", (key,value)->(Integer)value*(Integer)value);
		System.out.println(map);
	}

}
