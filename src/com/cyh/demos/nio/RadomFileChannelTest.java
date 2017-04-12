package com.cyh.demos.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

import com.sun.corba.se.impl.ior.ByteBuffer;

public class RadomFileChannelTest {

	public static void main(String[] args) throws IOException {
		File f = new File("a.txt");
		
		RandomAccessFile raf = new RandomAccessFile(f, "rw");
		
		FileChannel fChannel = raf.getChannel();
		
		MappedByteBuffer byteBuffer = fChannel.map(MapMode.READ_ONLY, 0, raf.length());
		fChannel.position(raf.length());
		fChannel.write(byteBuffer);
	}

}
