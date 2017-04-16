package com.cyh.demos.thread;

public class DrawTest2 {

	public static void main(String[] args) {
		Account2 account2 = new Account2("123456", 1000);
		new DrawThread1("取款人", account2, 800).start();
		new DepositThread("存款人1", account2, 800).start();
		new DepositThread("存款人2", account2, 800).start();
	}

}
