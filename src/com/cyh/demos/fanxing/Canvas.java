package com.cyh.demos.fanxing;

import java.util.Iterator;
import java.util.List;

public class Canvas {
	public void drawAll(List<? extends Shape> shapes){
		for (Shape shape : shapes) {
			shape.draw(this);
		}
	}
}
