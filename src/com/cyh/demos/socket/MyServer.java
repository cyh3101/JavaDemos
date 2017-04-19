package com.cyh.demos.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyServer {
	public static List<Socket> socketList 
		= Collections.synchronizedList(new ArrayList<>());
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(5000);
			Socket s = ss.accept();
			socketList.add(s);
			System.out.println("接收到:" + s.getRemoteSocketAddress() + "访问");
			new Thread(new ServerThread(s)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
