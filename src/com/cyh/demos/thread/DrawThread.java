package com.cyh.demos.thread;

public class DrawThread extends Thread{

	//private Account account;
	private Account1 account1;
	private double drawAmount;

	public Account1 getAccount() {
		return account1;
	}
	public void setAccount(Account1 account) {
		this.account1 = account;
	}
	public double getDrawAmount() {
		return drawAmount;
	}
	public void setDrawAmount(double drawAmount) {
		this.drawAmount = drawAmount;
	}
	public DrawThread(String name,Account1 account,double drawAmount){
		super(name);
		this.account1 = account;
		this.drawAmount = drawAmount;
	}
	public void run(){
		account1.draw(800);
		
	}
}
