package designPattern.headFirst.chapter01_Strategy;

public class FlyNoWay implements FlyBehavior{
	public void fly() {
		System.out.println("날지 못합니다.");
	}
}
