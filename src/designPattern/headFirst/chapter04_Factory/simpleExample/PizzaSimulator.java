package designPattern.headFirst.chapter04_Factory.simpleExample;

public class PizzaSimulator {

	public static void main(String[] args) {
		SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
		PizzaStore orderPizza = new PizzaStore(simplePizzaFactory);
		orderPizza.orderPizza("cheese");
		orderPizza.orderPizza("pepperoni");
		orderPizza.orderPizza("");

	}

}
