package designPattern.headFirst.chapter01_Strategy;

public class DuckCaller {
	QuackBehavior quackBehavior;
	
	public void quackCaller() {
		quackBehavior = new Quack();
	}
	
	public void squeakCaller() {
		quackBehavior = new Squeak();
	}
}
