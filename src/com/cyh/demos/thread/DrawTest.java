package com.cyh.demos.thread;

public class DrawTest {

	public static void main(String[] args) {
		//Account account = new Account("123456",1000);
		Account1 account1 = new Account1("123456",1000);
		new DrawThread("甲", account1, 800).start();
//		new DrawThread("甲", account1, 800).start();
		new DrawThread("乙", account1, 800).start();

	}

}
