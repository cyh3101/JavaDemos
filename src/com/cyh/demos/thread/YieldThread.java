package com.cyh.demos.thread;

public class YieldThread extends Thread{

	public YieldThread(String name){
		super(name);
	}
	
	public void run(){
		for (int i = 0; i < 50; i++) {
			System.out.println(getName() + " " + i);
			if(i == 20){
				Thread.yield();
			}
		}
	}
	public static void main(String[] args) {
		YieldThread y1 = new YieldThread("高级");
		y1.setPriority(Thread.MAX_PRIORITY);
		y1.start();
		
		YieldThread y2 = new YieldThread("低级");
		y2.setPriority(Thread.MIN_PRIORITY);
		y2.start();

	}

}
