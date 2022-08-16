package designPattern.headFirst.chapter04_Factory.factoryMethod;

public class ChicagoPizzaStore extends PizzaStore{
	
	public Pizza createPizza(String type) {
		if("cheese".equals(type)) {
			return new ChicagoCheesePizza();
		}
		else if("extra".equals(type)) {
			return new ChicagoExtraPizza();
		}
		else if("pepperoni".equals(type)) {
			return new ChicagoPepperoniPizza();
		}
		return null;
	}
}
