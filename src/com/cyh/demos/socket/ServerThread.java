package com.cyh.demos.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ServerThread implements Runnable{
	Socket s = null;
	BufferedReader br = null;
	
	public ServerThread(Socket s) throws IOException {
		this.s = s;
		this.br = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
	}
	@Override
	public void run() {
		try {
			String content = null;
			while((content = br.readLine()) != null){
				for (Socket s : MyServer.socketList) {
					PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
					pw.println(content);
				}
			}
			//蔡于慧
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			MyServer.socketList.remove(s);
			e.printStackTrace();
		}finally {
			try {
				if (br != null) {
					br.close();
				}
				if(s != null){
					s.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
