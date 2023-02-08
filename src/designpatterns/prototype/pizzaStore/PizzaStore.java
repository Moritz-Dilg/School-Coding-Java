package designpatterns.prototype.pizzaStore;

import designpatterns.prototype.pizzaStore.dishes.Pizza;
import designpatterns.prototype.pizzaStore.dishes.Spaghetti;

/**
 * Implementation of a pizza store using no design pattern
 */
public class PizzaStore {

    private final Pizza pizzaPrototype;
    private final Spaghetti spaghettiPrototype;

    public PizzaStore(AbstractDishFactory factory) {
        this.pizzaPrototype = factory.createPizza();
        this.spaghettiPrototype = factory.createSpaghetti();
    }

    public Pizza orderPizza() {
        Pizza pizza = this.pizzaPrototype.clone();

        pizza.prepare();
        pizza.bake();
        pizza.box();
        return pizza;
    }

    public Spaghetti orderSpaghetti() {
        Spaghetti spaghetti = this.spaghettiPrototype.clone();

        spaghetti.cook();
        return spaghetti;
    }
}
