package com.cyh.demos.thread;

public class DrawThread1 extends Thread{
	private Account2 account;
	private double drawAmount;
	public Account2 getAccount() {
		return account;
	}
	public void setAccount(Account2 account) {
		this.account = account;
	}
	public double getDrawAmount() {
		return drawAmount;
	}
	public void setDrawAmount(double drawAmount) {
		this.drawAmount = drawAmount;
	}
	
	public DrawThread1(String name,Account2 account,double drawAmount){
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	
	public void run(){
		for (int i = 0; i < 100; i++) {
			this.account.draw(drawAmount);
		}
	}
	
	
}
