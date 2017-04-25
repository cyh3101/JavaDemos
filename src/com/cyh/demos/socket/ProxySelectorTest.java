package com.cyh.demos.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProxySelectorTest {
	private static final int PORT = 5000;
	private static final String PROXY_ADD = "192.168.11.103";
	private static String urlStr = "http://www.baidu.com";
	public static void main(String[] args) throws IOException {
		ProxySelector.setDefault(new ProxySelector() {
			
			@Override
			public List<Proxy> select(URI uri) {
				List<Proxy> result = new ArrayList<>();
				result.add(new Proxy(Type.HTTP
						, new InetSocketAddress(PROXY_ADD, PORT)));
				return result;
			}
			
			@Override
			public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
				System.out.println("无法连接到代理服务器");
			}
		});
		
		URL url = new URL(urlStr);
		URLConnection conn = url.openConnection();
		conn.setConnectTimeout(3000);
		
		Scanner scanner = new Scanner(conn.getInputStream());
		PrintStream ps = new PrintStream("index.html");
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			System.out.println(line);
			ps.print(line);
			
		}
	}

}
