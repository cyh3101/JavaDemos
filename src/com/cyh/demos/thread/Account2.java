package com.cyh.demos.thread;


public class Account2 {
	//private final ReentrantLock lock = new ReentrantLock();
	private String accountNo ;
	private double balance;
	private boolean flag = false;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}

	public Account2(String name,double balance) {
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
		try {
			if(!flag){
				wait();
			}
			else {
				System.out.println(Thread.currentThread().getName() 
						+ "取钱:" + drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额为:" + balance);
				
				flag = false;
				notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized void deposit(double depositAmount){
		try {
			if(flag){
				wait();
			}
			else {
				System.out.println(Thread.currentThread().getName()
						+ "存钱:" + depositAmount);
				balance += depositAmount;
				System.out.println("账户余额:" + balance);
				
				flag = true;
				notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
