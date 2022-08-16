package designPattern.headFirst.chapter04_Factory.factoryMethod;

public class PizzaSimulator {

	public static void main(String[] args) {
		
		NewYorkPizzaStore newYorkPizzaStore = new NewYorkPizzaStore();
		newYorkPizzaStore.orderPizza("cheese");
		newYorkPizzaStore.orderPizza("veggie");
		newYorkPizzaStore.orderPizza("pepperoni");
		
		ChicagoPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
		chicagoPizzaStore.orderPizza("cheese");
		chicagoPizzaStore.orderPizza("pepperoni");
		chicagoPizzaStore.orderPizza("extra");
		

	}

}
