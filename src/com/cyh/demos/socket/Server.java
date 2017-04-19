package com.cyh.demos.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(5000);
			while(true){
				Socket s = ss.accept();
				PrintStream ps = new PrintStream(s.getOutputStream());
				ps.println("你好，你收到了服务器端的消息");
				
				System.out.println("来自:" + s.getRemoteSocketAddress() + "的连接"
						+ "  ");
				ps.close();
				s.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
