package designPattern.headFirst.chapter01_Strategy;

public class Quack implements QuackBehavior{
	public void quack() {
		System.out.println("꽥꽥꽥");
	}
}
