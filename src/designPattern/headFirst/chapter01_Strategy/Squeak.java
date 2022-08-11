package designPattern.headFirst.chapter01_Strategy;

public class Squeak implements QuackBehavior{
	public void quack() {
		System.out.println("삑삑삑");
	}
}
