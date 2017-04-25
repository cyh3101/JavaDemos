package com.cyh.demos.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AIOServer {

	static final int PORT = 5001;
	static final String UTF_8 = "UTF-8";
	AsynchronousServerSocketChannel serverChannel = null;
	static List<AsynchronousSocketChannel> channelList = new ArrayList<>();
	
	public void startListen() throws IOException{
		ExecutorService executor = Executors.newFixedThreadPool(20);
		AsynchronousChannelGroup channelGroup = 
				AsynchronousChannelGroup.withThreadPool(executor);
		//创建ServerChannel,并绑定相关地址端口
		serverChannel = AsynchronousServerSocketChannel.open(channelGroup)
				.bind(new InetSocketAddress(PORT));
		//serverChannel = AsynchronousServerSocketChannel.open()
		//				.bind(new InetSocketAddress(PORT));
		serverChannel.accept(null, new AcceptHandler(serverChannel));
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object>{

		private AsynchronousServerSocketChannel serverChannel = null;
		public AcceptHandler(AsynchronousServerSocketChannel ss) {
			this.serverChannel = ss;
		}
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		@Override
		public void completed(AsynchronousSocketChannel sc, Object attachment) {
			AIOServer.channelList.add(sc);
			serverChannel.accept(null, this);
			sc.read(buffer, null, new CompletionHandler<Integer, Object>() {

				@Override
				public void completed(Integer result, Object attachment) {
					buffer.flip();
					String content = StandardCharsets.UTF_8
							.decode(buffer).toString();
					System.out.println("来自客户端的消息:" + content);
					for (AsynchronousSocketChannel c : AIOServer.channelList) {
						try {
							c.write(ByteBuffer.wrap(content.getBytes(
									AIOServer.UTF_8))).get();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					buffer.clear();
					sc.read(buffer, null, this);
				}

				@Override
				public void failed(Throwable exc, Object attachment) {
					System.out.println("读取数据失败" + exc);
					AIOServer.channelList.remove(sc);
				}
			});
			
		}

		@Override
		public void failed(Throwable exc, Object attachment) {
			System.out.println("连接失败:" + exc);
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		AIOServer server = new AIOServer();
		//Thread.sleep(1000);
		try {
			server.startListen();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
