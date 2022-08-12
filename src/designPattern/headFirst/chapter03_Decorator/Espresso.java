package designPattern.headFirst.chapter03_Decorator;

public class Espresso extends Beverage{
	public Espresso() {
		description = "에스프레소";
	}
	
	public double cost() {
		return 1000;
	}
}
