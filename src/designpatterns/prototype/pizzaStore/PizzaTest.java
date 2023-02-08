package designpatterns.prototype.pizzaStore;

import designpatterns.prototype.pizzaStore.dishes.ItalianPizzaFactory;
import designpatterns.prototype.pizzaStore.dishes.Pizza;
import designpatterns.prototype.pizzaStore.dishes.Spaghetti;

public class PizzaTest {
    public static void main(String[] args) {
        System.out.println("Welcome to the SSW pizza store (implementation using no design pattern)");
        System.out.println("Please select your preferred style:");
        System.out.println("1) Italian style");
        System.out.println("2) American style");


        PizzaStore pizzaStore = new PizzaStore(new ItalianPizzaFactory());

        Pizza pizza = pizzaStore.orderPizza();
        System.out.println("ready to eat " + pizza);
        System.out.println();

        Spaghetti spaghetti = pizzaStore.orderSpaghetti();
        System.out.println("ready to eat " + spaghetti);
        System.out.println();
    }
}
