package com.cyh.demos.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ComUtil {
	public final static String CHARSET = "utf-8";
	private final static int BRODCAST_PORT = 5000;
	private final static int SINGLE_PORT = BRODCAST_PORT + 1;
	private final String BROADCAST_ADDRESS = "230.0.0.1";
	private final static int DATA_LEN = 4096;
	private InetAddress broadAddress = null;
	private MulticastSocket socket = null;
	private DatagramSocket singleSocket = null;
	private byte[] buff = new byte[DATA_LEN];
	private DatagramPacket inPacket= new DatagramPacket(buff, 0, buff.length);
	private DatagramPacket outPacket = null;
	private LanTalk lanTalk;
	
	public ComUtil(LanTalk lanTalk) throws IOException{
		this.lanTalk = lanTalk; 
		
		socket = new MulticastSocket(BRODCAST_PORT);
		singleSocket = new DatagramSocket(SINGLE_PORT);
		broadAddress = InetAddress.getByName(BROADCAST_ADDRESS);
		socket.joinGroup(broadAddress);
		socket.setLoopbackMode(false);
		outPacket = new DatagramPacket(new byte[0], 0, broadAddress, BRODCAST_PORT);
	}
	
	//发送私信
	public void sendSingle(String msg ,SocketAddress socketAddress){
		
		try {
			byte[] buff = msg.getBytes();
			DatagramPacket packet = new DatagramPacket(buff , 0 , buff.length , socketAddress);
			singleSocket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
			if(singleSocket != null){
				singleSocket.close();
			}
			JOptionPane.showMessageDialog(null, "接收信息异常，请确认端口空闲，网络是否正常"
					,"网络异常",JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	
	//群发消息
	public void broadCast(String msg){
		try {
			byte[] buff = msg.getBytes();
			outPacket.setData(buff);
			socket.send(outPacket);
		} catch (IOException e) {
			e.printStackTrace();
			if(socket != null){
				socket.close();
			}
			JOptionPane.showMessageDialog(null, "接收信息异常，请确认端口空闲，网络是否正常"
					,"网络异常",JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	
	class ReadSingle extends Thread{
		byte[] buff = new byte[DATA_LEN];
		DatagramPacket packet = new DatagramPacket(buff, buff.length);
		public void run(){
			while(true){
				try {
					singleSocket.receive(packet);
					lanTalk.processMsg(packet,true);
				} catch (IOException e) {
					e.printStackTrace();
					if(singleSocket != null){
						singleSocket.close();
					}
					JOptionPane.showMessageDialog(null, "接收信息异常，请确认端口空闲，网络是否正常"
							,"网络异常",JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}
		}
	}
	
	class ReadBroadCast extends Thread{
		public void run(){
			while(true){
				try {
					socket.receive(inPacket);
					String msg = new String(buff, 0, inPacket.getLength(), CHARSET);
					//读到的信息为用户的信息
					if(msg.startsWith(YeekuProtocol.PRESENCE) 
							&& msg.endsWith(YeekuProtocol.PRESENCE)){
						String userMsg = msg.substring(2, msg.length() - 2);
						String[] userInfo = userMsg.split(YeekuProtocol.SPLITTER);
						UserInfo user = new UserInfo(userInfo[1], 
								userInfo[0], inPacket.getSocketAddress(), 0);
						boolean addFlag = true;
						ArrayList<Integer> delList = new ArrayList<>();
						for (int i = 0; i < lanTalk.getUserNum(); i++) {
							UserInfo current = lanTalk.getUser(i);
							current.setLost(current.getLost() + 1);
							if(current.equals(user)){
								current.setLost(0);
								addFlag = false;
							}
							if(current.getLost() > 2){
								delList.add(i);
							}
						}
						for (int i = 0; i < delList.size(); i++) {
							lanTalk.removeUser(delList.get(i));
						}
						if(addFlag){
							lanTalk.addUser(user);
						}
					}
					//读到的信息为公聊的信息
					else {
						lanTalk.processMsg(inPacket, false);
					}
				} catch (IOException e) {
					e.printStackTrace();
					if(socket != null){
						socket.close();
					}
					JOptionPane.showMessageDialog(null, "接收信息异常，请确认端口空闲，网络是否正常"
							,"网络异常",JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}
		}
	}
}
