package designPattern.headFirst.chapter01_Strategy;

public class ModelDuck extends Duck{
	
	
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}
	public void display() {
		System.out.println("모형 오리입니다.");
	}

}
