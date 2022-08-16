package designPattern.headFirst.chapter04_Factory.simpleExample;

public class PizzaStore {
	SimplePizzaFactory simplePizzaFactory;
	
	public PizzaStore(SimplePizzaFactory spf) {
		this.simplePizzaFactory = spf;
	}
	
	public Pizza orderPizza(String type) {
		Pizza pizza = simplePizzaFactory.createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
}
