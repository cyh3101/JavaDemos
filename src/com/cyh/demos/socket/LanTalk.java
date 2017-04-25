package com.cyh.demos.socket;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class LanTalk extends JFrame{
	private static DatagramPacket packet = null;
	private DefaultListModel<UserInfo> listModel = new DefaultListModel<>();
	private JList<UserInfo> friendsList = new JList<>(listModel);
	private DateFormat formatter = DateFormat.getDateTimeInstance();
	
	public LanTalk(){
		super("局域网聊天");
		friendsList.setCellRenderer(new ImageCellRenderer());
		listModel.addElement(new UserInfo("所有人" , "all" , null, -2000));
	}
	
	//通过用户的地址返回用户的实例
	public UserInfo getUserBySocketAddress(SocketAddress address){
		for (int i = 0; i < getUserNum(); i++) {
			UserInfo user = getUser(i);
			if(user.getAddress() != null && user.getAddress().equals(address)){
				return user;
			}
		}
		return null;
	}
	
	public int getUserNum(){
		return this.listModel.getSize();
	}
	
	public UserInfo getUser(int pos){
		return this.listModel.getElementAt(pos);
	}
	
	public void removeUser(int pos){
		this.listModel.removeElementAt(pos);
	}
	
	public void addUser(UserInfo user){
		this.listModel.addElement(user);
	}
	
	/*
	 * 处理网络中发送过来的聊天信息，该方法通过聊天的信息得到聊天者
	 * 并将聊天的信息显示在相应的对话框中
	 * @param packet 需要处理的数据包
	 * @param single 是否为私聊
	 */
	public void processMsg(DatagramPacket packet , boolean single){
		//获得聊天的地址信息
		InetSocketAddress address = (InetSocketAddress)packet.getSocketAddress();
		if(single){
			address = new InetSocketAddress(address.getHostName()
					,address.getPort() - 1);
			UserInfo user = getUserBySocketAddress(address);
			if(user != null){
				UserInfo alertUser = single ? user : getUser(0);
				if(alertUser.getChatFrame() == null){
					alertUser.setChatFrame(new ChatFrame(null,alertUser));
				}
				String tipMsg = single ? "对您说:" : "对大家说:" ;
				
				try {
					alertUser.getChatFrame().addString(user.getUserName() 
							+ tipMsg + "........." + "("
							+ formatter.format(new Date() + ")\n")
							+ new String(packet.getData()
									, 0, packet.getLength(), ComUtil.CHARSET) + "\n");
					
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				if( !alertUser.getChatFrame().isShowing()){
					alertUser.getChatFrame().setVisible(true);
				}
			}
		}
	}
	
	public static void main(String[] args){
		LanTalk lanTalk = new LanTalk();
		new LoginFrame(lanTalk,  "输入用户和头像以后登陆");
	}
	
	class ChangeMusicLisenter extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(e.getClickCount() > 2){
				UserInfo userInfo = (UserInfo)friendsList.getSelectedValue();
				if(userInfo.getChatFrame() == null){
					userInfo.setChatFrame(new ChatFrame(null, userInfo));
				}
				if(!userInfo.getChatFrame().isShowing()){
					userInfo.getChatFrame().setVisible(true);
				}
			}
		}
	}
	class ImageCellRenderer extends JPanel implements ListCellRenderer<UserInfo>{
		
		private ImageIcon icon;
		private String name;
		private Color background;
		private Color foreground;
		@Override
		public Component getListCellRendererComponent(JList<? extends UserInfo> list, UserInfo useInfo, int index,
				boolean isSelected, boolean cellHasFocus) {
			//设置图标
			icon = new ImageIcon("icon/" + useInfo.getIcon() + ".gif");
			name = useInfo.getUserName();
			
			background = isSelected ? list.getSelectionBackground() : list.getBackground();
			foreground = isSelected ? list.getSelectionForeground() : list.getForeground();
			
			return this;
		}
		
		public void paintComponent(Graphics g){
			int width = icon.getImage().getWidth(null);
			int height = icon.getImage().getHeight(null);
			g.setColor(background);
			g.fillRect(0, 0, width, height);
			g.setColor(foreground);
			g.drawImage(icon.getImage(), getWidth() / 2 - width / 2, 10, null);
			g.setFont(new Font("SansSerit" , Font.BOLD , 18));
			g.drawString(name, getWidth() / 2 - name.length() * 10 , height + 30);
		}
		
		public Dimension getPreferredSize(){
			return new Dimension(60 , 80);
		}
		
	}
}
