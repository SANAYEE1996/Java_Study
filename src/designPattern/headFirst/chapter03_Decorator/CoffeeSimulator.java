package designPattern.headFirst.chapter03_Decorator;

public class CoffeeSimulator {

	public static void main(String[] args) {
		Beverage orderFirstCoffee = new Espresso();
		orderFirstCoffee = new Hazelnut(orderFirstCoffee);
		orderFirstCoffee = new Whip(orderFirstCoffee);
		System.out.println("첫 번째 커피 설명 : "+orderFirstCoffee.getDescription()+" , 가격 : "+orderFirstCoffee.cost());
		
		Beverage orderSecondCoffee = new Americano();
		orderSecondCoffee = new Hazelnut(orderSecondCoffee);
		orderSecondCoffee = new Whip(orderSecondCoffee);
		System.out.println("두 번째 커피 설명 : "+orderSecondCoffee.getDescription()+" , 가격 : "+orderSecondCoffee.cost());
		
	}

}
