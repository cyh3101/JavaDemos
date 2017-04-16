package com.cyh.demos.net;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownThread extends Thread{
	private int startPos;
	private int currentSize;
	private String path;
	private RandomAccessFile currentPart;
	public int length;
	public DownThread(String path,int startPos, int currentSize, RandomAccessFile currentPart) {
		super();
		this.path = path;
		this.startPos = startPos;
		this.currentSize = currentSize;
		this.currentPart = currentPart;
	}
	
	public void run(){
		try {
			URL url = new URL(path);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setConnectTimeout(5 * 1000);
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", 
					"image/gif,image/jpeg,image/pjpeg,image/pjpeg,"
					+ "application/x-shockwave-flash,application/xaml+xml,"
					+ "application/vnd.ms-xpsdocument,application/x-ms-xbap,"
					+ "application/x-ms-application,application/vnd.ms-excel,"
					+ "application/vnd.ms-powerpoint,application/msword,*/*");
			con.setRequestProperty("Accept-Language", "zh-CN");
			con.setRequestProperty("Charset", "UTF-8");
			InputStream inputStream = con.getInputStream();
			inputStream.skip(startPos);
			byte[] byts = new byte[1024];
			int hasRead = 0;
			while(length < currentSize && (hasRead = inputStream.read(byts)) != -1){
				currentPart.write(byts, 0, hasRead);
				length += hasRead;
			}
			currentPart.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
