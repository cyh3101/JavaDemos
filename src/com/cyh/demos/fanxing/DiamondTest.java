package com.cyh.demos.fanxing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DiamondTest {

	public static void main(String[] args) {
		List<String> books = new ArrayList<>();
		
		books.add("java讲义");
		books.add("ajax讲义");
		books.forEach(ele->System.out.println(ele.length()));
		
		Map<String, List<String>> schoolInfo = new HashMap<>();
		
		List<String> schools = new ArrayList<>();
		schools.add("温州大学");
		schools.add("杭州大学");
		schoolInfo.put("孙悟空", schools);
		schoolInfo.forEach((key,value)->System.out.println("key:" 
				+ key + "----->" + "value:" + value) );
	}

}
