package cleanCode.chapter06.objectShape;

import cleanCode.chapter06.Point;

public class Square implements Shape{
	
	private Point topLeft;
	private double side;
	
	public Square() {
		topLeft.x = side;
		topLeft.y = side;
	}
	
	public double area() {
		return side*side;
	}

}
