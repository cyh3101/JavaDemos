package com.cyh.demos.io;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringNodeTest {

	public static void main(String[] args) throws IOException {
		String str = "早已空虚冷寞的古行宫，"
					+"零落宫花依然开行艳红。"
					+"有几个满头白发的宫女，"
					+"闲坐谈论当年的唐玄宗。";
		char[] ch = new char[32];
		int hasRead = 0;
		StringReader sr = new StringReader(str);
		while((hasRead = sr.read(ch)) > 0){
			System.out.print(new String(ch, 0, hasRead));
		}
		StringWriter sw = new StringWriter();
		sw.write("归山深浅去,");
		sw.write("须尽丘壑美。");
		sw.write("莫学武陵人,");
		sw.write("暂游桃源里。");
		System.out.println();
		System.out.println("======================下面是字符节点sw输出的内容=====================");
		System.out.print(sw.toString());
	}

}
