package designpatterns.factory.pizzaStore.dishes;

import designpatterns.factory.pizzaStore.AbstractDishFactory;

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
