package designpatterns.prototype.pizzaStore;

import designpatterns.prototype.pizzaStore.dishes.Pizza;
import designpatterns.prototype.pizzaStore.dishes.Spaghetti;

public abstract class AbstractDishFactory {
    public abstract Pizza createPizza();

    public abstract Spaghetti createSpaghetti();
}
