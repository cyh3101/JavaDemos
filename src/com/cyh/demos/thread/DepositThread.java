package com.cyh.demos.thread;

public class DepositThread extends Thread{
	private Account2 account;
	private double depositAmount;
	public Account2 getAccount() {
		return account;
	}
	public void setAccount(Account2 account) {
		this.account = account;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public DepositThread(String name,Account2 account, double depositAmount) {
		super(name);
		this.account = account;
		this.depositAmount = depositAmount;
	}
	
	public void run(){
		for (int i = 0; i < 100; i++) {
			this.account.deposit(depositAmount);
		}
	}
}
