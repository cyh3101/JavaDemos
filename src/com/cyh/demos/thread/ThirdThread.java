package com.cyh.demos.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThirdThread {

	public static void main(String[] args) throws 
		InterruptedException, ExecutionException {
		
		//ThirdThread rt = new ThirdThread();
		Callable<Integer> callable = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int i = 0;
				for (; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + " " + i);
				}
				return i;
			}
		};
		
		FutureTask<Integer> task = new FutureTask<>(callable);
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
				new Thread(task, "线程1").start();
				new Thread(task, "线程2").start();
			}
			
			System.out.println("返回值:" + task.get());
	}
}
