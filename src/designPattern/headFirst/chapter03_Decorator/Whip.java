package designPattern.headFirst.chapter03_Decorator;

public class Whip extends CondimentDecorator{
	
	private double cost;
	
	public Whip(Beverage beverageFrom) {
		this.beverage = beverageFrom;
		this.cost = beverageFrom.cost();
	}
	
	public Whip(Beverage beverageFrom, Size size) {
		this.beverage = beverageFrom;
		this.cost = beverageFrom.cost();
		this.size = size;
	}
	
	public double cost() {
		return sizeCost() + 700;
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", 휘핑크림" + size +" 사이즈";
	}

	public double sizeCost() {
		if(size.equals(Size.TALL)) {
			return cost;
		}
		else if(size.equals(Size.GRANDE)) {
			return cost + 1000;
		}
		else if(size.equals(Size.VENTI)) {
			return cost + 2000;
		}
		return 0;
	}
}
