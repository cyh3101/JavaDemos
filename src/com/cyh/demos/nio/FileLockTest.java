package com.cyh.demos.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileChannel fileChannel = new FileOutputStream("a.txt").getChannel();
		FileLock lock = fileChannel.tryLock();
		Thread.sleep(10000);
		lock.release();
	}

}
