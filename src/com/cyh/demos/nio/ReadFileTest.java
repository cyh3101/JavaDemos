package com.cyh.demos.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;


public class ReadFileTest {

	public static void main(String[] args) throws IOException {
		File f = new File("ReadFile.java");
		
		FileChannel fChannel = new FileInputStream(f).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(256);
		
		while(fChannel.read(buffer) != -1){
			buffer.flip();
			Charset charset = Charset.forName("GBK");
			CharsetDecoder decoder = charset.newDecoder();
			CharBuffer charBuffer = decoder.decode(buffer);
			System.out.print(charBuffer);
			buffer.clear();
		}

	}

}
