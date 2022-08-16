package designPattern.headFirst.chapter04_Factory;

public class NewYorkCheesePizza extends Pizza{

	public void prepare() {
		System.out.println("뉴욕 치즈 피자 준비");
	}

	public void bake() {
		System.out.println("뉴욕 치즈 피자 굽기");
	}

	public void cut() {
		System.out.println("뉴욕 치즈 피자 자르기");
	}

	public void box() {
		System.out.println("뉴욕 치즈 피자 포장");
	}

}
