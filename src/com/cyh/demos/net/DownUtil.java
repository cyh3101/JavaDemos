package com.cyh.demos.net;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import org.omg.CORBA.PUBLIC_MEMBER;


public class DownUtil {
	//定义要下载的文件的路径
	private String path;
	//定义要下载的文件下载以后存放的保存位置
	private String targetFile;
	//下载需要启动的线程的数量
	private int threadNum;
	private DownThread[] threads;
	//需要下载的文件的大小
	private int fileSize;
	public DownUtil(String path, String targetFile, int threadNum) {
		super();
		this.path = path;
		this.targetFile = targetFile;
		this.threadNum = threadNum;
		threads = new DownThread[threadNum];
	}
	
	public void download() throws IOException {
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
		con.setRequestProperty("Connection", "Keep-Alive");
		fileSize = con.getContentLength();
		con.disconnect();
		int currentPartSize = fileSize / threadNum + 1;
		RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
		file.setLength(fileSize);
		file.close();
		for (int i = 0; i < threadNum; i++) {
			int startPos = i * currentPartSize;
			RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
			currentPart.seek(startPos);
			threads[i] = new DownThread(path,startPos, currentPartSize, currentPart);
			threads[i].start();
		}
	}
	
	public double getPercent(){
		int sumSize = 0;
		for (int i = 0; i < threads.length; i++) {
			sumSize += threads[i].length;
		}
		return sumSize * 1.0 / fileSize;
	}
}
