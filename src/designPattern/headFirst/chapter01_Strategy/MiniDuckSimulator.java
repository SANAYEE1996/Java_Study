package designPattern.headFirst.chapter01_Strategy;

public class MiniDuckSimulator {

	public static void main(String[] args) {
		Duck eider = new EiderDuck();
		eider.performFly();
		eider.performQuack();
		
		Duck modelDuck = new ModelDuck();
		modelDuck.performFly();
		modelDuck.setFlyBehavior(new FlyWithRocket());
		modelDuck.performFly();
	}
	

}
