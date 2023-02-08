package designpatterns.prototype.pizzaStore.dishes;

import designpatterns.prototype.pizzaStore.AbstractDishFactory;

public class AmericanPizzaFactory extends AbstractDishFactory {

    @Override
    public Pizza createPizza() {
        return new AmericanPizza();
    }

    @Override
    public Spaghetti createSpaghetti() {
        return new Spaghetti("american");
    }
}
