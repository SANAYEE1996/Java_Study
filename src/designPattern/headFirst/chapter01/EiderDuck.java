package designPattern.headFirst.chapter01;

public class EiderDuck extends Duck{
	
	public EiderDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
	
	public void display() {
		System.out.println("저는 우아한 아이더 오리입니다.");
	}
	
}
