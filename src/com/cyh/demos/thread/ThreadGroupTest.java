package com.cyh.demos.thread;

public class ThreadGroupTest {

	public static void main(String[] args) {
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("主线程的名字:" + mainGroup.getName());
		System.out.println("主线程是否为后台主线程组:" + mainGroup.isDaemon());
		
		new MyThread("主线程组的线程").start();
		
		ThreadGroup tg = new ThreadGroup("新的线程组");
		tg.setDaemon(true);
		System.out.println("tg线程组是否为后台主线程组:" + tg.isDaemon());
		
		MyThread mt = new MyThread("tg组的线程1", tg);
		mt.start();
		new MyThread("tg组的线程2", tg).start();

	}

}
