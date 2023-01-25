package designpatterns.factory.pizzaStore.dishes;

import designpatterns.factory.pizzaStore.AbstractDishFactory;

public class AustrianPizzaFactory extends AbstractDishFactory {

    @Override
    public Pizza createPizza() {
        return new AustrianPizza();
    }

    @Override
    public Spaghetti createSpaghetti() {
        return new Spaghetti("austrian");
    }
}
