package designPattern.headFirst.chapter03_Decorator;

public abstract class Beverage {
	String description = "추후 수정";
	
	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
}
