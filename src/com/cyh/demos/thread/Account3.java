package com.cyh.demos.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import jdk.nashorn.internal.ir.Flags;

public class Account3 {
	private String accountNo;
	private double balance;
	private boolean flag = false;
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public Account3(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	public void draw(double drawAmount){
		lock.lock();
		try {
			if(!flag){
				condition.wait();
			}
			else {
				System.out.println(Thread.currentThread().getName() 
						+ "取钱:" + drawAmount);
				this.balance -= drawAmount;
				System.out.println("账户余额:" + this.getBalance());
				flag = false;
				condition.signalAll();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void deposit(double depositAmount){
		lock.lock();
		try {
			if(flag){
				lock.wait();
			}
			else {
				System.out.println(Thread.currentThread().getName() 
						+ "存钱:" + depositAmount);
				this.balance += depositAmount;
				System.out.println("账户余额:" + this.getBalance());
				flag = true;
				lock.notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
}
