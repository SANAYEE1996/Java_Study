package designPattern.headFirst.chapter03_Decorator;

public class Hazelnut extends CondimentDecorator{
	public Hazelnut(Beverage beverage) {
		this.beverage = beverage;
	}
	
	
	public double cost() {
		return beverage.cost() + 500; 
	}

	public String getDescription() {
		return beverage.getDescription() + ", 헤이즐넛";
	}
}
