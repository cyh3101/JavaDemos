package com.cyh.demos.reflect;

public class GunDog implements Dog{

	@Override
	public void info() {
		System.out.println("猎狗");
		
	}

	@Override
	public void run() {
		System.out.println("奔跑迅速");
		
	}

}
