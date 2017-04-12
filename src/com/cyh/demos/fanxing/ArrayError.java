package com.cyh.demos.fanxing;

public class ArrayError {

	public static void main(String[] args) {
		Integer[] ia = new Integer[5];
		
		Number[] na = ia;
		
		na[0] = 1.5;

	}

}
