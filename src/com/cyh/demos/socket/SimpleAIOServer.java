package com.cyh.demos.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;



public class SimpleAIOServer {
	
	static final int PORT = 5000;
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		try {
			AsynchronousServerSocketChannel serverChannel = 
					AsynchronousServerSocketChannel.open();
			serverChannel.bind(new InetSocketAddress(PORT));
			while(true){
				Future<AsynchronousSocketChannel> future = serverChannel.accept();
				AsynchronousSocketChannel socketChannel = future.get();
				socketChannel.write(ByteBuffer.wrap("欢迎你来到AIO".getBytes("UTF-8"))).get();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
