package com.cyh.demos.list;

import java.util.ArrayDeque;

public class ArrayDequeStack {

	public static void main(String[] args) {
		ArrayDeque stack = new ArrayDeque();
		
		stack.push("疯狂java讲义");
		stack.push("轻量级java EE 企业应用实战");
		stack.push("疯狂Android讲义");
		//[疯狂Android讲义, 轻量级java EE 企业应用实战, 疯狂java讲义]
		System.out.println(stack);
		//疯狂Android讲义
		System.out.println(stack.peek());
		//[疯狂Android讲义, 轻量级java EE 企业应用实战, 疯狂java讲义]
		System.out.println(stack);
		//疯狂Android讲义
		System.out.println(stack.pop());
		//[轻量级java EE 企业应用实战, 疯狂java讲义]
		System.out.println(stack);

	}

}
