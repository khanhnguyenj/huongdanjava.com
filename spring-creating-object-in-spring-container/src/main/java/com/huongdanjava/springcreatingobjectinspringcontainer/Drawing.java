package com.huongdanjava.springcreatingobjectinspringcontainer;

public class Drawing {
	private Shape shape;

	public Drawing() {
	}

	public Drawing(Shape shape) {
		this.shape = shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public void preparing() {
		System.out.println("Preparing ...");
	}

	public void draw() {
		shape.draw();
	}
}
