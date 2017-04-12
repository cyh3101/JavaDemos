package com.cyh.demos.fanxing;

import java.util.ArrayList;
import java.util.List;

public class DrawShapeTest {

	public static void main(String[] args) {
		Canvas canvas = new Canvas();
		List<Circle> circles = new ArrayList<>();
		canvas.drawAll(circles);
	}

}
