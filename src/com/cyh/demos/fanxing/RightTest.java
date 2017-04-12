package com.cyh.demos.fanxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RightTest {

	static <T> void test(Collection<? extends T> from,Collection<T> to){
		for (T f : from) {
			to.add(f);
		}
	}
	
	public static void main(String[] args) {
		List<Object> to = new ArrayList<>();
		List<String> from = new ArrayList<>();
		test(from, to);

	}

}
