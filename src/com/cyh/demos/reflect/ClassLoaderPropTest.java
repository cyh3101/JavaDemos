package com.cyh.demos.reflect;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropTest {

	public static void main(String[] args) throws IOException {
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器:" + systemLoader);
		
		/*
		 * 获取系统类加载器的加载路径
		 */
		Enumeration<URL> em1 = systemLoader.getResources("");
		while(em1.hasMoreElements()){
			System.out.println(em1.nextElement());
		}
		
		ClassLoader extensionLoader = systemLoader.getParent();
		System.out.println("扩展类加载器:" + extensionLoader);
		System.out.println("扩展类加载器的路径:" + System.getProperty("java.ext.dirs"));
		System.out.println("扩展类加载器的父类加载器:" + extensionLoader.getParent());
		
	}

}
