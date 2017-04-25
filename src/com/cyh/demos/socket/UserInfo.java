package com.cyh.demos.socket;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class UserInfo {
	private String userName = "";
	private String icon = "";
	private SocketAddress address;
	private int lost;
	private ChatFrame chatFrame;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public SocketAddress getAddress() {
		return address;
	}
	public void setAddress(SocketAddress address) {
		this.address = address;
	}
	public int getLost() {
		return lost;
	}
	public void setLost(int lost) {
		this.lost = lost;
	}
	public ChatFrame getChatFrame() {
		return chatFrame;
	}
	public void setChatFrame(ChatFrame chatFrame) {
		this.chatFrame = chatFrame;
	}
	public UserInfo(String userName, String icon, SocketAddress address, int lost) {
		super();
		this.userName = userName;
		this.icon = icon;
		this.address = address;
		this.lost = lost;
	}
	@Override
	public int hashCode() {
		return this.address.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj.getClass() == this.getClass()){
			UserInfo userInfo = (UserInfo)obj;
			if(address != null){
				return this.address.equals(userInfo.address);
			}
		}
		return false;
	}
	
}
