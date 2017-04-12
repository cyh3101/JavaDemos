package com.cyh.demos.nio;

import java.nio.CharBuffer;

public class BufferTest {

	public static void main(String[] args) {
		CharBuffer charBuffer = CharBuffer.allocate(8);
		
		System.out.println("capacity:" + charBuffer.capacity());
		System.out.println("limit:" + charBuffer.limit());
		System.out.println("position:" + charBuffer.position());
		
		charBuffer.put('a');
		charBuffer.put('b');
		charBuffer.put('c');
		System.out.println("加入三个元素以后position位置:" + charBuffer.position());
		
		charBuffer.flip();
		System.out.println("filp以后limit:" + charBuffer.limit());
		System.out.println("filp以后position:" + charBuffer.position());
		
		System.out.println("第一个元素:" + charBuffer.get());
		System.out.println("得到第一个元素以后position:" + charBuffer.position());
		
		charBuffer.clear();
		System.out.println("clear以后position:" + charBuffer.position());
		System.out.println("clear以后limit:" + charBuffer.limit());
		
		charBuffer.get(2);
		System.out.println("get(2)以后position:" + charBuffer.position());
	}

}
