package designPattern.headFirst.chapter04_Factory.simpleExample;

public class CheesePizza extends Pizza{

	public void prepare() {
		System.out.println("치즈 피자 준비");
	}

	public void bake() {
		System.out.println("치즈 피자 굽기");
	}

	public void cut() {
		System.out.println("치즈 피자 자르기");
	}

	public void box() {
		System.out.println("치즈 피자 포장하기");
	}

}
