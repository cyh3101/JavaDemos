package com.cyh.demos.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;


public class NServer {

	private Selector selector = null;
	static final int PORT = 5000;
	private Charset charset = Charset.forName("UTF-8");
	private void init() throws IOException{
		this.selector = Selector.open();
		//通过open来打开未绑定的ServerSocketChannel实例
		ServerSocketChannel ss = ServerSocketChannel.open();
		InetSocketAddress address = new InetSocketAddress("127.0.0.1" , PORT);
		ss.bind(address);
		ss.configureBlocking(false);
		ss.register(selector, SelectionKey.OP_ACCEPT);
		
		while(selector.select() > 0){
			for (SelectionKey sk : selector.selectedKeys()) {
				selector.selectedKeys().remove(sk);
				if(sk.isAcceptable()){
					//ServerSocketChannel ss = (ServerSocketChannel)sk.channel();
					//SocketChannel sc = ss.accept();
					SocketChannel sc = ss.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
					sk.interestOps(SelectionKey.OP_ACCEPT);
				}
				if(sk.isReadable()){
					SocketChannel sc = (SocketChannel)sk.channel();
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					String content = "";
					try {
						while(sc.read(buffer) > 0){
							buffer.flip();
							content += charset.decode(buffer);
						}
						System.out.println("读取的数据:" + content);
						sk.interestOps(SelectionKey.OP_READ);
					} catch (Exception e) {
						sk.cancel();
						if(sk.channel() != null){
							sk.channel().close();
						}
					}
					//发送消息到各个被选择channel
					if(content.length() > 0){
						for (SelectionKey key : selector.selectedKeys()) {
							Channel channel = key.channel();
							if(channel instanceof SocketChannel){
								SocketChannel client = (SocketChannel)channel;
								client.write(charset.encode(content));
							}
						}
					}
					
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			new NServer().init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
