package designPattern.headFirst.chapter03_Decorator;

public abstract class CondimentDecorator extends Beverage{
	Beverage beverage;
	public abstract String getDescription();
}
