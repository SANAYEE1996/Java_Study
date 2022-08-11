package designPattern.headFirst.chapter01_Strategy;

public class FlyWithRocket implements FlyBehavior{
	public void fly() {
		System.out.println("로켓 추진력으로 날고 있습니다.");
	}
}
