package designPattern.headFirst.chapter04_Factory;

public class NewYorkVeggiePizza extends Pizza{
	
	public void prepare() {
		System.out.println("뉴욕 베기 피자 준비");
	}

	public void bake() {
		System.out.println("뉴욕 베기 피자 굽기");
	}

	public void cut() {
		System.out.println("뉴욕 베기 피자 자르기");
	}

	public void box() {
		System.out.println("뉴욕 베기 피자 포장");
	}
}
