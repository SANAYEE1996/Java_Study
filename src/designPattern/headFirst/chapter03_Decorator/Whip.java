package designPattern.headFirst.chapter03_Decorator;

public class Whip extends CondimentDecorator{
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public double cost() {
		return beverage.cost() + 700;
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", 휘핑크림";
	}
}
