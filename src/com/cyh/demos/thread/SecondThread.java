package com.cyh.demos.thread;

import com.sun.jmx.snmp.SnmpOidDatabaseSupport;

public class SecondThread implements Runnable{

	private int i;
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if(i == 20){
				SecondThread st = new SecondThread();
				new Thread(st, "线程1").start();
				new Thread(st, "线程2").start();
			}
		}
	}

	@Override
	public void run() {
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		
	}

}
