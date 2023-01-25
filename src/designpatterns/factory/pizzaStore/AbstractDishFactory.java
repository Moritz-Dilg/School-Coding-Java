package designpatterns.factory.pizzaStore;

import designpatterns.factory.pizzaStore.dishes.Pizza;
import designpatterns.factory.pizzaStore.dishes.Spaghetti;

public abstract class AbstractDishFactory {
    public abstract Pizza createPizza();

    public  abstract Spaghetti createSpaghetti();
}
