package com.cyh.demos.thread;


public class Account {
	//private final ReentrantLock lock = new ReentrantLock();
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

	public Account(String name,double balance) {
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
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}
	
	public synchronized void draw(double drawAmount){
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
	}
}
