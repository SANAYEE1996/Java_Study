package designPattern.headFirst.chapter04_Factory;

public class NewYorkCheesePizza extends Pizza{

	public NewYorkCheesePizza() {
		name = "뉴욕 스타일 치즈 피자";
		dough = "씬 크러스트 도우";
		sauce = "마리화나 소스";
		
		toppings.add("아주 잘게 쓴 치즈");
	}

}
