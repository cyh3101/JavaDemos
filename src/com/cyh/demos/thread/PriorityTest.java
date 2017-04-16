package com.cyh.demos.thread;

import com.sun.xml.internal.ws.addressing.v200408.ProblemAction;

public class PriorityTest extends Thread{

	public PriorityTest(String name){
		super(name);
	}
	public void run(){
		for (int i = 0; i < 50; i++) {
			System.out.println(getName() + ",优先级:" + getPriority() + ",循环变量:" + i);
		}
	}
	public static void main(String[] args) {
		Thread.currentThread().setPriority(6);
		for (int i = 0; i < 30; i++) {
			if(i == 10){
				PriorityTest p1 = new PriorityTest("低级");
				p1.start();
				System.out.println("创建之初的优先级:" + p1.getPriority());
				p1.setPriority(Thread.MIN_PRIORITY);
			}
			if(i == 20){
				PriorityTest p2 = new PriorityTest("高级");
				p2.start();
				System.out.println("创建之初的优先级:" + p2.getPriority());
				p2.setPriority(Thread.MAX_PRIORITY);
			}
		}
		
		

	}

}
