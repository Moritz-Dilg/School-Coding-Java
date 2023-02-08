package designpatterns.prototype.pizzaStore.dishes;

import designpatterns.prototype.pizzaStore.AbstractDishFactory;

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
