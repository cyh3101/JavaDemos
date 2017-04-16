package com.cyh.demos.thread;

import java.util.concurrent.locks.ReentrantLock;

public class Account1 {
	private final ReentrantLock lock = new ReentrantLock();
	private String accountNo ;
	private double balance;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}

	public Account1(String name,double balance) {
		this.accountNo = name;
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		return accountNo.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNo == null) {
			if (other.getAccountNo() != null)
				return false;
		} else if (!accountNo.equals(other.getAccountNo()))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.getBalance()))
			return false;
		return true;
	}
	
	public synchronized void draw(double drawAmount){
		lock.lock();
		try {
			if(getBalance() >= drawAmount){
				System.out.println(Thread.currentThread().getName() + "取钱成功！取出:" 
						+ drawAmount);
				try {
				Thread.sleep(1);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				balance -= drawAmount;
				System.out.println("\t账户余额为:" + this.getBalance());
			}
			else {
				System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足!");
			}
		} finally {
			lock.unlock();
		}
		
	}
}
