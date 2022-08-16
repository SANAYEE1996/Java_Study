package designPattern.headFirst.chapter04_Factory.abstractFactory;

import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.cheese.Cheese;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.cheese.ReggianoCheese;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.clam.Clams;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.clam.FreshClams;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.dough.Dough;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.dough.ThinCrustDough;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.pepperoni.Pepperoni;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.pepperoni.SlicedPepperoni;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.sauce.MarinaraSauce;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.sauce.Sauce;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.vegetable.Garlic;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.vegetable.Veggies;

public class NewYorkPizzaIngredientFactory implements PizzaIngredientFactory{

	public Dough createDough() {
		return new ThinCrustDough();
	}

	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = {new Garlic()};
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}

}
