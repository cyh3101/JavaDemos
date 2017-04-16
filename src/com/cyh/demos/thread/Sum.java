package com.cyh.demos.thread;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

import sun.misc.MetaIndex;

class CalTask extends RecursiveTask<Integer>{
	private static final int THRSHORT = 50;
	private int arr[];
	private int start;
	private int end;
	public CalTask(int[] arr, int start, int end) {
		super();
		this.arr = arr;
		this.start = start;
		this.end = end;
	}
	@Override
	protected Integer compute() {
		int sum = 0;
		if(end - start < THRSHORT){
			for (int i = start; i < end; i++) {
				sum += arr[i];
			}
			return sum;
		}
		else {
			int middle = (start + end) / 2;
			CalTask left = new CalTask(arr, start, middle);
			CalTask right = new CalTask(arr, middle, end);
			left.fork();
			right.fork();
			return left.join() + right.join();
		}
	}
	
}
public class Sum {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] arr = new int[1000000];
		Random random = new Random();
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(20);
			
		}
		long startTime1=System.currentTimeMillis(); 
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		System.out.println(total);
		long endTime1=System.currentTimeMillis(); 
		System.out.println(endTime1 - startTime1);
		
		
		long startTime=System.currentTimeMillis(); 
		ForkJoinPool pool = new ForkJoinPool();
		Future<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
		System.out.println(future.get());
		pool.shutdown();
		long endTime=System.currentTimeMillis(); 
		System.out.println(endTime - startTime);
	}

}
