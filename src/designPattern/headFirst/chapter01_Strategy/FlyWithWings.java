package designPattern.headFirst.chapter01_Strategy;

public class FlyWithWings implements FlyBehavior{
	public void fly() {
		System.out.println("날개로 날고 있습니다.");
	}
}
