package designpatterns.prototype.pizzaStore.dishes;

import designpatterns.prototype.pizzaStore.AbstractDishFactory;

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
