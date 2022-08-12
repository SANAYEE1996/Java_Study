package designPattern.headFirst.chapter03_Decorator;

public abstract class Beverage {
	public enum Size {TALL, GRANDE, VENTI};
	String description = "추후 수정";
	Size size = Size.TALL;
	
	public String getDescription() {
		return description;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Size getSize() {
		return this.size;
	}
	
	public abstract double cost();
}
