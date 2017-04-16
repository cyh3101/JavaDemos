package com.cyh.demos.thread;

public class MyThread extends Thread{
	public MyThread(String name){
		super(name);
	}
	public MyThread(String name,ThreadGroup group){
		super(group, name);
	}
	public void run(){
		for (int i = 0; i < 20; i++) {
			System.out.println(getName() + "变量i:" + i);
		}
	}
}
