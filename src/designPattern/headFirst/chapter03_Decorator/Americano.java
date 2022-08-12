package designPattern.headFirst.chapter03_Decorator;

public class Americano extends Beverage{
	public Americano() {
		description = "아메리카노";
	}
	
	public double cost() {
		return 2000;
	}
}
