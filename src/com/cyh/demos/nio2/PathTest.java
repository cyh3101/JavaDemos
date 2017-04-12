package com.cyh.demos.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) {
		Path path = Paths.get("a\\");
		System.out.println("path里面包含的path数量:" + path.getNameCount());
		System.out.println("path的根路径:" + path.getRoot());
		//获取绝对路径
		Path absolutePath = path.toAbsolutePath();
		System.out.println("path绝对路径:" + absolutePath);
		
		System.out.println("path绝对路径的根目录:" + absolutePath.getRoot());
		
		System.out.println("path绝对路径里面包含的path数量:" + absolutePath.getNameCount());
		System.out.println(absolutePath.getName(2));
		
		Path path2 = Paths.get("g:", "aaa","bbbb");
		System.out.println(path2);

	}

}
