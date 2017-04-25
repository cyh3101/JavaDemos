package com.cyh.demos.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class UdpServer {

	private final static int PORT = 5000;
	private final static int DATA_LENGTH = 4096;
	byte[] buff = new byte[DATA_LENGTH];
	DatagramPacket inPacket = new DatagramPacket(buff, buff.length);
	DatagramPacket outPacket = null;
	
	String arrs[] = new String[]{
		"疯狂java",
		"疯狂ajax",
		"疯狂android",
		"疯狂php"
	};
	public void init() throws IOException{
		try {
			DatagramSocket socket = new DatagramSocket(PORT);
			for(int i = 0 ; i < 1000 ; i++){
				socket.receive(inPacket);
				System.out.println(buff == inPacket.getData());
				System.out.println(new String(buff, 0, buff.length));
				byte[] sendData = arrs[i % 4].getBytes();
				outPacket = new DatagramPacket(sendData, 
						sendData.length, inPacket.getSocketAddress());
				socket.send(outPacket);;
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws IOException {
		new UdpServer().init();

	}

}
