package com.cyh.demos.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class fileChannelTest {
	public static void main(String[] args) throws IOException{
		File file = new File("filechanneltest.txt");
		
		FileChannel inChannel = new FileInputStream(file).getChannel();
		FileChannel outChannel = new FileOutputStream("a.txt").getChannel();
		
		MappedByteBuffer mBuffer = inChannel.map(MapMode.READ_ONLY, 0, file.length());
		outChannel.write(mBuffer);
		mBuffer.clear();
		Charset charset = Charset.forName("GBK");
		
		CharsetDecoder decoder = charset.newDecoder();
		CharBuffer charBuffer = decoder.decode(mBuffer);
		System.out.println(charBuffer);
	}
}
