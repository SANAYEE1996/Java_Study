package designPattern.headFirst.chapter04_Factory.factoryMethod;

public class ChicagoPepperoniPizza extends Pizza{
	public ChicagoPepperoniPizza() {
		name = "시카고 스타일 페퍼로니 피자";
		dough = "아주 두꺼운 크러스트 도우";
		sauce = "엑스터시 소스";
		
		toppings.add("칼로리 폭탄 모짜렐라 치즈");
	}
	
	void cut() {
		System.out.println("네모 모양으로 자르기");
	}
}
