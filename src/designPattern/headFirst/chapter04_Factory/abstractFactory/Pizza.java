package designPattern.headFirst.chapter04_Factory.abstractFactory;

import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.cheese.Cheese;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.clam.Clams;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.dough.Dough;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.pepperoni.Pepperoni;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.sauce.Sauce;
import designPattern.headFirst.chapter04_Factory.abstractFactory.ingredient.vegetable.Veggies;

public abstract class Pizza {
	String name;
	
	Dough dough;
	Sauce sauce;
	Veggies veggies[];
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clam;
	
	abstract void prepare();
	
	void bake() {
		
	}
	
	void cut() {
		
	}
	
	void box() {
		
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}
	
	public String toString() {
		return getName();
	}
}
