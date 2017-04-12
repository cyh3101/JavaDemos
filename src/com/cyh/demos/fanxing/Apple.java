package com.cyh.demos.fanxing;

public class Apple<T> {
	private T info;
	public Apple(){
		
	}
	
	public Apple(T info){
		this.info = info;
	}
	
	public void setInfo(T info){
		this.info = info;
	}
	
	public T getInfo(){
		return this.info;
	}
	
	public static void main(String[] agrs){
		Apple<String> apple1 = new Apple<>("苹果");
		System.out.println(apple1.getInfo());
		
		Apple<Double> apple2 = new Apple<>(4.3);
		System.out.println(apple2.getInfo());
	}
}
