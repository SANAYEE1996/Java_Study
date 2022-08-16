package designPattern.headFirst.chapter04_Factory.abstractFactory;

public class PizzaSimulator {
	public static void main(String[] args) {
		NewYorkPizzaStore orderPizza = new NewYorkPizzaStore();
		orderPizza.orderPizza("cheese");
		
	}
}
