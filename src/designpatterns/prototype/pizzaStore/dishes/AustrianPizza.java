package designpatterns.prototype.pizzaStore.dishes;


public class AustrianPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("preparing " + this);
        System.out.println("  (very special handling for an austrian pizza)");
    }

    @Override
    public String toString() {
        return "austrian pizza";
    }
}
