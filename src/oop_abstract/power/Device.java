package oop_abstract.power;

public abstract class Device {
    protected final String name;

    Device(String name) {
        this.name = name;
    }

    public abstract int calcConsumption();

    public abstract String toString();
}
