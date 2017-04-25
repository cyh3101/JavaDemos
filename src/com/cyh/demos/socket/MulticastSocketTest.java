package com.cyh.demos.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastSocketTest implements Runnable{

	private static final int PORT = 6000;
	private static final int DATA_LEN = 4096;
	private static final String BRODCAST_ADDRESS = "230.0.0.1";
	private InetAddress brodecastAddress = null;
	private MulticastSocket socket = null;
	byte[] buff = new byte[DATA_LEN];
	private DatagramPacket inPacket = new DatagramPacket(buff, buff.length);
	private DatagramPacket outPacket = null;
	
	private void init() throws IOException{
		socket = new MulticastSocket(PORT);
		brodecastAddress = InetAddress.getByName(BRODCAST_ADDRESS);
		socket.joinGroup(brodecastAddress);
		outPacket = new DatagramPacket(new byte[0], 0, brodecastAddress, PORT);
		
		Scanner scanner = new Scanner(System.in);
		new Thread(this).start();
		while(scanner.hasNext()){
			byte[] scanBuff = scanner.nextLine().getBytes();
			outPacket.setData(scanBuff);
			socket.send(outPacket);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		while(true){
			try {
				socket.receive(inPacket);
				System.out.println("收到的聊天信息:" + new String(buff,0,inPacket.getLength()));
				
			} catch (IOException e) {
				e.printStackTrace();
				
					try {
						if(socket != null){
							socket.leaveGroup(brodecastAddress);
							socket.close();
						}
						System.exit(1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
}
