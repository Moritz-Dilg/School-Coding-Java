package oop_abstract.power;

public abstract class Consumer extends Device {
    private final int consumption;

    Consumer(String name, int consumption) {
        super(name);
        this.consumption = consumption;
    }

    @Override
    public final int calcConsumption() {
        return consumption;
    }
}
