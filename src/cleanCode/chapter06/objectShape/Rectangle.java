package cleanCode.chapter06.objectShape;

import cleanCode.chapter06.Point;

public class Rectangle implements Shape{
	
	private Point topLeft;
	private double height = 1;
	private double width = 1;
	
	public Rectangle() {
		topLeft.x = width;
		topLeft.y = height;
	}
	
	public double area() {
		return height*width;
	}
}
