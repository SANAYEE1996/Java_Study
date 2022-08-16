package designPattern.headFirst.chapter04_Factory.abstractFactory;

import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.cheese.Cheese;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.clam.Clams;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.dough.Dough;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.pepperoni.Pepperoni;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.sauce.Sauce;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.vegetable.Veggies;

public interface PizzaIngredientFactory {
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
}
