package designPattern.headFirst.chapter04_Factory.factoryMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
	
	String name;
	String dough;
	String sauce;
	List<String> toppings = new ArrayList<>();
	
	void prepare() {
		System.out.println("준비중 : " +name);
		System.out.println("도우를 돌리는 중 ...");
		System.out.println("소스를 뿌리는 중 ...");
		System.out.print("토핑을 올리는 중 : ");
		for(String topping : toppings) {
			System.out.print(" "+topping);
		}
		System.out.println();
	}
	void bake() {
		System.out.println("굽기");
	}
	void cut() {
		System.out.println("자르기");
	}
	void box() {
		System.out.println("박스에 담기");
	}
	public String getName() {
		return name;
	}
}
