package oop_abstract.power;

public final class Computer extends Consumer {

    public Computer(String name, int consumption) {
        super(name, consumption);
    }

    @Override
    public String toString() {
        return this.name + " consumes " + calcConsumption() + " watts";
    }
}
