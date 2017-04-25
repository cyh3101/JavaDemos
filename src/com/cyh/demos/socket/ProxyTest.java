package com.cyh.demos.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Scanner;

public class ProxyTest {

	private static final int PORT = 5326;
	private static final String PROXY_ADD = "192.168.11.103";
	private String urlStr = "http://www.baidu.com";
	
	public void init(){
		try {
			Properties properties = System.getProperties();
			properties.setProperty("http.nonProxyHosts", "localhost|192.168.11.103");
			
			URL url = new URL(urlStr);
//			Proxy proxy = new Proxy(Proxy.Type.DIRECT
//					, new InetSocketAddress(PROXY_ADD, PORT));
			Proxy proxy = new Proxy(Type.HTTP
					, new InetSocketAddress(PROXY_ADD, PORT));
			URLConnection conn = url.openConnection(proxy);
			conn.setConnectTimeout(3000);
			
			Scanner scanner = new Scanner(conn.getInputStream());
			PrintStream ps = new PrintStream("index.html");
			while(scanner.hasNext()){
				String line = scanner.nextLine();
				System.out.println(line);
				ps.print(line);
				
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new ProxyTest().init();
	}

}
