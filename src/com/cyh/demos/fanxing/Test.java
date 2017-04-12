package com.cyh.demos.fanxing;

import java.util.ArrayList;
import java.util.List;

import com.sun.glass.ui.TouchInputSupport;

import sun.net.NetworkServer;

public class Test {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("aaaa");
		test(list);

	}

	public static void test(List<?> c) {
		for (int i = 0; i < c.size(); i++) {
			System.out.println(c.get(i));
		}
	}
}
