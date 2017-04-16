package com.cyh.demos.thread;

public class DaemonThread extends Thread{

	private int i;
	public void run(){
		for (; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
	public static void main(String[] args) {
		DaemonThread dt = new DaemonThread();
		dt.setDaemon(true);
		dt.start();
		for (int j = 0; j < 100; j++) {
			System.out.println(Thread.currentThread().getName() + " " + j);
		}
	}

}
