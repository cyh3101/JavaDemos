package com.cyh.demos.thread;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{
	private BlockingQueue<String> bq;

	public BlockingQueue<String> getBq() {
		return bq;
	}

	public void setBq(BlockingQueue<String> bq) {
		this.bq = bq;
	}
	
	public Producer(BlockingQueue<String> bq){
		this.bq = bq;
	}
	
	public void run(){
		String[] strings = new String[]{"java","struts","javascript"};
		for (int i = 0; i < 9999; i++) {
			System.out.println(Thread.currentThread().getName() + "准备生产集合元素");
			try {
				Thread.sleep(100);
				bq.put(strings[i%3]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() 
					+ "生成完成:" + bq);
		}
	}
	
 }
