package designpatterns.factory.pizzaStore.dishes;

import designpatterns.factory.pizzaStore.AbstractDishFactory;

public class ItalianPizzaFactory extends AbstractDishFactory {

    @Override
    public Pizza createPizza() {
        return new ItalianPizza();
    }

    @Override
    public Spaghetti createSpaghetti() {
        return new Spaghetti("italian");
    }
}
