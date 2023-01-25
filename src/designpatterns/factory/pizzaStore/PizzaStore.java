package designpatterns.factory.pizzaStore;

import designpatterns.factory.pizzaStore.dishes.Pizza;
import designpatterns.factory.pizzaStore.dishes.Spaghetti;

/**
 * Implementation of a pizza store using no design pattern
 */
public class PizzaStore {

	private AbstractDishFactory factory;

	public PizzaStore(AbstractDishFactory factory) {
		this.factory = factory;
	}

	public Pizza orderPizza() {
		Pizza pizza = factory.createPizza();

		pizza.prepare();
		pizza.bake();
		pizza.box();
		return pizza;
	}

	public Spaghetti orderSpaghetti() {
		Spaghetti spaghetti = factory.createSpaghetti();

		spaghetti.cook();
		return spaghetti;
	}
}
