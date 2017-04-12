package com.cyh.demos.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;


public class CharsetTransform {

	public static void main(String[] args) throws CharacterCodingException {
		Charset charset = Charset.forName("GBK");
		
		CharsetDecoder decoder = charset.newDecoder();
		CharsetEncoder encoder = charset.newEncoder();
		
		CharBuffer charBuffer = CharBuffer.allocate(8);
		charBuffer.put('孙');
		charBuffer.put('悟');
		charBuffer.put('空');
		charBuffer.flip();
		System.out.println("limit:" + charBuffer.limit());
		System.out.println("postion:" + charBuffer.position());
		
		ByteBuffer byteBuffer = encoder.encode(charBuffer);
		for(int i = 0;i < byteBuffer.capacity();i++){
			System.out.print(byteBuffer.get(i) + " ");
		}
		System.out.println(decoder.decode(byteBuffer));
	}

}
