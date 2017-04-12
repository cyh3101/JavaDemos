package com.cyh.demos.nio;

import java.nio.charset.Charset;
import java.util.SortedMap;

import com.sun.javafx.collections.MappingChange.Map;

public class CharsetTest {

	public static void main(String[] args) {
		SortedMap<String, Charset> chars = Charset.availableCharsets();
		for (String alias :chars.keySet()) {
			System.out.println(alias + "----->" + chars.get(alias));
		}

	}

}
