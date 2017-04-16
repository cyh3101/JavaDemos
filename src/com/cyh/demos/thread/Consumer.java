package com.cyh.demos.thread;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
	private BlockingQueue<String> bq ;

	public BlockingQueue<String> getBq() {
		return bq;
	}

	public void setBq(BlockingQueue<String> bq) {
		this.bq = bq;
	}
	
	public Consumer(BlockingQueue<String> bq){
		this.bq = bq;
	}
	
	public void run(){
		for (int i = 0; i < 2000; i++) {
			System.out.println(getName() + "准备消费集合元素");
			try {
				Thread.sleep(200);
				bq.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName() + "消费完成:" + bq);
		}
	}
}
