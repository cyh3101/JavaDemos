package com.cyh.demos.list;

import java.util.ArrayDeque;

public class ArrayDequeQueue {

	public static void main(String[] args) {
		ArrayDeque queue = new ArrayDeque();
		
		queue.offer("疯狂java讲义");
		queue.offer("轻量级java EE 企业应用实战");
		queue.offer("疯狂Android讲义");
		//[疯狂java讲义, 轻量级java EE 企业应用实战, 疯狂Android讲义]
		System.out.println(queue);
		//疯狂java讲义
		System.out.println(queue.peek());
		//[疯狂java讲义, 轻量级java EE 企业应用实战, 疯狂Android讲义]
		System.out.println(queue);
		//疯狂java讲义
		System.out.println(queue.poll());
		//[轻量级java EE 企业应用实战, 疯狂Android讲义]
		System.out.println(queue);

	}

}
