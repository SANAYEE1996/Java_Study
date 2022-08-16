package designPattern.headFirst.chapter04_Factory;

public class NewYorkPizzaStore extends PizzaStore{

	public Pizza createPizza(String type) {
		if("cheese".equals(type)) {
			return new NewYorkCheesePizza();
		}
		else if("veggie".equals(type)) {
			return new NewYorkVeggiePizza();
		}
		else if("pepperoni".equals(type)) {
			return new NewYorkPepperoniPizza();
		}
		return null;
	}

}
