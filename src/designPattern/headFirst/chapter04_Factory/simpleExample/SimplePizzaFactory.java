package designPattern.headFirst.chapter04_Factory.simpleExample;

public class SimplePizzaFactory {
	public Pizza createPizza(String type) {
		if("cheese".equals(type)) {
			return new CheesePizza();
		}
		else if("pepperoni".equals(type)) {
			return new PepperoniPizza();
		}
		return new DefaultPizza();
	}
}
