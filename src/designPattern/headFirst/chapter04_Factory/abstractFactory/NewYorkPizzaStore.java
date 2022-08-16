package designPattern.headFirst.chapter04_Factory.abstractFactory;

public class NewYorkPizzaStore extends PizzaStore{

	public Pizza createPizza(String type) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new NewYorkPizzaIngredientFactory();
		
		if("cheese".equals(type)) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("뉴욕 치즈 피자");
		}
		
		return pizza;
	}

}
