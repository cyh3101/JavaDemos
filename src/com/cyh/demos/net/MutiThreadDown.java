package com.cyh.demos.net;

import java.io.IOException;


public class MutiThreadDown {

	public static void main(String[] args) throws IOException {
		final DownUtil downUtil = new DownUtil(
				"http://t2.27270.com/uploads/tu/201610/198/qq1tnlra4ph.jpg", 
				"aaa.png", 4);
		downUtil.download();
		
		new Thread(()->{
			while(downUtil.getPercent() < 1){
				System.out.println("已经完成:" + downUtil.getPercent());
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

}
